package com.example.sipappliaction.feature.home.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sipappliaction.R
import com.example.sipappliaction.data.model.PaymentItemModel
import com.example.sipappliaction.data.model.PaymentModel
import com.example.sipappliaction.databinding.ActivityDetailPaymentBinding
import com.example.sipappliaction.feature.admin.AdminPage
import com.example.sipappliaction.feature.home.Home

class DetailPayment : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailPaymentBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dataPayment = intent.getParcelableExtra<PaymentItemModel>("datapayment")

        binding.apply {
            tilNamaPayment.editText?.setText(dataPayment?.name)
            tilAmmount.editText?.setText(dataPayment?.ammount)
        }

        binding.btnDelete3.setOnClickListener {
            PaymentModel.paymentList.remove(
                PaymentItemModel("${dataPayment?.name}",
                "${dataPayment?.ammount}")
            )
            startActivity(Intent(this, Home::class.java).apply {
                finishAffinity()
            })
            Toast.makeText(this, "Berhasil Dibayar", Toast.LENGTH_SHORT).show()
        }
    }
}