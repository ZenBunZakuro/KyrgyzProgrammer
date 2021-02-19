package com.entezeer.kyrgyzprogrammer.ui.lessons

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.data.models.Lessons
import com.entezeer.kyrgyzprogrammer.databinding.ActivityLessonContentBinding

class LessonContentActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityLessonContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLessonContentBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setupView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupView(){
        setSupportActionBar(mBinding.contentToolbar)

        supportActionBar?.apply {
            title = lesson?.title
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        mBinding.wvContent.apply {
            settings.javaScriptEnabled = true
            setBackgroundColor(Color.TRANSPARENT)
            lesson?.content?.let { loadData("<html><style>.wrap{}</style><body><div class='wrap'>$it</div></body></html>", "text/html; charset=UTF-8", null) }
        }

        Glide.with(this).load(lesson?.img).into(mBinding.ivContentImage)
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
        private var lesson: Lessons? = null

        fun start(context: Context, lessons: Lessons){
            val intent = Intent(context, LessonContentActivity::class.java)

            lesson = lessons

            startActivity(context, intent, Bundle())
        }
    }
}
