package com.example.lawpavillionandroidassessment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.lawpavillionandroidassessment.R
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
                R.id.dashboardFragment -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.dashboardFragment)
                    return@setNavigationItemSelectedListener true
                }
                R.id.lawReportsFragment -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.lawReportsFragment)
                    return@setNavigationItemSelectedListener true
                }
                R.id.lawsOfNigeriaFragment -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.lawsOfNigeriaFragment)
                    return@setNavigationItemSelectedListener true
                }
                R.id.civilProcedureRulesFragment -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.civilProcedureRulesFragment)
                    return@setNavigationItemSelectedListener true
                }
                R.id.indexAndDigestFragment -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.indexAndDigestFragment)
                    return@setNavigationItemSelectedListener true
                }
                R.id.myResearchFolderFragment -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.myResearchFolderFragment)
                    return@setNavigationItemSelectedListener true
                }
                R.id.newContentsFragment -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.newContentsFragment)
                    return@setNavigationItemSelectedListener true
                }
                R.id.textBooksAndJournalsFragment -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.textBooksAndJournalsFragment)
                    return@setNavigationItemSelectedListener true
                }
                R.id.wordsInGoldFragment -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.wordsInGoldFragment)
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