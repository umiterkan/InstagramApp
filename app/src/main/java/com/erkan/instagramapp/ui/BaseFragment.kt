package com.erkan.instagramapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by umiterkan on 11/12/2020
 */

abstract class BaseFragment : Fragment() {

    abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    fun showLoading(isLoading: Boolean) {
        (activity as BaseActivity).showLoading(isLoading)
    }

    fun showMessageSnack(message: String?) {
        (activity as BaseActivity).showMessageSnack(message)
    }

}