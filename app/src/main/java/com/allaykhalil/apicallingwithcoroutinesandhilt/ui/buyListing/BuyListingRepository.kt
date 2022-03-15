package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.buyListing

import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseRepository
import com.allaykhalil.apicallingwithcoroutinesandhilt.managers.DataManager
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.base.State
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.GetBuyListingScreen
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.GetCallListingScreen
import javax.inject.Inject

class BuyListingRepository @Inject constructor(dataManager: DataManager) :
    BaseRepository(dataManager) {

    suspend fun fetchBuyList(): State<ArrayList<GetBuyListingScreen>> {
        return makeApiCall {
            dataManager.getApiHelper().getBuyListing()
        }
    }


}