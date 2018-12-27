package com.ydl.android.views.components

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.NonNull
import com.ydl.android.R
import kotlinx.android.synthetic.main.custom_prompt_dialog.*

class PromptDialog(context: Context) : Dialog(context), android.view.View.OnClickListener {

    private lateinit var builder: Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.custom_prompt_dialog)
        yesBtn.setOnClickListener(this)
        noBtn.setOnClickListener(this)
        yesBtn.text = builder.action
        titleTxt.text = builder.title
        descriptionTxt.text = builder.description
        window?.setLayout((getScreenWidth() * .8).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    private fun getScreenWidth(): Int {
        return Resources.getSystem().displayMetrics.widthPixels
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.yesBtn -> {
                builder.onAction()
                dismiss()
            }
            R.id.noBtn -> {
                dismiss()
            }

        }
        dismiss()
    }


    class Builder(@param:NonNull var context: Context) {

        internal lateinit var onAction: () -> Unit
        internal var title: String = "Confirm"
        internal var description: String = "Are you sure you want to perform that action"
        internal var action: String = "Ok"

        fun setOnDialogListener(onAction: () -> Unit): Builder {
            this.onAction = onAction
            return this
        }

        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        fun setDescription(description: String): Builder {
            this.description = description
            return this
        }

        fun setAction(action: String): Builder {
            this.action = action
            return this
        }


        fun create(): PromptDialog {

            if (!::onAction.isInitialized) {
                throw RuntimeException("You have to use setOnDialogListener() for receive events")
            }

            val dialogFragment = PromptDialog(context)

            dialogFragment.builder = this
            return dialogFragment
        }
    }

    interface DialogListener {
        fun onAction(): Unit
    }
}