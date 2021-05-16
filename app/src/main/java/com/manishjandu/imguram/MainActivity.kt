package com.manishjandu.imguram

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.manishjandu.imguram.databinding.ActivityMainBinding
import com.manishjandu.imguram.ui.stories.StoriesRecyclerAdapter
import com.manishjandu.imguram.ui.stories.StoriesViewModel


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private val storiesViewModel by viewModels<StoriesViewModel>()
    private val storiesAdapter = StoriesRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvStories.apply {
            layoutManager = LinearLayoutManager(
                context,
                RecyclerView.HORIZONTAL, false
            )
            adapter = storiesAdapter
        }


        setupNav()

        storiesViewModel.fetchTags()
    }

    private fun setupNav() {
        /*
        NOTE: Not using action bar in our app for now
         */
        val bottomView = findViewById<BottomNavigationView>(R.id.nav_view)
        // Finding the Navigation Controller
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)
        val navController = navHostFragment?.findNavController()

        // Setting Navigation Controller with the BottomNavigationView
        bottomView.setupWithNavController(navController!!)
    }

    override fun onResume() {
        super.onResume()
        storiesViewModel.tags.observe(this) {
            Log.i(TAG,"tags are $it")
            storiesAdapter.submitList(it)
        }
    }

}