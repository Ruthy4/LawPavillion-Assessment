package com.example.lawpavillionandroidassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.lawpavillionandroidassessment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController
        setUpDrawerLayout()


        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.latestJudgementsFragment -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.latestJudgementsFragment)
                    return@setNavigationItemSelectedListener true
                }
                else -> return@setNavigationItemSelectedListener true
            }
        }
    }

    private fun setUpDrawerLayout() {
        binding.navView.setupWithNavController(navController)
    }
}