package br.com.mateus.coinbank.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import br.com.mateus.coinbank.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_nav_host.*

class NavHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_host)

        setUpNavigation()
        setupNav()
    }

    /*Função para add cada fragment ao menu navigation*/
    fun setUpNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_home) as NavHostFragment?
        NavigationUI.setupWithNavController(
            bottomNavigation,
            navHostFragment!!.navController
        )
    }

    /*Função para deixar o bottomnavagation visivel apenas nos fragments desejados*/
    private fun setupNav() {
        val navController = findNavController(R.id.fragment_home)
        findViewById<BottomNavigationView>(R.id.bottomNavigation)
            .setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.nav_home -> showBottomNav()
                R.id.nav_info -> showBottomNav()
                else -> hideBottomNav()
            }
        }
    }

    /*Deixa o bottomNavigation visivel*/
    private fun showBottomNav() {
        bottomNavigation.visibility = View.VISIBLE

    }

    /*Deixa o bottomNavigation invisivel*/
    private fun hideBottomNav() {
        bottomNavigation.visibility = View.GONE

    }
}