package com.example.sipappliaction.feature.home.house

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sipappliaction.R
import com.example.sipappliaction.data.model.PropertyDataModel
import com.example.sipappliaction.databinding.ActivityDetailPropertyBinding

class DetailProperty : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPropertyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailPropertyBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dataProperty = intent.getParcelableExtra<PropertyDataModel>("dataproperty")

        binding.apply {
            tilNamaProp.editText?.setText(dataProperty?.tittle)
            tilAlamatProp.editText?.setText(dataProperty?.address)
            tilPemilikProp.editText?.setText(dataProperty?.owner)
        }
    }
}