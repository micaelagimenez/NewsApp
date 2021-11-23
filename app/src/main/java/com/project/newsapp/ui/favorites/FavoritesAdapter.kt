package com.project.newsapp.ui.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.newsapp.R
import com.project.newsapp.databinding.FavItemBinding
import com.project.newsapp.db.Favorites
import com.squareup.picasso.Picasso

class FavoritesAdapter(val deleteHandler: (Favorites) -> Unit) :
    RecyclerView.Adapter<FavoritesAdapter.ViewHolder>() {

    private var favoriteList = emptyList<Favorites>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = FavItemBinding.bind(itemView)

        val favTitle: TextView = binding.tvFavsTitle
        val favItem: ImageButton = binding.btnFavs
        val favImg: ImageView = binding.ivFavs

        fun bind(favorites: Favorites) {
            Picasso.get().load(favorites.image).into(favImg)
            favTitle.text = favorites.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fav_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(favoriteList[position])

        //delete favorite item
        holder.favItem.setOnClickListener {
            deleteHandler(favoriteList[position])
        }

    }

    override fun getItemCount(): Int {
        return favoriteList.size
    }

    fun setData(favorite: List<Favorites>) {
        this.favoriteList = favorite
        notifyDataSetChanged()
    }

}