package com.entezeer.kyrgyzprogrammer.ui.settings.about_us

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.entezeer.kyrgyzprogrammer.BuildConfig
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.data.models.Lessons
import com.entezeer.kyrgyzprogrammer.databinding.ActivityAboutUsBinding
import com.entezeer.kyrgyzprogrammer.ui.lessons.LessonContentActivity

class AboutUsActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAboutUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setupview()
    }

    fun setupview(){
        setSupportActionBar(mBinding.toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        mBinding.appVersion.text = getString(R.string.version, BuildConfig.VERSION_NAME)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
            }
        }
        return true
    }

    companion object {
        fun start(context: Context){
            val intent = Intent(context, AboutUsActivity::class.java)

            startActivity(context, intent, Bundle())
        }
    }
}