package com.erkan.instagramapp.data.repository

import com.erkan.instagramapp.data.Resource
import com.erkan.instagramapp.data.model.Post
import com.erkan.instagramapp.data.model.Story
import javax.inject.Inject

/**
 * Created by umiterkan on 11/12/2020

 */

class PostRepository @Inject constructor(val postRemoteDataSource: PostRemoteDataSource) {

    suspend fun getPosts(): Resource<List<Post>> {
        return postRemoteDataSource.getPostList()
    }

}

class StoryRepository @Inject constructor(val storyRemoteDataSource: StoryRemoteDataSource) {

    suspend fun getStories(): Resource<List<Story>> {
        return storyRemoteDataSource.getStoryList()
    }

}