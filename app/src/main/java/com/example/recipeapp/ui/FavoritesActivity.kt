package com.example.recipeapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.adapter.FavAdapters
import com.example.recipeapp.model.FavRecipes

class FavoritesActivity : AppCompatActivity() {

    private var recyclerView:RecyclerView? = null
    private var gridLayoutManager:GridLayoutManager? = null
    private var arrayList:ArrayList<FavRecipes>? = null
    private var favAdapters:FavAdapters? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.favorites_activity)

        recyclerView = findViewById(R.id.recycler_view)
        gridLayoutManager = GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataInList()
        favAdapters = FavAdapters(applicationContext, arrayList!!)
        recyclerView?.adapter = favAdapters

    }

    private fun setDataInList() : ArrayList<FavRecipes> {
        var items:ArrayList<FavRecipes> = ArrayList()

        items.add(FavRecipes(R.drawable.recipe_fav_img, "Recipe 1"))
        items.add(FavRecipes(R.drawable.recipe_fav_img, "Recipe 1"))
        items.add(FavRecipes(R.drawable.recipe_fav_img, "Recipe 1"))
        items.add(FavRecipes(R.drawable.recipe_fav_img, "Recipe 1"))
        items.add(FavRecipes(R.drawable.recipe_fav_img, "Recipe 1"))
        items.add(FavRecipes(R.drawable.recipe_fav_img, "Recipe 1"))


        return items
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_navigation, menu)
        menu!!.findItem(R.id.nav_favorites).setVisible(false)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.search_menu -> {
                Intent(this, SearchActivity::class.java).apply {
                    startActivity(this)
                }
            }
            R.id.nav_home -> {
                Intent(this, HomeActivity::class.java).apply {
                    startActivity(this)
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }

}