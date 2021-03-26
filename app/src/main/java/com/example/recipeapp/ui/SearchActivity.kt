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
import com.example.recipeapp.presenter.search.SearchPresenter
import com.example.recipeapp.util.UtilQueryTextListener
import kotlinx.android.synthetic.main.home_activity.*
import kotlinx.android.synthetic.main.search_activity.*

class SearchActivity : AbstractActivity(), ViewHome.view {

    private val mainAdapter by lazy {
        MainAdapter()
    }

    private lateinit var presenter: SearchPresenter

    override fun getLayout(): Int = R.layout.search_activity

    override fun onInject() {
        val dataSource = RecipeDataSource(this)
        presenter = SearchPresenter(this, dataSource)
        configRecycle()
        search()

    }

    private fun search() {
        searchNews.setOnQueryTextListener(UtilQueryTextListener(
            this.lifecycle
        ) { newText ->
            newText?.let { query ->
                if (query.isNotEmpty()) {
                    presenter.search(query)
                    rvProgressBarSearch.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun configRecycle() {
        with(rvSearch) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@SearchActivity)
            addItemDecoration(DividerItemDecoration(this@SearchActivity, DividerItemDecoration.VERTICAL))
        }
    }


    override fun showProgressBar() {
        rvProgressBarSearch.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun hideProgressBar() {
        rvProgressBarSearch.visibility = View.INVISIBLE
    }

    override fun showRecipe(recipe: MutableList<Result>) {
        mainAdapter.differ.submitList(recipe.toList())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_navigation, menu)
        menu!!.findItem(R.id.search_menu).setVisible(false)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.nav_home -> {
                Intent(this, HomeActivity::class.java).apply {
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