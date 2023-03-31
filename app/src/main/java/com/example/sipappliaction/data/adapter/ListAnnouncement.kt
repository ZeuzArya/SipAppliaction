package com.example.sipappliaction.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sipappliaction.data.model.AnnounceItemModel
import com.example.sipappliaction.databinding.AnnouncementListViewBinding

class ListAnnouncement: RecyclerView.Adapter<ListAnnouncement.ViewHolder> () {

    private  val data: MutableList<AnnounceItemModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AnnouncementListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun submitList(list: List<AnnounceItemModel>) {
        val initSize = itemCount
        data.clear()
        notifyItemRangeRemoved(0, initSize)
        data.addAll(list)
        notifyItemRangeInserted(0, data.size)
    }

    inner class ViewHolder(private val binding: AnnouncementListViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(item: AnnounceItemModel){
            with(binding){
                tvAnnouncement.text = item.tittle
                tvTime.text = item.time
            }
        }
    }
}