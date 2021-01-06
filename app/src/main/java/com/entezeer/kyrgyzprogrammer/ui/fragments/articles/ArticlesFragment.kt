package com.entezeer.kyrgyzprogrammer.ui.fragments.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.entezeer.core.base.BaseFragment
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.data.api.ApiEndpoint
import com.entezeer.kyrgyzprogrammer.data.models.Articles
import com.entezeer.kyrgyzprogrammer.databinding.FragmentArticlesBinding
import com.entezeer.kyrgyzprogrammer.ui.fragments.articles.adapter.AdapterArticles
import com.entezeer.kyrgyzprogrammer.ui.fragments.categories.CategoryViewModel
import com.entezeer.kyrgyzprogrammer.ui.fragments.lessons.LessonsFragment
import kotlinx.android.synthetic.main.fragment_articles.*
import retrofit2.Call
import retrofit2.Response

class ArticlesFragment: BaseFragment<ArticlesViewModel>(ArticlesViewModel::class.java, R.layout.fragment_articles) {

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
                    it
                )
        }
        mBinding.progressBar.visibility = View.GONE
    }
}