package com.example.appcappucare.repository

import com.example.appcappucare.data.model.Post
import com.example.appcappucare.data.remote.RetrofitInstance

// Usamos 'open' para permitir que los tests de la Guía 15 simulen el comportamiento
open class PostRepository {
    open suspend fun getPosts(): List<Post> {
        return RetrofitInstance.api.getPosts()
    }
}