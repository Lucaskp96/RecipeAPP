package com.example.recipeapp.presenter.recipe

import com.example.recipeapp.model.RecipeResult

interface RecipeHome {

    interface presenter{
        fun requestAll()
        fun onSuccess(recipeResult: RecipeResult)
        fun onError(message: String)
        fun onComplete()
    }
}