package com.entezeer.kyrgyzprogrammer.ui.fragments.lessons

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.entezeer.core.base.BaseFragment
import com.entezeer.core.utils.TransitionUtil
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.data.models.Lessons
import com.entezeer.kyrgyzprogrammer.databinding.FragmentLessonsBinding
import com.entezeer.kyrgyzprogrammer.ui.activities.LessonContentActivity
import com.entezeer.kyrgyzprogrammer.ui.fragments.lessons.adapter.AdapterLessons
import kotlinx.android.synthetic.main.fragment_lessons.*


class LessonsFragment :
    BaseFragment<LessonsViewModel>(LessonsViewModel::class.java, R.layout.fragment_lessons),
    AdapterLessons.Listener {

    private lateinit var mBinding: FragmentLessonsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentLessonsBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        arguments?.getInt(ARG_ID)?.let { vm.fetchLessons(it) }
        vm.lessons.observe(viewLifecycleOwner, Observer {
            showLessons(it)
        })
    }

    private fun showLessons(lessons: ArrayList<Lessons>) {
        activity?.let {
            rcv_lessons?.adapter =
                AdapterLessons(
                    lessons,
                    this@LessonsFragment
                )
        }
        mBinding.progressBar.visibility = View.GONE
    }

    @SuppressLint("NewApi")
    private fun setUpView() {
        tv_title.transitionName = arguments?.getString(ARG_TRANSITION_NAME)
        tv_title.text = arguments?.getString(ARG_ITEM)
    }

    companion object {
        private const val ARG_ID = "id"
        private const val ARG_ITEM = "item"
        private const val ARG_TRANSITION_NAME = "transition"

        fun newInstance(id: Int, title: String, transitionName: String): Fragment =
            LessonsFragment().apply {
                sharedElementEnterTransition = TransitionUtil()
                sharedElementReturnTransition = TransitionUtil()

                val bundle = Bundle()
                bundle.putInt(ARG_ID, id)
                bundle.putString(ARG_ITEM, title)
                bundle.putString(ARG_TRANSITION_NAME, transitionName)

                arguments = bundle
            }

    }

    @SuppressLint("NewApi")
    override fun onItemSelectedAt(position: Int) {
        activity?.let { LessonContentActivity.start(it, vm.lessons.value?.get(position)!!) }
    }
}