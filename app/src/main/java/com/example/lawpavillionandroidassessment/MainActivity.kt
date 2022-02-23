package com.example.lawpavillionandroidassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lawpavillionandroidassessment.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
//    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController
        setUpDrawerLayout()


//        val drawerLayout: DrawerLayout = binding.drawerLayout
//        val navView: NavigationView = binding.navView
//
//        appBarConfiguration = AppBarConfiguration(
//           navController.graph, drawerLayout
//        )
//        setSupportActionBar(binding.appBarDashboard.dashboardActivityToolbar)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)


        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.latestJudgementsFragment -> {
                    Toast.makeText(this, "Latest judgement", Toast.LENGTH_SHORT).show()
                    findNavController(R.id.nav_host_fragment).navigate(R.id.latestJudgementsFragment)
                    return@setNavigationItemSelectedListener true
                }
                R.id.dashboard -> {
                    Toast.makeText(this, "Latest judgement", Toast.LENGTH_SHORT).show()
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