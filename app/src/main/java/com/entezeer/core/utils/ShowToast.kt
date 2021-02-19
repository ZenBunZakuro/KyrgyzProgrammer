package com.entezeer.core.utils

import android.content.Context
import android.widget.Toast

object ShowToast {

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}