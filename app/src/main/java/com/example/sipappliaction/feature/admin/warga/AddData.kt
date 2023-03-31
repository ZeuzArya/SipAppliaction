package com.example.sipappliaction.feature.admin.warga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sipappliaction.data.model.WargaDataModel
import com.example.sipappliaction.data.model.WargaModel
import com.example.sipappliaction.databinding.ActivityAddDataBinding
import com.example.sipappliaction.feature.admin.AdminPage

class AddData : AppCompatActivity() {
    private lateinit var binding: ActivityAddDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddDataBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAddData.setOnClickListener {
            WargaModel.listWarga.add(0, WargaDataModel(binding.tilName.editText?.text.toString(), binding.tilAvatar.editText?.text.toString()))
            Toast.makeText(this,"Data berhasil ditambahkan", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, AdminPage::class.java).apply {
                finishAffinity()
            })
        }
    }
}