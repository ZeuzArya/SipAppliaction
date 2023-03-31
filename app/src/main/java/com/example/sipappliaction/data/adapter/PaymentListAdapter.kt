package com.example.sipappliaction.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sipappliaction.data.model.PaymentItemModel
import com.example.sipappliaction.data.model.PropertyDataModel
import com.example.sipappliaction.databinding.PaymentListViewBinding

class PaymentListAdapter: RecyclerView.Adapter<PaymentListAdapter.ViewHolder> () {
    private var itemListener: ((PaymentItemModel) -> Unit)? = null
    private  val data: MutableList<PaymentItemModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PaymentListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(data[position], itemListener)
    }

    override fun getItemCount(): Int = data.size

    fun submitList(list: List<PaymentItemModel>) {
        val initSize = itemCount
        data.clear()
        notifyItemRangeRemoved(0, initSize)
        data.addAll(list)
        notifyItemRangeInserted(0, data.size)
    }

    inner class ViewHolder(private val binding: PaymentListViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(item: PaymentItemModel, listener: ((PaymentItemModel) -> Unit)?){
            with(binding){
                binding.apply {
                    tvPaymentName.text = item.name
                    tvAmmount.text = "Rp. ${item.ammount}"
                }
                root.setOnClickListener {
                    listener?.invoke(item)
                }
            }
        }
    }
    fun setOnClickItem(listener: ((PaymentItemModel) -> Unit)?){
        this.itemListener = listener
    }
}