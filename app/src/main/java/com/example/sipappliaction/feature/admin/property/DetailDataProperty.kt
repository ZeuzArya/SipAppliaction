package com.example.sipappliaction.feature.admin.property

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sipappliaction.data.model.PropertyDataModel
import com.example.sipappliaction.data.model.PropertyModel
import com.example.sipappliaction.databinding.ActivityDetailDataPropertyBinding
import com.example.sipappliaction.feature.admin.AdminPage

class DetailDataProperty : AppCompatActivity() {
    private lateinit var binding: ActivityDetailDataPropertyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDataPropertyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataProperty = intent.getParcelableExtra<PropertyDataModel>("dataproperty")

        binding.apply {
            tilNamaProp.editText?.setText(dataProperty?.tittle)
            tilAlamatProp.editText?.setText(dataProperty?.address)
            tilPemilikProp.editText?.setText(dataProperty?.owner)
        }

        binding.btnDelete2.setOnClickListener {
            PropertyModel.listProperty.remove(PropertyDataModel("${dataProperty?.tittle}",
                "${dataProperty?.address}", "${dataProperty?.owner}"))
            startActivity(Intent(this, AdminPage::class.java).apply {
                finishAffinity()
            })
            Toast.makeText(this, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show()
        }

        binding.btnEdit2.setOnClickListener {
            PropertyModel.listProperty
                .set(PropertyModel.listProperty
                    .indexOf(PropertyDataModel("${dataProperty?.tittle}", "${dataProperty?.address}", "${dataProperty?.owner}")),
            PropertyDataModel(binding.tilNamaProp.editText?.text.toString(),
                binding.tilAlamatProp.editText?.text.toString(),
                binding.tilNamaProp.editText?.text.toString()))
            startActivity(Intent(this, AdminPage::class.java).apply {
                finishAffinity()
            })
            Toast.makeText(this, "Data Berhasil Diubah", Toast.LENGTH_SHORT).show()
        }
    }
}