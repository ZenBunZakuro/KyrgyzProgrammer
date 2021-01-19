package com.entezeer.kyrgyzprogrammer.ui.fragments.categories

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.entezeer.core.base.BaseFragment
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.data.models.Category
import com.entezeer.kyrgyzprogrammer.databinding.FragmentCategoriesBinding
import com.entezeer.kyrgyzprogrammer.ui.fragments.categories.adapter.AdapterCategories
import com.entezeer.kyrgyzprogrammer.ui.fragments.lessons.LessonsFragment
import kotlinx.android.synthetic.main.fragment_categories.*

class CategoriesFragment :
    BaseFragment<CategoryViewModel>(CategoryViewModel::class.java, R.layout.fragment_categories),
    AdapterCategories.Listener {

    private var mBinding: FragmentCategoriesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mBinding != null) return mBinding?.root

        mBinding = FragmentCategoriesBinding.inflate(layoutInflater)

        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()

        setupView()
    }

    private fun setupView() {
        mBinding?.swipeToRefreshCategories?.setOnRefreshListener {
            vm.fetchCategories()
        }
    }

    private fun subscribeToLiveData() {
        vm.fetchCategories()
        vm.categories.observe(viewLifecycleOwner, Observer {
            showCategories(it)
        })
    }

    private fun showCategories(categories: ArrayList<Category>) {
        activity?.let {
        rcv_categories?.adapter =
            AdapterCategories(
                categories,
                this@CategoriesFragment
            )
    }
        mBinding?.progressBar?.visibility = View.GONE
        mBinding?.swipeToRefreshCategories?.isRefreshing = false
    }

    @SuppressLint("NewApi")
    override fun onItemSelectedAt(position: Int, title: String, textView: TextView) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.addSharedElement(textView, textView.transitionName)
            ?.replace(
                R.id.fl_container,
                LessonsFragment.newInstance(
                    vm.categories.value?.get(position)?.id!!,
                    title,
                    textView.transitionName
                )
            )
            ?.addToBackStack(LessonsFragment::class.java.canonicalName)
            ?.commit()
    }
}