package com.entezeer.kyrgyzprogrammer.ui.articles

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.entezeer.kyrgyzprogrammer.data.models.Articles
import com.entezeer.kyrgyzprogrammer.databinding.ActivityArticlesContentBinding
import com.entezeer.kyrgyzprogrammer.ui.lessons.LessonContentActivity

class ArticlesContentActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityArticlesContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityArticlesContentBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setupView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupView() {
        setSupportActionBar(mBinding.contentToolbar)

        supportActionBar?.apply {
            title = articles?.title
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        mBinding.wvContent.apply {
            settings.javaScriptEnabled = true
            setBackgroundColor(Color.TRANSPARENT)
            articles?.content?.let { loadData("<html><style>.wrap{}</style><body><div class='wrap'>$it</div></body></html>", "text/html; charset=UTF-8", null) }
        }

        Glide.with(this).load(articles?.img).into(mBinding.ivContentImage)
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
        private var articles: Articles? = null

        fun start(context: Context, articles: Articles){
            val intent = Intent(context, ArticlesContentActivity::class.java)

            ArticlesContentActivity.articles = articles

            startActivity(context, intent, Bundle())
        }
    }
}