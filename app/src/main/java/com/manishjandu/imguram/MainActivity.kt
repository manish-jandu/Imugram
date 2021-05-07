package com.manishjandu.imguram

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.manishjandu.libimgur.ImgurClient


class MainActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityMainBinding
    private val api = ImgurClient.api
    override fun onCreate(savedInstanceState: Bundle?) {
       // binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNav()
    }

    fun setupNav(){
        val bottomView = findViewById<BottomNavigationView>(R.id.nav_view)
        // Finding the Navigation Controller
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        // Setting Navigation Controller with the BottomNavigationView
        bottomView.setupWithNavController(navController)
    }

}