package com.entezeer.kyrgyzprogrammer.ui.fragments.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.entezeer.kyrgyzprogrammer.data.api.ApiClient
import com.entezeer.kyrgyzprogrammer.data.api.ApiEndpoint
import com.entezeer.kyrgyzprogrammer.data.models.Articles
import com.entezeer.kyrgyzprogrammer.databinding.FragmentArticlesBinding
import com.entezeer.kyrgyzprogrammer.ui.fragments.articles.adapter.AdapterArticles
import kotlinx.android.synthetic.main.fragment_articles.*
import retrofit2.Call
import retrofit2.Response

class ArticlesFragment : Fragment() {

    var Articles: ArrayList<Articles> = ArrayList()

    private lateinit var mBinding: FragmentArticlesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentArticlesBinding.inflate(layoutInflater)
        setUpView()
        return mBinding.root
    }

    private fun setUpView() {


        val retrofit = ApiClient().getApiclient().create(ApiEndpoint::class.java)
        retrofit.getArticles().enqueue(object : retrofit2.Callback<ArrayList<Articles>> {
            override fun onFailure(call: Call<ArrayList<Articles>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ArrayList<Articles>>,
                response: Response<ArrayList<Articles>>
            ) {
                if (response.body() != null) {
                    Articles = response.body()!!
                    activity?.let {
                        rcv_articles?.adapter =
                            AdapterArticles(
                                Articles,
                                it
                            )
                    }
                    mBinding?.progressBar?.visibility = View.GONE
                }
            }
        })
    }
}