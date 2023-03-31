package com.example.sipappliaction.feature.admin.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sipappliaction.data.model.PaymentItemModel
import com.example.sipappliaction.data.model.PaymentModel
import com.example.sipappliaction.databinding.ActivityDetailDataPaymentBinding
import com.example.sipappliaction.feature.admin.AdminPage

class DetailDataPayment : AppCompatActivity() {
    private lateinit var binding: ActivityDetailDataPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDataPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataPayment = intent.getParcelableExtra<PaymentItemModel>("datapayment")

        binding.apply {
            tilNamaPayment.editText?.setText(dataPayment?.name)
            tilAmmount.editText?.setText(dataPayment?.ammount)
        }

        binding.btnDelete3.setOnClickListener {
            PaymentModel.paymentList.remove(PaymentItemModel("${dataPayment?.name}",
            "${dataPayment?.ammount}"))
            startActivity(Intent(this, AdminPage::class.java).apply {
                finishAffinity()
            })
            Toast.makeText(this, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show()
        }

        binding.btnEdit3.setOnClickListener {
            PaymentModel.paymentList.set(PaymentModel.paymentList
                .indexOf(PaymentItemModel("${dataPayment?.name}", "${dataPayment?.ammount}")),
            PaymentItemModel(binding.tilNamaPayment.editText?.text.toString(), binding.tilAmmount.editText?.text.toString())
            )
            startActivity(Intent(this, AdminPage::class.java).apply {
                finishAffinity()
            })
            Toast.makeText(this, "Data Berhasil Diubah", Toast.LENGTH_SHORT).show()
        }
    }
}