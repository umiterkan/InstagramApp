package com.erkan.instagramapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.erkan.instagramapp.R
import com.erkan.instagramapp.data.Resource
import com.erkan.instagramapp.adapter.PostAdapter
import com.erkan.instagramapp.adapter.StoryAdapter
import com.erkan.instagramapp.data.model.Post
import com.erkan.instagramapp.data.model.Story
import com.erkan.instagramapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by umiterkan on 11/9/2020
 */

@AndroidEntryPoint
class HomeFragment : BaseFragment(), PostAdapter.PostListener,StoryAdapter.StoryListener {

    val viewModel: HomeFragmentViewModel by viewModels()
    lateinit var postAdapter: PostAdapter
    lateinit var storyAdapter: StoryAdapter
    private var isLoad: Boolean = false
    override val layoutId: Int get() = R.layout.fragment_home


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postAdapter = PostAdapter(listener = this, type = PostAdapter.TYPE_POST)
        storyAdapter = StoryAdapter(storyListener = this)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler_view_post.adapter = postAdapter
        recycler_view_story.adapter = storyAdapter

        if (!isLoad) {
            observe()
            viewModel.posts()
            viewModel.stories()
            isLoad = true
        }
    }

    private fun observe() {

        viewModel.postListLiveData.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    showLoading(false)
                    postAdapter.submitList(it.data)
                }
                Resource.Status.ERROR -> {
                    showMessageSnack(it.message)
                    showLoading(false)
                }

                Resource.Status.LOADING -> {
                    showLoading(true)
                }
            }

        })

        viewModel.storyLiveData.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    showLoading(false)
                    storyAdapter.submitList(it.data)
                }
                Resource.Status.ERROR -> {
                    showMessageSnack(it.message)
                    showLoading(false)
                }
                Resource.Status.LOADING -> {
                    showLoading(true)
                }
            }
        })

    }

    override fun onPostItemClick(post: Post) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToProfileFragment(post.user))
    }

    override fun onStoryItemClick(story: Story) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToProfileFragment(story.user))
    }


}