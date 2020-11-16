package com.erkan.instagramapp.ui.home

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erkan.instagramapp.data.Resource
import com.erkan.instagramapp.data.model.Post
import com.erkan.instagramapp.data.model.Story
import com.erkan.instagramapp.data.repository.PostRepository
import com.erkan.instagramapp.data.repository.StoryRepository
import kotlinx.coroutines.launch

/**
 * Created by umiterkan on 11/10/2020
 */

class HomeFragmentViewModel @ViewModelInject constructor(
    val postRepository: PostRepository,
    val storyRepository: StoryRepository
) : ViewModel() {

    var postListLiveData = MutableLiveData<Resource<List<Post>>>()
    var storyLiveData = MutableLiveData<Resource<List<Story>>>()

    var postResult: Resource<List<Post>>? = null
    var storyResult: Resource<List<Story>>? = null

    fun posts() {
        if (postResult == null) {
            viewModelScope.launch {
                postListLiveData.postValue(Resource.loading())
                postResult = postRepository.getPosts()
                postListLiveData.postValue(postResult)
            }
        } else {
            postListLiveData.postValue(postResult)
        }
    }

    fun stories() {
        if (storyResult == null) {
            viewModelScope.launch {
                storyLiveData.postValue(Resource.loading())
                storyResult=storyRepository.getStories();
                storyLiveData.postValue(storyResult)
            }
        } else {
            storyLiveData.postValue(storyResult)
        }

    }


}
