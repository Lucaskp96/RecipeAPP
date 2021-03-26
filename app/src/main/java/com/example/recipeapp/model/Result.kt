package com.example.recipeapp.model

import java.io.Serializable

data class Result(
    val href: String?,
    val ingredients: String?,
    val thumbnail: String?,
    val title: String?
):Serializable