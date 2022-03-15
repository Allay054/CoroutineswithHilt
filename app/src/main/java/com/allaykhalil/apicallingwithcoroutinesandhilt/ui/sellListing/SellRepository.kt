package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.sellListing

import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseRepository
import com.allaykhalil.apicallingwithcoroutinesandhilt.managers.DataManager
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ItemSellDbModel
import javax.inject.Inject

class SellRepository @Inject constructor(dataManager: DataManager) :
    BaseRepository(dataManager) {


    suspend fun fetchContactsFromDb(): List<ItemSellDbModel>? {
        return dataManager.getDbHelper().getAllContacts()
    }
}