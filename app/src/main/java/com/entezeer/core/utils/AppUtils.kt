package com.entezeer.core.utils

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity

object AppUtils {
    object Utils {
        fun progressShow(progress: ProgressDialog?) {
            progress?.setMessage("Loading")
            progress?.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            progress?.isIndeterminate = true
            progress?.progress = 0
            progress?.setCancelable(false)
            progress?.show()
        }

        fun rateApp(context: Context, packageName: String) {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
            )
            startActivity(context, intent, Bundle())
        }

        fun shareApp(context: Context, packageName: String) {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Kyrgyz Programmer")
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "https://play.google.com/store/apps/details?id=$packageName"
            )
            startActivity(context, Intent.createChooser(intent, "Share to "), Bundle())
        }

        fun shareUrl(context: Context, url: String) {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(
                Intent.EXTRA_TEXT,
                url
            )
            startActivity(context, Intent.createChooser(intent, "Share to "), Bundle())
        }

        fun reportBug(context: Context) {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:entezeer@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "ERROR_REPORT")
            startActivity(context, Intent.createChooser(intent, "Send Report"), Bundle())
        }

        fun contactUs(context: Context) {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:entezeer@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "CONTACT")
            startActivity(context, Intent.createChooser(intent, "Send Report"), Bundle())
        }
    }
}