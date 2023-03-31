package com.example.sipappliaction.feature.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sipappliaction.R
import com.example.sipappliaction.databinding.ActivityDetailWargaBinding

class DetailWarga : AppCompatActivity() {
    private lateinit var binding: ActivityDetailWargaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailWargaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}