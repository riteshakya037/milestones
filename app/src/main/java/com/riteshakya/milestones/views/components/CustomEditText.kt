package com.riteshakya.milestones.views.components

import android.content.Context
import android.graphics.Rect
import android.graphics.Typeface
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.LinearLayout
import com.riteshakya.milestones.R
import kotlinx.android.synthetic.main.custom_edit_text.view.*


/**
 * @author Ritesh Shakya
 */

class CustomEditText : LinearLayout {

    val editText: EditText
        get() = customEdtText

    var text: String
        get() = customEdtText.text.toString()
        set(text) {
            this.customEdtText.setText(text)
        }

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomEditText)
        init(context,
                nextFocusId = typedArray.getInt(R.styleable.CustomEditText_android_nextFocusForward, 0),
                hintText = typedArray.getString(R.styleable.CustomEditText_android_hint) ?: "",
                labelText = typedArray.getString(R.styleable.CustomEditText_android_label) ?: "",
                inputType = typedArray.getInt(R.styleable.CustomEditText_android_inputType, 0),
                isEnabled = typedArray.getBoolean(R.styleable.CustomEditText_android_enabled, true),
                marginBottom = typedArray.getBoolean(R.styleable.CustomEditText_hasBottomPadding, true))
        typedArray.recycle()
    }

    private fun init(context: Context, nextFocusId: Int = 0, hintText: String = "", labelText: String = "", inputType: Int = 0, isEnabled: Boolean = true, marginBottom: Boolean = true) {
        View.inflate(context, R.layout.custom_edit_text, this)
        customLblText.text = "$labelText:"
        customEdtText.hint = hintText
        customEdtText.inputType = inputType
        customEdtText.nextFocusForwardId = nextFocusId
        setEnabled(isEnabled)
        customEdtText.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(customEdtText, InputMethodManager.SHOW_IMPLICIT)
            } else {
            }
        }

        if (inputType == 129) {
            customEdtText.typeface = Typeface.DEFAULT;
            customEdtText.transformationMethod = PasswordTransformationMethod()
        }

        if (!marginBottom) {
            val lp = customEdtText.layoutParams as LinearLayout.LayoutParams
            lp.bottomMargin = 0
            customEdtText.layoutParams = lp
        }
    }

    override fun onFocusChanged(gainFocus: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        if (gainFocus) {
            customEdtText.requestFocus()
            customEdtText.setSelection(customEdtText.text!!.length)
        }
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect)
    }

    override fun setEnabled(enabled: Boolean) {
        this.customEdtText.isEnabled = enabled
    }
}
