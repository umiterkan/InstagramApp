package com.erkan.instagramapp.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.erkan.instagramapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by umiterkan on 11/9/2020
 */


@BindingAdapter(value = ["setImageUrl"])
fun ImageView.bindImageUrl(url: String?) {
    Picasso.get()

        .load(url)
        .placeholder(android.R.drawable.progress_horizontal)
        .into(this)

}

@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>?) {
    this.run {
        adapter?.let {
            this.setHasFixedSize(true)
            this.adapter = adapter
        }
    }
}