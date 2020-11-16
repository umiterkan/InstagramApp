package com.erkan.instagramapp.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.erkan.instagramapp.R
import com.erkan.instagramapp.adapter.PostAdapter
import com.erkan.instagramapp.data.Resource
import com.erkan.instagramapp.data.model.Post
import com.erkan.instagramapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * Created by umiterkan on 11/9/2020
 */

@AndroidEntryPoint
class SearchFragment : BaseFragment(), PostAdapter.PostListener {

    lateinit var postAdapter: PostAdapter
    val viewModel: SearchFragmentViewModel by viewModels()
    override val layoutId: Int get() = R.layout.fragment_search
    private var isLoad: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postAdapter = PostAdapter(listener = this, type = PostAdapter.TYPE_SEARCH)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler_view_post.adapter = postAdapter

        if (!isLoad) {
            observe()
            viewModel.posts()
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
    }

    override fun onPostItemClick(post: Post) {
        showMessageSnack(post.content)
    }

}