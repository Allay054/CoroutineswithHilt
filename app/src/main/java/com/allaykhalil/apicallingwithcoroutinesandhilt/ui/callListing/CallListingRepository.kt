package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.callListing

import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseRepository
import com.allaykhalil.apicallingwithcoroutinesandhilt.managers.DataManager
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.base.State
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.GetCallListingScreen
import javax.inject.Inject

class CallListingRepository @Inject constructor(dataManager: DataManager) :
    BaseRepository(dataManager) {

    suspend fun fetchCallList(): State<ArrayList<GetCallListingScreen>> {
        return makeApiCall {
            dataManager.getApiHelper().getCallListing()
        }
    }


}