package com.erkan.instagramapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.erkan.instagramapp.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Created by umiterkan on 11/11/2020
 */
open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showMessageSnack(message: String?) {
        message?.let {
            val snackbar = Snackbar.make(
                findViewById(R.id.nav_host_container),
                message,
                Snackbar.LENGTH_LONG
            )
            snackbar.show()
        }
    }

    fun showLoading(isShow: Boolean) {
        if (isShow) loading_progressbar.visibility=View.VISIBLE
        else loading_progressbar.visibility=View.GONE
    }
}