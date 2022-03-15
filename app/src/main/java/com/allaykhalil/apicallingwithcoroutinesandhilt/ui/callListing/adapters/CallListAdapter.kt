package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.callListing.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject
import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseViewHolder
import com.allaykhalil.apicallingwithcoroutinesandhilt.databinding.ItemCallsBinding
import com.allaykhalil.apicallingwithcoroutinesandhilt.interfaces.AdapterUpdateListener
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.GetCallListingScreen


class CallListAdapter @Inject constructor() :
    RecyclerView.Adapter<CallListAdapter.ItemViewHolder>(), AdapterUpdateListener<GetCallListingScreen> {
    val allCallList = ArrayList<GetCallListingScreen>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemCallsBinding.inflate(
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
        return allCallList.size
    }

    override fun clearItems() {
        allCallList.clear()
        notifyDataSetChanged()
    }

    override fun addItems(items: List<GetCallListingScreen>, isLoadMore: Boolean) {
        if (!isLoadMore) {
            clearItems()
            allCallList.addAll(items as Collection<GetCallListingScreen>)
            notifyDataSetChanged()
        }
    }

    inner class ItemViewHolder(val binding: ItemCallsBinding) : BaseViewHolder(binding.root) {
        override fun onBind(position: Int) {
            binding.viewModel = CallItemViewModel(allCallList[position])

            binding.executePendingBindings()
        }
    }
}