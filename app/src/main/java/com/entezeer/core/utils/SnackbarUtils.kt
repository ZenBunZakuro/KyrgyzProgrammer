package com.entezeer.core.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

object SnackbarUtils {
    private var snackbar: Snackbar? = null

    fun showSnackBar(view: View, text: String, anchor: View? = null) {
        snackbar = Snackbar.make(view, text, Snackbar.LENGTH_INDEFINITE)
        if (anchor != null) snackbar?.anchorView = anchor
        snackbar?.show()
    }

    fun hideSnackBar() {
        if (snackbar != null) {
            snackbar?.dismiss()
        }
    }
}