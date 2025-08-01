package com.plcoding.cryptotracker.core.presentation.util

import android.content.Context
import com.plcoding.cryptotracker.R
import com.plcoding.cryptotracker.core.domain.utils.NetworkError

fun NetworkError.toString(context : Context): String{
    val resId =  when(this) {
        NetworkError.REQUEST_TIMEOUT -> R.string.request_timeout
        NetworkError.TOO_MANY_REQUEST -> R.string.too_many_req
        NetworkError.SERVER_ERROR -> R.string.server_error
        NetworkError.NO_INTERNET -> R.string.no_internet
        NetworkError.SERIALIZATION -> R.string.serialization_error
        NetworkError.UNKNOWN -> R.string.unknown_error
    }
    return context.getString(resId)
}