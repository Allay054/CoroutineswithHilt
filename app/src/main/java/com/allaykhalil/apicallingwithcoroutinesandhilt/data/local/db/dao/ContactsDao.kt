package com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ItemSellDbModel

@Dao
abstract class ContactsDao : BaseDao<ItemSellDbModel> {
    /* @Insert
     abstract fun insertContacts(contacts: List<ContactsModel>)*/
    @Insert
    abstract fun insertContacts(itemSellDb: ItemSellDbModel)

    @Query("Select *from ItemToSell")
    abstract fun getAllContacts(): List<ItemSellDbModel>

    @Query("Delete from ItemToSell")
    abstract fun deleteAllContacts()
}