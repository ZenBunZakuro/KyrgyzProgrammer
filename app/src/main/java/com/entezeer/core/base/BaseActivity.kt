package com.entezeer.dobush.ui.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

//open class BaseActivity<viewModel: BaseViewModel<*>>(private var viewModelClass: Class<viewModel>, @LayoutRes private var layoutRes: Int):
//    DaggerAppCompatActivity() {
//
//    @Inject
//    lateinit var factory: ViewModelFactory
//    lateinit var viewModel: viewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(layoutRes)
//        viewModel = ViewModelProvider(this, factory).get(viewModelClass)
//    }
//
//    fun hideKeyboard(view: View?) {
//        view?.let {
//            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
//            inputMethodManager?.hideSoftInputFromWindow(it.windowToken, 0)
//        }
//    }
//}

