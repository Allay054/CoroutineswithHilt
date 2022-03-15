package com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db.subhelper

import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ItemSellDbModel


abstract class ContactsDbHelperImpl : BaseDbHelper(), ContactsDbHelper {
   /* override fun deleteAllContacts() {
        mAppDatabase?.contactsDao()?.deleteAllContacts()
    }*/

    /* override fun insertContacts(contacts: List<ContactsModel>) {
         mAppDatabase?.contactsDao()?.insertContacts(contacts)
     }*/

    override fun insertContacts(itemSellDb: ItemSellDbModel) {
        mAppDatabase?.contactsDao()?.insertContacts(itemSellDb)
    }

    override fun getAllContacts(): List<ItemSellDbModel>? {
        return mAppDatabase?.contactsDao()?.getAllContacts()
    }
}