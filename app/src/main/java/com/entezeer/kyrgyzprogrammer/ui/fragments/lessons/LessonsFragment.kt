package com.entezeer.kyrgyzprogrammer.ui.fragments.lessons

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.entezeer.core.utils.TransitionUtil
import com.entezeer.kyrgyzprogrammer.data.api.ApiClient
import com.entezeer.kyrgyzprogrammer.data.api.ApiEndpoint
import com.entezeer.kyrgyzprogrammer.data.models.Lessons
import com.entezeer.kyrgyzprogrammer.databinding.FragmentLessonsBinding
import com.entezeer.kyrgyzprogrammer.ui.activities.LessonContentActivity
import com.entezeer.kyrgyzprogrammer.ui.fragments.lessons.adapter.AdapterLessons
import kotlinx.android.synthetic.main.fragment_lessons.*
import retrofit2.Call
import retrofit2.Response


class LessonsFragment : Fragment(), AdapterLessons.Listener {

    var lessons: ArrayList<Lessons> = ArrayList()

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
    }

    @SuppressLint("NewApi")
    private fun setUpView() {
        tv_title.transitionName = arguments?.getString(ARG_TRANSITION_NAME)
        tv_title.text = arguments?.getString(ARG_ITEM)

        val retrofit = ApiClient().getApiclient().create(ApiEndpoint::class.java)
        retrofit.getLessonsByCategory(arguments?.getInt(ARG_ID))
            .enqueue(object : retrofit2.Callback<ArrayList<Lessons>> {
                override fun onFailure(call: Call<ArrayList<Lessons>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ArrayList<Lessons>>,
                    response: Response<ArrayList<Lessons>>
                ) {
                    if (response.body() != null) {
                        lessons = response.body()!!
                        activity?.let {
                            rcv_lessons?.adapter =
                                AdapterLessons(
                                    lessons,
                                    this@LessonsFragment
                                )
                        }
                        mBinding.progressBar.visibility = View.GONE
                    }
                }
            })
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
        activity?.let { LessonContentActivity.start(it, lessons[position]) }
    }
}