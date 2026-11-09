package com.example.appcappucare

import com.example.appcappucare.data.model.Post
import com.example.appcappucare.data.remote.ApiService
import com.example.appcappucare.repository.PostRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.mockk.coEvery
import io.mockk.mockk

class TestablePostRepository(private val testApi: ApiService) : PostRepository() {
    override suspend fun getPosts(): List<Post> {
        return testApi.getPosts()
    }
}

class PostRepositoryTest : StringSpec({
    "getPosts debe retornar la lista simulada" {
        val fakePosts = listOf(
            Post(userId = 1, id = 1, title = "Titulo 1", body = "Cuerpo 1"),
            Post(userId = 2, id = 2, title = "Titulo 2", body = "Cuerpo 2")
        )

        val mockApi = mockk<ApiService>()
        coEvery { mockApi.getPosts() } returns fakePosts

        val repo = TestablePostRepository(mockApi)
        val result = repo.getPosts()

        result shouldContainExactly fakePosts
    }
})