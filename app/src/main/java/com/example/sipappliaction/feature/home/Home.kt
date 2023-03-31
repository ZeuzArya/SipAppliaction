package com.example.sipappliaction.feature.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sipappliaction.R
import com.example.sipappliaction.databinding.ActivityHomeBinding
import com.example.sipappliaction.feature.MainActivity
import com.example.sipappliaction.feature.chat.ChatFragment
import com.example.sipappliaction.feature.home.house.HouseProperty
import com.example.sipappliaction.feature.home.payment.Payment
import com.example.sipappliaction.feature.home.report.Report
import com.example.sipappliaction.feature.profile.ProfileFragment

class Home : AppCompatActivity(), HomeFragmentInterface {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.selectedItemId = R.id.Home
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.Home -> replaceFragment(HomeFragment())
                R.id.Chat -> replaceFragment(ChatFragment())
                R.id.Profile -> replaceFragment(ProfileFragment())
                else -> {}
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.apply {
            replace(R.id.fragContainer, fragment)
            commit()
        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onClickHouse() {
        startActivity(Intent(this@Home, HouseProperty::class.java))
    }

    override fun onClickPayment() {
        startActivity(Intent(this@Home, Payment::class.java))
    }

    override fun onClickReport() {
        startActivity(Intent(this@Home, Report::class.java))
    }

    override fun onClickAnnouncement() {

    }

    override fun onClickWarga() {

    }
}