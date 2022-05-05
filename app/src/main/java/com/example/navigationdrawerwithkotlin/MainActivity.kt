package com.example.navigationdrawerwithkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.graphics.drawable.DrawableCompat.setTint
import androidx.drawerlayout.widget.DrawerLayout
import com.example.navigationdrawerwithkotlin.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   // lateinit var binding: ActivityMainBinding
    lateinit var toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
      //  binding=ActivityMainBinding.inflate(LayoutInflater.from(this))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var drawerLayout:DrawerLayout=findViewById(R.id.drawerlayout)

        //DrawableCompat.setTint(drawerLayout, Color.BLACK)

        val navView:NavigationView=findViewById(R.id.nav_view)
       // navView.itemIconTintList
        navView.setItemIconTintList(null)

        toggle=ActionBarDrawerToggle(this,drawerlayout,R.string.open,R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->Toast.makeText(applicationContext,"home clicked",Toast.LENGTH_SHORT).show()
                R.id.nav_msg->Toast.makeText(applicationContext,"Messageclicked",Toast.LENGTH_SHORT).show()

                R.id.nav_setting->Toast.makeText(applicationContext,"Setting",Toast.LENGTH_SHORT).show()

                R.id.nav_share->Toast.makeText(applicationContext,"share",Toast.LENGTH_SHORT).show()




            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
          return true
        }
        return super.onOptionsItemSelected(item)
    }
}