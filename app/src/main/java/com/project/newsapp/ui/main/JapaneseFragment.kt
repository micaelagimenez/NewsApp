package com.project.newsapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.project.news.ui.jp.JpNewsDetailFragment
import com.project.newsapp.data.Resource
import com.project.newsapp.data.jp.ArticlesData
import com.project.newsapp.databinding.FragmentJapaneseBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class JapaneseFragment : Fragment() {

    private lateinit var binding: FragmentJapaneseBinding
    private val japaneseViewModel: JapaneseViewModel by viewModels()
    private lateinit var japaneseAdapter: JapaneseAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJapaneseBinding.inflate(inflater, container, false)

        japaneseViewModel.japaneseResponse.observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.LOADING -> {
                }
                Resource.Status.SUCCESS -> {
                    japaneseAdapter = it.data?.let { it1 ->
                        JapaneseAdapter(it1.Articles,
                            onClick = {
                                navigateToNews(it)
                            })
                    }!!
                    binding.rvNews.adapter = japaneseAdapter
                }
                Resource.Status.ERROR -> {
                    Log.d("ERROR", "$it")
                }
            }
        })

        return binding.root
    }

    private fun navigateToNews(clickedArticle: ArticlesData) {
        val data = Bundle()
        data.putSerializable(JpNewsDetailFragment.EXTRA_MEMBER, clickedArticle)

        val nextFrag = JpNewsDetailFragment()
        nextFrag.arguments = data
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(com.project.newsapp.R.id.container, nextFrag, "findThisFragment")
            .addToBackStack(null)
            .commit()
    }
}