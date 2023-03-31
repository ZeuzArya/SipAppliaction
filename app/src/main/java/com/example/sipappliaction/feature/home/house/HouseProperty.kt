package com.example.sipappliaction.feature.home.house

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sipappliaction.R
import com.example.sipappliaction.data.adapter.PropertyListAdapter
import com.example.sipappliaction.data.model.PropertyDataModel
import com.example.sipappliaction.data.model.PropertyModel
import com.example.sipappliaction.databinding.ActivityHousePropertyBinding
import com.example.sipappliaction.feature.admin.property.DetailDataProperty

class HouseProperty : AppCompatActivity() {
    private lateinit var binding: ActivityHousePropertyBinding
    private val adapterProperty: PropertyListAdapter by lazy { PropertyListAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHousePropertyBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        adapterProperty.submitList(PropertyModel.listProperty)
        adapterProperty.setOnClickItem(rvClickListener2)
        binding.rvPropertyList.adapter = adapterProperty
        binding.rvPropertyList.layoutManager = layoutManager
    }

    private val rvClickListener2: (PropertyDataModel) -> Unit =
        {item ->
            startActivity(Intent(this, DetailProperty::class.java).apply {
                putExtra("dataproperty", item)
            })
        }
}