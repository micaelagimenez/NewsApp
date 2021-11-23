package com.project.newsapp.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.newsapp.R
import com.project.newsapp.databinding.FragmentFavoritesBinding
import com.project.newsapp.db.FavoriteViewModel
import com.project.newsapp.db.Favorites

class FavoritesFragment : Fragment() {

    private val mfavoriteViewModel by viewModels<FavoriteViewModel>()
    private lateinit var binding: FragmentFavoritesBinding
    private val deleteHandler: (Favorites) -> Unit = {
        mfavoriteViewModel.deleteFavorite(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFavoritesBinding.inflate(layoutInflater)
        //recyclerview
        val adapter = FavoritesAdapter(deleteHandler)
        binding.rvFavList.layoutManager = LinearLayoutManager(context)
        binding.rvFavList.adapter = adapter

        //favoriteViewModel
        mfavoriteViewModel.readAllData.observe(viewLifecycleOwner, { favorite ->

            if (favorite.isEmpty()) {
                binding.emptyState.text = getString(R.string.emptyState)
                binding.emptyState.visibility = View.VISIBLE
            } else {
                adapter.setData(favorite)
                binding.emptyState.visibility = View.GONE
            }
        })

        return binding.root
    }
}