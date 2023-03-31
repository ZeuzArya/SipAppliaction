package com.example.sipappliaction.feature.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sipappliaction.data.adapter.ListAnnouncement
import com.example.sipappliaction.data.adapter.ListDataWarga
import com.example.sipappliaction.data.adapter.PaymentListAdapter
import com.example.sipappliaction.data.adapter.PropertyListAdapter
import com.example.sipappliaction.data.model.*
import com.example.sipappliaction.databinding.ActivityDataWargaBinding
import com.example.sipappliaction.feature.admin.payment.AddPayment
import com.example.sipappliaction.feature.admin.payment.DetailDataPayment
import com.example.sipappliaction.feature.admin.property.AddProperty
import com.example.sipappliaction.feature.admin.property.DetailDataProperty
import com.example.sipappliaction.feature.admin.warga.AddData
import com.example.sipappliaction.feature.admin.warga.DetailDataWarga

class DataWarga : AppCompatActivity() {
    private lateinit var binding: ActivityDataWargaBinding
    private val adapterWarga: ListDataWarga by lazy { ListDataWarga() }
    private val adapterProperti: PropertyListAdapter by lazy { PropertyListAdapter() }
    private val adapterPayment: PaymentListAdapter by lazy { PaymentListAdapter() }
    private val adapterPengumuman: ListAnnouncement by lazy { ListAnnouncement() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataWargaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.rvDataList.layoutManager = layoutManager
        val code = intent.getStringExtra("code")

        //LIST DATA WARGA
        if(code == "1"){
            adapterWarga.submitList(WargaModel.listWarga)
            adapterWarga.setOnClickItem(rvClickListener)
            binding.rvDataList.adapter = adapterWarga
            binding.tvDataTitle.text = "List Data Warga"
            binding.btnTambah.text = "Tambahkan Warga"
            binding.btnTambah.setOnClickListener {
                startActivity(Intent(this, AddData::class.java))
            }
        }

        //LIST DATA PROPERTI
        if(code == "2"){
            adapterProperti.submitList(PropertyModel.listProperty)
            adapterProperti.setOnClickItem(rvClickListener2)
            binding.rvDataList.adapter = adapterProperti
            binding.tvDataTitle.text = "List Data Properti"
            binding.btnTambah.text = "Tambahkan Property"
            binding.btnTambah.setOnClickListener {
                startActivity(Intent(this, AddProperty::class.java))
            }
        }

        //LIST DATA PAYMENT
        if(code == "3"){
            adapterPayment.submitList(PaymentModel.paymentList)
            adapterPayment.setOnClickItem(rvClickListener3)
            binding.rvDataList.adapter = adapterPayment
            binding.tvDataTitle.text = "List Data Payment"
            binding.btnTambah.text = "Tambahkan Payment"
            binding.btnTambah.setOnClickListener {
                startActivity(Intent(this, AddPayment::class.java))
            }
        }
    }

    //DATA WARGA LISTENER
    private val rvClickListener: (WargaDataModel) -> Unit =
        {item ->
            startActivity(Intent(this, DetailDataWarga::class.java).apply {
                putExtra("datawarga", item)
            })
        }

    //DATA PROPERTY LISTENER
    private val rvClickListener2: (PropertyDataModel) -> Unit =
        {item ->
            startActivity(Intent(this, DetailDataProperty::class.java).apply {
                putExtra("dataproperty", item)
            })
        }

    //DATA PAYMENT LISTENER
    private val rvClickListener3: (PaymentItemModel) -> Unit =
        {item ->
            startActivity(Intent(this, DetailDataPayment::class.java).apply {
                putExtra("datapayment", item)
            })
        }
}