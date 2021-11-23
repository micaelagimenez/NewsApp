package com.project.newsapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.newsapp.R
import com.project.newsapp.ui.favorites.FavoritesFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var bottomNavigation: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottom_navigation)

        val newsFragment = JapaneseFragment()
        val favFragment = FavoritesFragment()

        openFragment(newsFragment)
        bottomNavigation?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    openFragment(newsFragment)
                }
                R.id.navigation_fav -> {
                    openFragment(favFragment)
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    fun openFragment(fragment: Fragment?) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (fragment != null) {
            transaction.replace(R.id.container, fragment)
        }
        transaction.addToBackStack(null)
        transaction.commit()
    }


}