package com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels

import com.google.gson.annotations.SerializedName

/**
 * Created by Allay on 3/15/2022
 */
data class GetBuyListingScreen(
    @SerializedName("id")
    val id: Int?=null,
    @SerializedName("name")
    val name: String?=null,
    @SerializedName("price")
    val price: String?=null,
    @SerializedName("quantity")
    val quantity: Int?=null,
    @SerializedName("type")
    val type: Int?=null
    )

