package com.example.recipeapp.presenter.search

import com.example.recipeapp.model.RecipeResult

interface SearchHome {

    interface presenter {
        fun search(term: String)
        fun onSuccess(recipeResult: RecipeResult)
        fun onError(message: String)
        fun onComplete()
    }
}