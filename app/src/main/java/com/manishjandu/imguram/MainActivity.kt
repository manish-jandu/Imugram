package com.manishjandu.imguram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.manishjandu.imguram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
       // binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    fun setupView(){
        val bottomView = findViewById<BottomNavigationView>(R.id.nav_view)
        // Finding the Navigation Controller
        var navController = findNavController(R.id.nav_host_fragment_activity_main)

        // Setting Navigation Controller with the BottomNavigationView
        bottomView.setupWithNavController(navController)
    }
}