package com.example.recipeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipeapp.R
import com.example.recipeapp.model.Result
import kotlinx.android.synthetic.main.item_item.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallBack = object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder =
        RecipeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_item, parent, false)
        )

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(recipe.thumbnail).into(ivRecipeImage)
            tv_title.text = recipe.title
            tv_description.text = recipe.ingredients
        }
    }
}