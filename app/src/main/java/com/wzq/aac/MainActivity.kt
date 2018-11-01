package com.wzq.aac

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.wzq.aac.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        val navController = Navigation.findNavController(this, R.id.main_nav_fragment)

        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController, drawer)

    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
    }

}
