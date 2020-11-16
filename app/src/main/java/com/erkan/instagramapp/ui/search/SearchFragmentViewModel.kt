package com.erkan.instagramapp.ui.search

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
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

class SearchFragmentViewModel @ViewModelInject constructor(
    val postRepository: PostRepository
) : ViewModel() {

    var postListLiveData = MutableLiveData<Resource<List<Post>>>()

    fun posts() {
        viewModelScope.launch {
            postListLiveData.postValue(Resource.loading())
            postListLiveData.postValue(postRepository.getPosts())
        }
    }


}
