package com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db.dao.ContactsDao
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ItemSellDbModel

@Database(entities = [ItemSellDbModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactsDao(): ContactsDao
}