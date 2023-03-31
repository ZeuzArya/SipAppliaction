package com.example.sipappliaction.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sipappliaction.data.model.WargaDataModel
import com.example.sipappliaction.databinding.ChatListViewBinding
import com.example.sipappliaction.databinding.WargaListViewBinding

class ChatListAdapter: RecyclerView.Adapter<ChatListAdapter.ViewHolder> (){

    private  val data: MutableList<WargaDataModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ChatListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun submitList(list: List<WargaDataModel>) {
        val initSize = itemCount
        data.clear()
        notifyItemRangeRemoved(0, initSize)
        data.addAll(list)
        notifyItemRangeInserted(0, data.size)
    }

    inner class ViewHolder(private val binding: ChatListViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(item: WargaDataModel){
            with(binding){
                tvUserChatName.text = "${item.name}"
                Glide
                    .with(root.context)
                    .load(item.avatar)
                    .into(imageView2)
            }
        }
    }
}