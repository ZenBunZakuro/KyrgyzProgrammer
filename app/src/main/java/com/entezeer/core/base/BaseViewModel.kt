package com.entezeer.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

open class BaseViewModel<Event>: ViewModel() {
    //@Inject
    //lateinit var serverErrorHandler: ServerErrorHandler
    var event: MutableLiveData<Event> = MutableLiveData()

    fun runWithErrorHandling(
        call: suspend() -> Unit,
        finally: (suspend() -> Unit)? = null
    ) {
        viewModelScope.launch {
            try {
                call()
            }catch (e: Throwable) {
                when(e) {
//                    is UnknownHostException -> serverErrorHandler.onNoInternetConnectionError()
                    else -> handleError(e)
                }
            } finally {
                finally?.invoke()
            }
        }
    }

    open fun handleError(e: Throwable) {
//        serverErrorHandler.onUnknownError(e)
    }
}

