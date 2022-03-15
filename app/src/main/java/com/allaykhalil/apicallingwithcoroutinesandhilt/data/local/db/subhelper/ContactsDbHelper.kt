package com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db.subhelper

import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ItemSellDbModel


interface ContactsDbHelper {
    /*fun insertContacts(contacts: List<ContactsModel>)*/
    fun insertContacts(itemSellDb: ItemSellDbModel)
  //  fun deleteAllContacts()
    fun getAllContacts(): List<ItemSellDbModel>?
}