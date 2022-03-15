package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.buyListing.adapters

import androidx.lifecycle.MutableLiveData
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.GetBuyListingScreen


class BuyItemViewModel(model: GetBuyListingScreen) {
    val name = MutableLiveData(model.name)
    val id = MutableLiveData(model.id.toString())
    val price = MutableLiveData(model.price.toString())
    val quantity = MutableLiveData(model.quantity.toString())
    val type = MutableLiveData(model.type.toString())

}

