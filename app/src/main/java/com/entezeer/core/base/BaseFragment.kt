package com.entezeer.dobush.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

//open class BaseFragment<viewModel: BaseViewModel<*>>
//    (
//    private var viewModelClass: Class<viewModel>,
//    @LayoutRes private var layoutId: Int
//) : DaggerFragment() {
//
//    @Inject
//    lateinit var factory: ViewModelFactory
//    lateinit var vm: viewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        vm = ViewModelProvider(this, factory).get(viewModelClass)
//    }
//}