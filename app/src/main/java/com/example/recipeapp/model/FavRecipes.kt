package com.example.recipeapp.model

class FavRecipes {

    var iconsRecipes: Int? = 0
    var favRecipes: String? = null

    constructor(iconsRecipes: Int?, favRecipes: String?) {
        this.iconsRecipes = iconsRecipes
        this.favRecipes = favRecipes
    }
}