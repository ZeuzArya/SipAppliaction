package com.example.sipappliaction.feature.home

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.sipappliaction.R
import com.example.sipappliaction.data.adapter.ListAnnouncement
import com.example.sipappliaction.data.adapter.ListWarga
import com.example.sipappliaction.data.model.AnnouncementModel
import com.example.sipappliaction.data.model.UserModel
import com.example.sipappliaction.data.model.WargaModel
import com.example.sipappliaction.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val adapterWarga: ListWarga by lazy { ListWarga() }
    private val adapterAnnouncement: ListAnnouncement by lazy { ListAnnouncement() }
    private var homeInterface : HomeFragmentInterface? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is HomeFragmentInterface){
            homeInterface = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManagerHorizontal = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val layoutManager = LinearLayoutManager(activity)

        binding.tvUserName.text = "Hi, ${UserModel.nama}"
        Glide
            .with(this)
            .load(UserModel.avatar)
            .into(binding.ivUser)

        adapterAnnouncement.submitList(AnnouncementModel.announcementItem)
        binding.rvAnnouncement.adapter = adapterAnnouncement
        binding.rvAnnouncement.layoutManager = layoutManager

        adapterWarga.submitList(WargaModel.listWarga)
        binding.rvWarga.adapter = adapterWarga
        binding.rvWarga.layoutManager = layoutManagerHorizontal

        binding.cvRumah.setOnClickListener {
            homeInterface?.onClickHouse()
        }
        binding.cvIuran.setOnClickListener {
            homeInterface?.onClickPayment()
        }
        binding.cvKeluhan.setOnClickListener {
            homeInterface?.onClickReport()
        }
    }

}