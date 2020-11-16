package com.erkan.instagramapp.data.repository

import android.util.Log
import com.erkan.instagramapp.data.Resource
import retrofit2.Response

/**
 * Created by umiterkan on 11/10/2020
 */

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            Log.d("msg", "call exception")
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        Log.d("msg", "Network failed  $message")
        return Resource.error("Network failed : $message")
    }

}