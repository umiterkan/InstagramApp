package com.erkan.instagramapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.erkan.instagramapp.databinding.ItemPostBinding
import com.erkan.instagramapp.data.model.Post
import com.erkan.instagramapp.databinding.ItemSearchBinding

/**
 * Created by umiterkan on 11/9/2020
 */


class PostAdapter(val listener: PostListener, val type: Int) :
    ListAdapter<Post, RecyclerView.ViewHolder>(Companion) {

    class PostViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root)

    class SearchViewHolder(val binding: ItemSearchBinding) : RecyclerView.ViewHolder(binding.root)


    companion object : DiffUtil.ItemCallback<Post>() {
        const val TYPE_POST: Int = 0
        const val TYPE_SEARCH: Int = 1
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean =
            oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        if (type == 0) {
            val binding = ItemPostBinding.inflate(layoutInflater)
            return PostViewHolder(binding)
        } else {
            val binding = ItemSearchBinding.inflate(layoutInflater)
            return SearchViewHolder(binding)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentPost = getItem(position)
        if (type == 0) {
            val postHolder = holder as PostViewHolder
            postHolder.binding.apply {
                post = currentPost
                myListener = listener
                executePendingBindings()
            }
        } else {
            val searchHolder = holder as SearchViewHolder
            searchHolder.binding.apply {
                post = currentPost
                myListener = listener
                executePendingBindings()
            }

        }

    }

    interface PostListener {
        fun onPostItemClick(post: Post)
    }


}