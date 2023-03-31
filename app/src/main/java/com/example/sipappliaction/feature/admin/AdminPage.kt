package com.example.sipappliaction.feature.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sipappliaction.databinding.ActivityAdminPageBinding
import com.example.sipappliaction.feature.MainActivity

class AdminPage : AppCompatActivity() {
    private lateinit var binding: ActivityAdminPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAdminPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.cvDataWarga.setOnClickListener {
            startActivity(Intent(this, DataWarga::class.java).apply {
                putExtra("code", "1")
            })
        }

        binding.cvDataProperti.setOnClickListener {
            startActivity(Intent(this, DataWarga::class.java).apply {
                putExtra("code", "2")
            })
        }

        binding.cvDataIuran.setOnClickListener {
            startActivity(Intent(this, DataWarga::class.java).apply {
                putExtra("code", "3")
            })
        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}