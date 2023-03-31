package com.example.sipappliaction.feature.admin.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sipappliaction.data.model.PaymentItemModel
import com.example.sipappliaction.data.model.PaymentModel
import com.example.sipappliaction.databinding.ActivityAddPaymentBinding
import com.example.sipappliaction.feature.admin.AdminPage

class AddPayment : AppCompatActivity() {
    private lateinit var binding: ActivityAddPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTambahPay.setOnClickListener {
            PaymentModel.paymentList.add(0, PaymentItemModel(binding.tilNamePay.editText?.text.toString(),
                binding.tilAmmount.editText?.text.toString().formatDotSeparator()))
            Toast.makeText(this, "Data  berhasil ditambahkan", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, AdminPage::class.java).apply {
                finishAffinity()
            })
        }
    }
    fun String.formatDotSeparator(): String {
        return toString()
            .reversed()
            .chunked(3)
            .joinToString(".")
            .reversed()
    }
}