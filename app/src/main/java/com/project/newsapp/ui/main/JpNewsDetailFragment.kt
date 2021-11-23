package com.project.news.ui.jp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.project.newsapp.R
import com.project.newsapp.data.jp.ArticlesData
import com.project.newsapp.databinding.FragmentJpNewsDetailBinding
import com.project.newsapp.db.FavoriteViewModel
import com.project.newsapp.db.Favorites
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JpNewsDetailFragment : Fragment() {
    companion object {
        const val EXTRA_MEMBER = ""
    }

    private lateinit var binding: FragmentJpNewsDetailBinding
    val mfavoriteViewModel by viewModels<FavoriteViewModel>()
    private val deleteHandler: (Favorites) -> Unit = {
        mfavoriteViewModel.deleteFavorite(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJpNewsDetailBinding.inflate(inflater, container, false)

        if (arguments != null) {
            val data = requireArguments().getSerializable(EXTRA_MEMBER) as ArticlesData
            binding.tvTitleItem.text = data.Title
            Picasso.get().load(data.urlToImage).into(binding.ivNewsImageDetail)
            binding.tvDesc.text = data.Description
            binding.tvPublishedAt.text = data.publishedAt

            //link to go to the news' website
            binding.btnUrl.text = getString(R.string.continueReading)
            binding.btnUrl.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(data.Url)
                startActivity(intent)
            }

        } else {
            //display error message if arguments are null
            Toast.makeText(context, "Error loading content", Toast.LENGTH_SHORT).show()
        }

        //add to favorite
        val itemFavorite: Button = binding.btnFav
        itemFavorite.text = resources.getString(R.string.favorite)
        itemFavorite.setOnClickListener {
            insertDataToDatabase()
        }

        return binding.root
    }

    private fun insertDataToDatabase() {
        val title = binding.tvTitleItem.text
        val data = requireArguments().getSerializable(EXTRA_MEMBER) as ArticlesData
        val image = data.urlToImage
        val author = binding.tvAuthor.text
        val content = binding.tvDesc.text
        val date = binding.tvPublishedAt.text
        val fStatus = 1

        //create favorite object
        val favorite = image?.let {
            Favorites(
                id = 0,
                title.toString(),
                it,
                author.toString(),
                content.toString(),
                date.toString(),
                Integer.parseInt(fStatus.toString())
            )
        }
        //add data to db
        if (favorite != null) {
            mfavoriteViewModel.addFavorite(favorite)
        }
        Toast.makeText(context, "Successfully added to favorites", Toast.LENGTH_SHORT).show()
    }
}