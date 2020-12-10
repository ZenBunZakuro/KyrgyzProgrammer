package com.entezeer.kyrgyzprogrammer.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.entezeer.kyrgyzprogrammer.data.api.ApiClient
import com.entezeer.kyrgyzprogrammer.data.api.ApiEndpoint
import com.entezeer.kyrgyzprogrammer.databinding.FragmentHomeBinding
import com.entezeer.kyrgyzprogrammer.data.models.Lessons
import com.entezeer.kyrgyzprogrammer.ui.home.adapter.AdapterHome
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class HomeFragment : Fragment() {
    var lessons: ArrayList<Lessons> = ArrayList()

    private lateinit var mBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(layoutInflater)

        return mBinding.root




    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpView()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun setUpView() {
        mBinding.idHomeRecycle.layoutManager = LinearLayoutManager(context)
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
                        id_home_recycle.adapter = AdapterHome(lessons, it)
                    }
                }
            }

        })
    }
}