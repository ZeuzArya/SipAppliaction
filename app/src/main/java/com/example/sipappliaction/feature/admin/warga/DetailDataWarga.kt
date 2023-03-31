package com.example.sipappliaction.feature.admin.warga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.sipappliaction.data.adapter.ListDataWarga
import com.example.sipappliaction.data.model.WargaDataModel
import com.example.sipappliaction.data.model.WargaModel
import com.example.sipappliaction.databinding.ActivityDetailDataWargaBinding
import com.example.sipappliaction.feature.admin.AdminPage

class DetailDataWarga : AppCompatActivity() {
    private lateinit var binding: ActivityDetailDataWargaBinding
    private val adapterWarga: ListDataWarga by lazy { ListDataWarga() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDataWargaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataWarga = intent.getParcelableExtra<WargaDataModel>("datawarga")

        binding.apply {
            etNamaWarga.setText(dataWarga?.name)
            Glide
                .with(root.context)
                .load(dataWarga?.avatar)
                .into(ivProfileWarga)
        }

        binding.btnDelete.setOnClickListener {
            WargaModel.listWarga.remove(WargaDataModel("${dataWarga?.name}", "${dataWarga?.avatar}" ))
            adapterWarga.notifyItemRemoved(WargaModel.listWarga.indexOf(WargaDataModel("${dataWarga?.name}", "${dataWarga?.avatar}" )))
            startActivity(Intent(this, AdminPage::class.java).apply {
                finishAffinity()
            })
            Toast.makeText(this, "Data Berhasil DiHapus", Toast.LENGTH_SHORT).show()
        }

        binding.btnEdit.setOnClickListener {
            WargaModel.listWarga.set(WargaModel.listWarga.indexOf(WargaDataModel("${dataWarga?.name}", "${dataWarga?.avatar}" )),
                WargaDataModel(binding.etNamaWarga.text.toString(), "${dataWarga?.avatar}" ))
            startActivity(Intent(this, AdminPage::class.java).apply {
                finishAffinity()
            })
            Toast.makeText(this, "Data Berhasil Diubah", Toast.LENGTH_SHORT).show()
        }

    }
}