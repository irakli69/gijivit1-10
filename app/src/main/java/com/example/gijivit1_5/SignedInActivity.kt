package com.example.gijivit1_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class SignedInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signed_in)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()


        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        val controller = findNavController(R.id.nav_host_signedin_fragment)
        val appBarConfig = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.feedFragment,
                R.id.progressFragment,
                R.id.profileFragment,

            )
        )
        setupActionBarWithNavController(controller, appBarConfig)
        navView.setupWithNavController(controller)
    }

}
