package com.example.sipappliaction.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sipappliaction.data.model.PropertyDataModel
import com.example.sipappliaction.data.model.WargaDataModel
import com.example.sipappliaction.databinding.PropertyListViewBinding

class PropertyListAdapter: RecyclerView.Adapter<PropertyListAdapter.ViewHolder> () {
    private var itemListener: ((PropertyDataModel) -> Unit)? = null
    private  val data: MutableList<PropertyDataModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PropertyListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(data[position], itemListener)
    }

    override fun getItemCount(): Int = data.size

    fun submitList(list: List<PropertyDataModel>) {
        val initSize = itemCount
        data.clear()
        notifyItemRangeRemoved(0, initSize)
        data.addAll(list)
        notifyItemRangeInserted(0, data.size)
    }

    inner class ViewHolder(private val binding: PropertyListViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(item: PropertyDataModel, listener: ((PropertyDataModel) -> Unit)?){
            with(binding){
                binding.apply {
                    tvPropertyTittle.text = item.tittle
                    tvAddress.text = item.address
                    tvOwner.text = "Owner: ${item.owner}"

                    root.setOnClickListener {
                        listener?.invoke(item)
                    }
                }
            }
        }
    }
    fun setOnClickItem(listener: ((PropertyDataModel) -> Unit)?){
        this.itemListener = listener
    }
}