package com.example.recipeapp.model

data class RecipeResult(
    val href: String,
    val results: MutableList<Result>,
    val title: String,
    val version: Double
)