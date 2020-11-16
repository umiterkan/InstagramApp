package com.erkan.instagramapp.data.repository

import com.erkan.instagramapp.di.ApiServices
import javax.inject.Inject

/**
 * Created by umiterkan on 11/12/2020
 */
class PostRemoteDataSource @Inject constructor(val provideServices: ApiServices):
    BaseDataSource()
{
    suspend fun getPostList() = getResult { provideServices.getPostList() }
}


class StoryRemoteDataSource @Inject constructor(val provideServices: ApiServices): BaseDataSource()
{
    suspend fun getStoryList() = getResult { provideServices.getStoryList() }

}