package com.entezeer.kyrgyzprogrammer.ui.fragments.categories

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.data.api.ApiClient
import com.entezeer.kyrgyzprogrammer.data.api.ApiEndpoint
import com.entezeer.kyrgyzprogrammer.data.models.Category
import com.entezeer.kyrgyzprogrammer.databinding.FragmentCategoriesBinding
import com.entezeer.kyrgyzprogrammer.ui.fragments.categories.adapter.AdapterCategories
import com.entezeer.kyrgyzprogrammer.ui.fragments.lessons.LessonsFragment
import kotlinx.android.synthetic.main.fragment_categories.*
import retrofit2.Call
import retrofit2.Response

class CategoriesFragment : Fragment(), AdapterCategories.Listener {

    var categories: ArrayList<Category> = ArrayList()

    private var mBinding: FragmentCategoriesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mBinding != null) return mBinding?.root

        mBinding = FragmentCategoriesBinding.inflate(layoutInflater)

        setUpView()

        return mBinding?.root
    }

    private fun setUpView() {
        val retrofit = ApiClient().getApiclient().create(ApiEndpoint::class.java)
        retrofit.getCategories().enqueue(object : retrofit2.Callback<ArrayList<Category>> {
            override fun onFailure(call: Call<ArrayList<Category>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ArrayList<Category>>,
                response: Response<ArrayList<Category>>
            ) {
                if (response.body() != null) {
                    categories = response.body()!!
                    activity?.let {
                        rcv_categories?.adapter =
                            AdapterCategories(
                                categories,
                                this@CategoriesFragment
                            )
                    }
                    mBinding?.progressBar?.visibility = View.GONE
                }
            }
        })
    }

    @SuppressLint("NewApi")
    override fun onItemSelectedAt(position: Int, title: String, textView: TextView) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.addSharedElement(textView, textView.transitionName)
            ?.replace(
                R.id.fl_container,
                LessonsFragment.newInstance(categories[position].id!!, title, textView.transitionName))
            ?.addToBackStack(LessonsFragment::class.java.canonicalName)
            ?.commit()
    }
}