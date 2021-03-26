package com.example.recipeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.model.FavRecipes

class FavAdapters(var context: Context, var arrayList: ArrayList<FavRecipes>) : RecyclerView.Adapter<FavAdapters.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_layout_list_item, parent, false)
        return ItemHolder(itemHolder)

    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var favRecipes:FavRecipes = arrayList[position]

        holder.icons.setImageResource(favRecipes.iconsRecipes!!)
        holder.recipes.text = favRecipes.favRecipes

        holder.recipes.setOnClickListener {
            Toast.makeText(context, favRecipes.favRecipes, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var icons: ImageView = itemView.findViewById<ImageView>(R.id.icons_img)
        var recipes = itemView.findViewById<TextView>(R.id.recipe_text_view)
    }

}