package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.callListing.adapters

import androidx.lifecycle.MutableLiveData
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.GetCallListingScreen


class CallItemViewModel(model: GetCallListingScreen) {
    val name = MutableLiveData(model.name)
    val id = MutableLiveData(model.id.toString())
    val number = MutableLiveData(model.number)
}

