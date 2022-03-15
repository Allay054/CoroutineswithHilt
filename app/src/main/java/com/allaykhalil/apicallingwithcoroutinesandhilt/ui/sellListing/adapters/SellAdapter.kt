package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.sellListing.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseViewHolder
import com.allaykhalil.apicallingwithcoroutinesandhilt.databinding.ItemSellBinding
import com.allaykhalil.apicallingwithcoroutinesandhilt.interfaces.AdapterUpdateListener
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ItemSellDbModel
import javax.inject.Inject

class SellAdapter @Inject constructor() :
    RecyclerView.Adapter<SellAdapter.ItemViewHolder>(), AdapterUpdateListener<ItemSellDbModel> {
    val contactList = ArrayList<ItemSellDbModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemSellBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun clearItems() {
        contactList.clear()
        notifyDataSetChanged()
    }

    override fun addItems(items: List<ItemSellDbModel>, isLoadMore: Boolean) {
        if (!isLoadMore) {
            clearItems()
            contactList.addAll(items as Collection<ItemSellDbModel>)
            notifyDataSetChanged()
        }
    }

    inner class ItemViewHolder(val binding: ItemSellBinding) : BaseViewHolder(binding.root) {
        override fun onBind(position: Int) {
            binding.viewModel = SellItemViewModel(contactList[position])
            binding.executePendingBindings()
        }
    }
}