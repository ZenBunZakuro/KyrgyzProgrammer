package com.entezeer.kyrgyzprogrammer.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.entezeer.kyrgyzprogrammer.databinding.ActivityLessonContentBinding

class LessonContentActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityLessonContentBinding
    private lateinit var mToolbar: Toolbar

    companion object {
        const val TEXT = "text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLessonContentBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mToolbar = mBinding.contentToolbar
        setSupportActionBar(mToolbar)

        supportActionBar?.apply {
            title = intent.getStringExtra(TEXT)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }
}