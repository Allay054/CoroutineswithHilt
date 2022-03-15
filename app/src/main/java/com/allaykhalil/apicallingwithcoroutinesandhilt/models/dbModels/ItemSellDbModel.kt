package com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Allay on 3/15/2022
 */

@Entity(tableName = "ItemToSell")
//@TypeConverters(PhoneTypeConverter::class)
data class ItemSellDbModel(
    @PrimaryKey(autoGenerate = true)
    val dbId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("type")
    val type: Int
)