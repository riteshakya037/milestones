package com.ydl.android.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.ydl.android.di.components.ApplicationComponent
import com.ydl.android.utils.combineLatest
import com.ydl.android.utils.navigation.Navigator
import com.ydl.android.utils.ui.UIHelper
import com.ydl.android.views.components.PromptDialog
import com.ydl.android.views.helpers.DialogUtils
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

abstract class BaseFragment<T> : Fragment() {

    private var presenters: ArrayList<BasePresenter<*>> = ArrayList()
    private var observerList: ArrayList<Observable<Boolean>> = ArrayList()
    protected var navigator: Navigator = Navigator()
    protected var uiHelper: UIHelper = UIHelper()
    private var disposables: Array<Disposable>? = null

    init {
        retainInstance = true
    }

    fun activity(): BaseActivity {
        return activity as BaseActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }

    @LayoutRes
    abstract fun getLayout(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val component: T = initInjector()
        injectFragment(component)
        initViews()
    }

    fun Fragment.showDialogPrompt(title: String, description: String, actionName: String, onComplete: () -> Unit = {}, onCancel: () -> Unit = {}) {
        val promptDialog = PromptDialog.Builder(context!!).setTitle(title)
                .setDescription(description)
                .setAction(actionName)
                .setOnDialogListener {
                    onComplete()
                }
                .create()
        promptDialog.setOnDismissListener { onCancel() }
        promptDialog.show()
    }


    abstract fun injectFragment(component: T)

    protected val applicationComponent: ApplicationComponent
        get() = activity().getApp().appComponent


    fun <T : BaseView> addPresenter(presenter: BasePresenter<T>, view: T) {
        presenter.setView(view)
        presenters.add(presenter)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenters.forEach { it.onCreate() }
    }

    override fun onResume() {
        super.onResume()
        presenters.forEach { it.onResume() }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenters.forEach { it.onDestroy() }
        disposables?.forEach { it.dispose() }
    }

    override fun onPause() {
        super.onPause()
        presenters.forEach { it.onPause() }
    }

    open fun showProgressDialog() {
        DialogUtils.showDialog(context!!)
    }

    open fun hideProgressDialog() {
        DialogUtils.hideDialog()
    }

    abstract fun initViews()

    abstract fun initInjector(): T

    protected fun addValidationList(addValidity: Observable<Boolean>) {
        observerList.add(addValidity)
        initializeValidationObservers()
    }

    private fun initializeValidationObservers() {
        observerList.combineLatest { it: List<Boolean> ->
            var output = true
            for (result: Boolean in it)
                if (!result && output) {
                    output = false
                }
            output
        }.subscribe { result -> setValidity(result) }
    }

    open fun setValidity(result: Boolean) {}

    fun showInAppError(title: String, message: String, callback: Callback?) {
        AlertDialog.Builder(context!!)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(getString(android.R.string.ok)) { dialog, _ ->
                    dialog.dismiss()
                }
                .setOnDismissListener {
                    callback?.onDismissed()
                }
                .show()
    }

    interface Callback {
        fun onDismissed()
    }

    fun showInAppError(title: String, message: String) {
        hideProgressDialog()
        showInAppError(title, message, null)
    }

    protected fun dismissAllExceptEditText() {
        uiHelper.setupTouchUIException(view, View.OnTouchListener { v, _ ->
            v.postDelayed({ uiHelper.hideSoftKeyboard(activity) }, 100)
            false
        }, null)
    }

    fun addDisposables(vararg disposables: Disposable) {
        this.disposables = arrayOf(*disposables)
    }
}