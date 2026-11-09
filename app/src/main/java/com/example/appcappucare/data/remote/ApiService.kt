package com.example.appcappucare.data.remote

import com.example.appcappucare.data.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET(value = "/posts")
    suspend fun getPosts(): List<Post>
}