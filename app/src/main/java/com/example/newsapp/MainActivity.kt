package com.example.newsapp

import android.content.res.Configuration
import android.graphics.drawable.GradientDrawable.Orientation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.databinding.ActivityMainLandBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var landBinding : ActivityMainLandBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fragment1 = R.id.main_frame_layout
        val fragment2 = R.id.main_frame_layout2
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_PORTRAIT){
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            setFragment(NewsListView(),fragment1)
            binding.mainBottomNavigation.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.bottom_nav_icon_home -> setFragment(NewsListView(),fragment1)
                    else -> NewsListView()
                }
                true
            }
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            landBinding = ActivityMainLandBinding.inflate(layoutInflater)
            setContentView(landBinding.root)
            setFragment(NewsListView(),fragment1)
            setFragment(NewsDetail(),fragment2)
            landBinding.mainBottomNavigation.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.bottom_nav_icon_home -> setFragment(NewsListView(),fragment1)
                    else -> NewsListView()
                }
                true
            }
        }


    }

    private fun setFragment(fragment: Fragment, id : Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(id, fragment)
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .commit()
    }
}
