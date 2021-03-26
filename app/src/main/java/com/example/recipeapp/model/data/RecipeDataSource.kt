package com.example.recipeapp.model.data


import android.content.Context
import com.example.recipeapp.network.RetrofitInstance
import com.example.recipeapp.presenter.recipe.RecipeHome
import com.example.recipeapp.presenter.search.SearchHome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RecipeDataSource(context: Context) {

    fun getBreakingRecipe(callback: RecipeHome.presenter) {
        GlobalScope.launch(Dispatchers.Main) {
            val response = RetrofitInstance.api.getBreakingRecipe()
            if (response.isSuccessful) {
                response.body()?.let {  recipeResponse ->
                    callback.onSuccess(recipeResponse)
                }
                callback.onComplete()
            } else {
                callback.onError(response.message())
                callback.onComplete()
            }
        }
    }

    fun searchRecipe(term: String, callback: SearchHome.presenter) {
        GlobalScope.launch(Dispatchers.Main) {
            val response = RetrofitInstance.api.searchNews(term)
            if (response.isSuccessful) {
                response.body()?.let { recipeResponse ->
                    callback.onSuccess(recipeResponse)
                }
                callback.onComplete()
            } else {
                callback.onError(response.message())
                callback.onComplete()
            }
        }
    }
}