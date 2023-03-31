package com.example.sipappliaction.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sipappliaction.data.model.WargaDataModel
import com.example.sipappliaction.databinding.DataWargaListViewBinding

class ListDataWarga: RecyclerView.Adapter<ListDataWarga.ViewHolder> () {
    private var itemListener: ((WargaDataModel) -> Unit)? = null
    private  val data: MutableList<WargaDataModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataWargaListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(data[position], itemListener)
    }

    override fun getItemCount(): Int = data.size

    fun submitList(list: List<WargaDataModel>) {
        val initSize = itemCount
        data.clear()
        notifyItemRangeRemoved(0, initSize)
        data.addAll(list)
        notifyItemRangeInserted(0, data.size)
    }

    inner class ViewHolder(private val binding: DataWargaListViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(item: WargaDataModel, listener: ((WargaDataModel) -> Unit)?){
            with(binding){
                tvWargaName.text = item.name
                Glide
                    .with(root.context)
                    .load(item.avatar)
                    .into(ivUserProfile)
                root.setOnClickListener {
                    listener?.invoke(item)
                }
            }
        }
    }
    fun setOnClickItem(listener: ((WargaDataModel) -> Unit)?){
        this.itemListener = listener
    }
}