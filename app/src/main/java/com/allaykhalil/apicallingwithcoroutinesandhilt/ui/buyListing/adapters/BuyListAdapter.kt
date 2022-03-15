package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.buyListing.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseViewHolder
import com.allaykhalil.apicallingwithcoroutinesandhilt.databinding.ItemBuyBinding
import com.allaykhalil.apicallingwithcoroutinesandhilt.interfaces.AdapterUpdateListener
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.GetBuyListingScreen


class BuyListAdapter @Inject constructor() :
    RecyclerView.Adapter<BuyListAdapter.ItemViewHolder>(),
    AdapterUpdateListener<GetBuyListingScreen> {
    val allBuyList = ArrayList<GetBuyListingScreen>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemBuyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(position)
        holder.binding.laData.setOnClickListener {
            Toast.makeText(it.context, "Under Development", Toast.LENGTH_SHORT).show()

        }
    }

    override fun getItemCount(): Int {
        return allBuyList.size
    }

    override fun clearItems() {
        allBuyList.clear()
        notifyDataSetChanged()
    }

    override fun addItems(items: List<GetBuyListingScreen>, isLoadMore: Boolean) {
        if (!isLoadMore) {
            clearItems()
            allBuyList.addAll(items as Collection<GetBuyListingScreen>)
            notifyDataSetChanged()
        }
    }

    inner class ItemViewHolder(val binding: ItemBuyBinding) : BaseViewHolder(binding.root) {
        override fun onBind(position: Int) {
            binding.viewModel = BuyItemViewModel(allBuyList[position])

            binding.executePendingBindings()
        }
    }
}