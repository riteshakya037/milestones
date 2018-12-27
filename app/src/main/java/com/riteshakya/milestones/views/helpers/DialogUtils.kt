package com.riteshakya.milestones.views.helpers

import android.app.ProgressDialog
import android.content.Context

/**
 * @author Ritesh Shakya
 */

object DialogUtils {
    private var dialog: ProgressDialog? = null

    fun hideDialog() {
        if (dialog != null && dialog!!.isShowing) {
            dialog!!.dismiss()
            dialog = null
        }
    }

    fun showDialog(context: Context) {
        dialog = ProgressDialog(context)
        dialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        dialog!!.setMessage("Please wait...")
        dialog!!.isIndeterminate = true
        dialog!!.setCancelable(false)
        dialog!!.setCanceledOnTouchOutside(false)
        dialog!!.show()
    }
}
