package com.entezeer.kyrgyzprogrammer.ui.fragments.home.lessons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.entezeer.kyrgyzprogrammer.data.api.ApiClient
import com.entezeer.kyrgyzprogrammer.data.api.ApiEndpoint
import com.entezeer.kyrgyzprogrammer.data.models.Lessons
import com.entezeer.kyrgyzprogrammer.databinding.FragmentLessonsBinding
import com.entezeer.kyrgyzprogrammer.ui.fragments.home.adapter.AdapterLessons
import kotlinx.android.synthetic.main.fragment_lessons.*
import retrofit2.Call
import retrofit2.Response

class LessonsFragment : Fragment() {

    var lessons: ArrayList<Lessons> = ArrayList()

    private lateinit var mBinding: FragmentLessonsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentLessonsBinding.inflate(layoutInflater)
        setUpView()
        return mBinding.root
    }

    private fun setUpView() {


        val retrofit = ApiClient().getApiclient().create(ApiEndpoint::class.java)
        retrofit.getLessons().enqueue(object : retrofit2.Callback<ArrayList<Lessons>> {
            override fun onFailure(call: Call<ArrayList<Lessons>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ArrayList<Lessons>>,
                response: Response<ArrayList<Lessons>>
            ) {
                if (response.body() != null) {
                    lessons = response.body()!!
                    activity?.let {
                        rcv_lessons?.adapter = AdapterLessons(lessons, it)
                    }
                }
            }
        })
    }
}