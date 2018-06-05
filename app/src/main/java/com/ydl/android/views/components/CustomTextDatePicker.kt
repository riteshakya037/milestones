package com.ydl.android.views.components

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Rect
import android.support.constraint.ConstraintLayout
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import com.ydl.android.R
import com.ydl.android.utils.DateUtils
import com.ydl.android.utils.validation.ValidationResult
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.custom_edit_text_date_picker.view.*
import org.joda.time.DateTime
import java.util.*

/**
 * @author Ritesh Shakya
 */

class CustomTextDatePicker : ConstraintLayout {

    private var observable = PublishSubject.create<ValidationResult<String>>()
    private var mDate = DateTime()

    val editText: EditText
        get() = customEdtText


    var date: DateTime
        get() = mDate
        set(date) {
            mDate = date
            setDate()
        }


    var text: String
        get() = customEdtText.text.toString()
        set(text) {
            this.customEdtText.setText(text)
            if (!TextUtils.isEmpty(text)) {
                this.mDate = DateUtils.getIncomingDateFormat(text)
            }
            observable.onNext(ValidationResult.success(text))
        }

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomTextDatePicker)
        init(context,
                typedArray.getString(R.styleable.CustomTextDatePicker_android_hint),
                typedArray.getBoolean(R.styleable.CustomTextDatePicker_android_enabled, true))
        typedArray.recycle()
    }

    private fun init(context: Context, hintText: String? = "", isEnabled: Boolean = true) {
        View.inflate(context, R.layout.custom_edit_text_date_picker, this)
        customEdtText.hint = hintText
        setEnabled(isEnabled)
        customEdtText.setOnClickListener {
            val calendar = GregorianCalendar()
            val datePickerDialog = DatePickerDialog(context,
                    AlertDialog.THEME_HOLO_LIGHT, { _, year, month, dayOfMonth ->
                mDate = DateTime(year, month + 1, dayOfMonth, 0, 0)
                setDate()
                observable.onNext(ValidationResult.success(text))
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH))

            datePickerDialog.datePicker.maxDate = Date().time
            datePickerDialog.setTitle(customEdtText.hint)
            datePickerDialog.show()
        }
    }

    override fun onFocusChanged(gainFocus: Boolean, direction: Int,
                                previouslyFocusedRect: Rect?) {
        if (gainFocus) customEdtText.requestFocus()
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect)
    }

    private fun setDate() {
        customEdtText.setText(DateUtils.getOutGoingDateFormat(mDate))
    }

    public fun getObservable(): Observable<Boolean> {
        return observable.map { it.isValid }
    }

    override fun setEnabled(enabled: Boolean) {
        this.customEdtText.isEnabled = enabled
        this.customEdtText.isClickable = enabled
    }
}
