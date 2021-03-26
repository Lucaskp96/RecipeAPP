package com.example.recipeapp.network

import com.example.recipeapp.model.RecipeResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface RecipeAPI {

    @GET("/api/")
    suspend fun getBreakingRecipe(
    ): Response<RecipeResult>

    @GET("/api/")
    suspend fun searchNews(
        @Query("q")
        searchQuery: String
    ): Response<RecipeResult>
}