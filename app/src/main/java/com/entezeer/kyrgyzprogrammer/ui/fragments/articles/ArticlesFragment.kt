package com.entezeer.kyrgyzprogrammer.ui.fragments.articles

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.entezeer.core.base.BaseFragment
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.data.models.Articles
import com.entezeer.kyrgyzprogrammer.databinding.FragmentArticlesBinding
import com.entezeer.kyrgyzprogrammer.ui.activities.ArticlesContentActivity
import com.entezeer.kyrgyzprogrammer.ui.fragments.articles.adapter.AdapterArticles
import kotlinx.android.synthetic.main.fragment_articles.*

class ArticlesFragment: BaseFragment<ArticlesViewModel>(ArticlesViewModel::class.java, R.layout.fragment_articles),
    AdapterArticles.Listener {

    private lateinit var mBinding: FragmentArticlesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentArticlesBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
        setupView()
    }

    private fun setupView() {
        mBinding.swipeToRefreshArticles.setOnRefreshListener {
            vm.fetchArticles()
        }
    }

    private fun subscribeToLiveData() {
        vm.fetchArticles()
        vm.articles.observe(viewLifecycleOwner, Observer {
            showArticles(it)
        })
    }

    private fun showArticles(articles: ArrayList<Articles>) {
        activity?.let {
            rcv_articles?.adapter =
                AdapterArticles(
                    articles,
                    it,
                    this@ArticlesFragment
                )
        }
        mBinding.progressBar.visibility = View.GONE
        mBinding.swipeToRefreshArticles.isRefreshing = false
    }

    override fun onItemSelectedAt(position: Int) {
        startActivity(Intent(activity, ArticlesContentActivity::class.java))
    }
}