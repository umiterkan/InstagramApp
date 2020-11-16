package com.erkan.instagramapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.erkan.instagramapp.data.model.Post
import com.erkan.instagramapp.data.model.Story
import com.erkan.instagramapp.databinding.ItemStoryBinding

/**
 * Created by umiterkan on 11/9/2020
 */


class StoryAdapter(val storyListener: StoryListener) : ListAdapter<Story, StoryAdapter.StoryViewHolder>(Companion) {

    class StoryViewHolder(val binding: ItemStoryBinding) : RecyclerView.ViewHolder(binding.root)

    companion object : DiffUtil.ItemCallback<Story>() {
        override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean =
            oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemStoryBinding.inflate(layoutInflater)

        return StoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val currentStory = getItem(position)
        holder.binding.story = currentStory
        holder.binding.storyListener=storyListener
        holder.binding.executePendingBindings()
    }

    interface StoryListener {
        fun onStoryItemClick(story: Story)
    }
}