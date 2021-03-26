package com.example.recipeapp.presenter

import com.example.recipeapp.model.Result

interface ViewHome {

    interface view {
        fun showProgressBar()
        fun showFailure(message: String)
        fun hideProgressBar()
        fun showRecipe(recipe: MutableList<Result>)
    }

    interface Favorite {
        fun showRecipes(articles: List<Result>)
    }
}