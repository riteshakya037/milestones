package com.ydl.android.utils

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import com.ydl.android.utils.validation.Validation
import com.ydl.android.utils.validation.ValidationResult
import com.ydl.android.views.components.CustomEditText
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}

fun CustomEditText.addValidity(validation: Validation): Observable<Boolean> {
    return this.editText.addValidity(validation)
}

fun EditText.addValidity(validation: Validation): Observable<Boolean> {
    return Observable.create(ObservableOnSubscribe<String> {
        it.onNext("")
        this.afterTextChanged { s: String -> it.onNext(s) }
    })
            .debounce(200, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .map { input: String -> validation.validate(input) }
            .map { result: ValidationResult<Any> -> result.isValid }
}


fun View.toggle() {
    when (visibility) {
        View.INVISIBLE -> visibility = View.VISIBLE
        View.VISIBLE -> visibility = View.INVISIBLE
    }
}