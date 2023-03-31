package com.example.sipappliaction.feature.home.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sipappliaction.R
import com.example.sipappliaction.data.adapter.PaymentListAdapter
import com.example.sipappliaction.data.model.PaymentItemModel
import com.example.sipappliaction.data.model.PaymentModel
import com.example.sipappliaction.databinding.ActivityPaymentBinding
import com.example.sipappliaction.feature.admin.payment.DetailDataPayment

class Payment : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    private val adapterPayment: PaymentListAdapter by lazy { PaymentListAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        adapterPayment.submitList(PaymentModel.paymentList)
        adapterPayment.setOnClickItem(rvClickListener3)
        binding.rvPaymentList.adapter = adapterPayment
        binding.rvPaymentList.layoutManager = layoutManager
    }

    private val rvClickListener3: (PaymentItemModel) -> Unit =
        {item ->
            startActivity(Intent(this, DetailPayment::class.java).apply {
                putExtra("datapayment", item)
            })
        }
}