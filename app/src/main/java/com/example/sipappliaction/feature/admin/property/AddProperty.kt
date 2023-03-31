package com.example.sipappliaction.feature.admin.property

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sipappliaction.data.model.PropertyDataModel
import com.example.sipappliaction.data.model.PropertyModel
import com.example.sipappliaction.databinding.ActivityAddPropertyBinding
import com.example.sipappliaction.feature.admin.AdminPage

class AddProperty : AppCompatActivity() {
    private lateinit var binding: ActivityAddPropertyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPropertyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddProperty.setOnClickListener {
            PropertyModel.listProperty.add(0, PropertyDataModel(binding.tilNamaProperty.editText?.text.toString(),
                binding.tilAlamat.editText?.text.toString(), binding.tilOwner.editText?.text.toString()))
            Toast.makeText(this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, AdminPage::class.java).apply {
                finishAffinity()
            })
        }
    }
}