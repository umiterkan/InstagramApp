package com.erkan.instagramapp.di

import com.erkan.instagramapp.data.model.Post
import com.erkan.instagramapp.data.model.Story
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by umiterkan on 11/10/2020
 */

interface ApiServices {
    @GET("clPMLCPtaq?indent=2")
    suspend fun getPostList(): Response<List<Post>>

    @GET("cqwlfXxViW?indent=2")
    suspend fun getStoryList(): Response<List<Story>>
}