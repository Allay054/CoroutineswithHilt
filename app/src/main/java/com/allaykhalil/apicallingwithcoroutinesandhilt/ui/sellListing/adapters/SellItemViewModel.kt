package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.sellListing.adapters

import androidx.lifecycle.MutableLiveData
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ItemSellDbModel

class SellItemViewModel(model: ItemSellDbModel) {
    val name = MutableLiveData("Name: " + model.name)
    val price = MutableLiveData("Price: " + model.price)
    val quantity = MutableLiveData("Quantity: " + model.quantity.toString())
    val type = MutableLiveData("Type:" + model.type.toString())
}