package com.example.sipappliaction.feature.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sipappliaction.R
import com.example.sipappliaction.data.adapter.ChatListAdapter
import com.example.sipappliaction.data.model.WargaModel
import com.example.sipappliaction.databinding.FragmentChatBinding
import com.example.sipappliaction.databinding.FragmentHomeBinding

class ChatFragment : Fragment() {
    private lateinit var binding: FragmentChatBinding
    private val adapterChatList: ChatListAdapter by lazy { ChatListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(activity)

        adapterChatList.submitList(WargaModel.listWarga)
        binding.rvChatList.adapter = adapterChatList
        binding.rvChatList.layoutManager = layoutManager
    }

}