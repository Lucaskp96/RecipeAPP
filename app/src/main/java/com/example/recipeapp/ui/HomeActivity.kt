package com.example.recipeapp.ui

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeapp.R
import com.example.recipeapp.adapter.MainAdapter
import com.example.recipeapp.model.Result
import com.example.recipeapp.model.data.RecipeDataSource
import com.example.recipeapp.presenter.ViewHome
import com.example.recipeapp.presenter.recipe.RecipePresenter
import kotlinx.android.synthetic.main.home_activity.*

class HomeActivity : AbstractActivity(), ViewHome.view {

    private val mainAdapter by lazy {
        MainAdapter()
    }

    private lateinit var presenter: RecipePresenter

    override fun getLayout(): Int = R.layout.home_activity

    override fun onInject() {

        val dataSource = RecipeDataSource(this)
        presenter = RecipePresenter(this, dataSource)
        presenter.requestAll()
        configRecycle()
    }

    private fun configRecycle() {
        with(rc_home) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@HomeActivity)
            addItemDecoration(DividerItemDecoration(
                this@HomeActivity, DividerItemDecoration.VERTICAL
            ))
        }
    }

    override fun showProgressBar() {
        rvProgressbar.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun hideProgressBar() {
        rvProgressbar.visibility = View.INVISIBLE
    }

    override fun showRecipe(recipe: MutableList<Result>) {
        mainAdapter.differ.submitList(recipe.toList())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_navigation, menu)
        menu!!.findItem(R.id.nav_home).setVisible(false)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.search_menu -> {
                Intent(this, SearchActivity::class.java).apply {
                    startActivity(this)
                }
            }

            R.id.nav_favorites -> {
                Intent(this, FavoritesActivity::class.java).apply {
                    startActivity(this)
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }

}