package com.example.practicahostal_unaimateo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.practicahostal_unaimateo.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity(),OnNavigationItemSelectedListener{
    lateinit var binding:ActivityMainBinding
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawerlayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        actionBarDrawerToggle = ActionBarDrawerToggle(this,binding.drawerlayout, R.string.obert, R.string.tancat)
        binding.drawerlayout.addDrawerListener(actionBarDrawerToggle)
        binding.topAppBar.setNavigationOnClickListener {
            binding.drawerlayout.openDrawer(GravityCompat.START)
        }

        binding.navview.setNavigationItemSelectedListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            true
        }else{
            super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.setChecked(true)
        when(item.itemId){
            R.id.info_menu -> {
                binding.topAppBar.title = "Info"
                val InfoFragment = InfoFragment()
                canviFragment(InfoFragment)
            }
            R.id.act_menu -> {
                binding.topAppBar.title = "Activitats / Serveis"
                val ActivitatsFragment = ActivitatsFragment()
                canviFragment(ActivitatsFragment)
            }
//            R.id.serveis_menu -> {
//                binding.topAppBar.title = "Serveis"
//                val ServeisFragment = ServeisFragment()
//                canviFragment(ServeisFragment)
//            }
            R.id.reserves_menu -> {
                binding.topAppBar.title = "Reserves"
                val ReservesFragment = ReservesFragment()
                canviFragment(ReservesFragment)
            }
            R.id.faq_menu -> {
                binding.topAppBar.title = "FAQs"
                val FaqFragment = FaqFragment()
                canviFragment(FaqFragment)
            }
            R.id.contact_menu -> {
                binding.topAppBar.title = "Contacte"
                val ContactFragment = ContactFragment()
                canviFragment(ContactFragment)
            }

        }

        binding.drawerlayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if(binding.drawerlayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerlayout.closeDrawer(GravityCompat.START)
        }else{
            onBackPressedDispatcher.onBackPressed()
        }
        super.onBackPressed()
    }

    fun canviFragment(fragment: Fragment){
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fcv,fragment)
        transaction.commit()
    }

}