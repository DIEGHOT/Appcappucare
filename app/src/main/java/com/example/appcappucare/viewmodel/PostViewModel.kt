package com.example.appcappucare.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcappucare.data.model.Post
import com.example.appcappucare.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

open class PostViewModel : ViewModel() {
    private val repository = PostRepository()

    protected val _postList = MutableStateFlow<List<Post>>(emptyList())
    open val postList: StateFlow<List<Post>> = _postList

    init {
        fetchPosts()
    }

    open fun fetchPosts() {
        viewModelScope.launch {
            try {
                _postList.value = repository.getPosts()
            } catch (e: Exception) {
                println("Error al obtener datos: ${e.localizedMessage}")
            }
        }
    }
}