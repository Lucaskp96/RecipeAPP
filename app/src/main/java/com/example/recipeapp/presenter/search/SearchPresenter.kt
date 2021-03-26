package com.example.recipeapp.presenter.search

import com.example.recipeapp.model.RecipeResult
import com.example.recipeapp.model.data.RecipeDataSource
import com.example.recipeapp.presenter.ViewHome

class SearchPresenter (val view: ViewHome.view, private val dataSource: RecipeDataSource): SearchHome.presenter {
    override fun search(term: String) {
        this.view.showProgressBar()
        this.dataSource.searchRecipe(term, this)
    }

    override fun onSuccess(recipeResult: RecipeResult) {
        this.view.showRecipe(recipeResult.results)
    }

    override fun onError(message: String) {
        this.view.showFailure(message)
    }

    override fun onComplete() {
        this.view.hideProgressBar()
    }
}