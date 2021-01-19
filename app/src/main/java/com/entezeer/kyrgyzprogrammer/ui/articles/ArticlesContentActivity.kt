package com.entezeer.kyrgyzprogrammer.ui.articles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.entezeer.kyrgyzprogrammer.data.models.Articles
import com.entezeer.kyrgyzprogrammer.databinding.ActivityArticlesContentBinding

class ArticlesContentActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityArticlesContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityArticlesContentBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    private fun setupView() {
        setSupportActionBar(mBinding.contentToolbar)

        supportActionBar?.apply {
            title = articles?.title
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    companion object {
        private var articles: Articles? = null

    }
}