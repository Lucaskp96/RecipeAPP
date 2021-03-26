package com.example.recipeapp.presenter.recipe

import com.example.recipeapp.model.RecipeResult
import com.example.recipeapp.model.data.RecipeDataSource
import com.example.recipeapp.presenter.ViewHome

class RecipePresenter(val view: ViewHome.view, private val dataSource: RecipeDataSource): RecipeHome.presenter {
    override fun requestAll() {
        this.view.showProgressBar()
        this.dataSource.getBreakingRecipe(this)
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