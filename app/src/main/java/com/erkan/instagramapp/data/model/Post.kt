package com.erkan.instagramapp.data.model

import java.io.Serializable


/**
 * Created by umiterkan on 11/9/2020
 */


data class Post (
    val id: String,
    val content: String,
    val likeCount: Int,
    val dislikeCount: Int,
    val imageUrl: String,
    val user: User?,
    val comments:List<Comment>?
)