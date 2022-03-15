package com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels

import com.google.gson.annotations.SerializedName

/**
 * Created by Allay on 3/15/2022
 */
data class GetCallListingScreen(
    @SerializedName("id")
    val id: Int?=null,
    @SerializedName("name")
    val name: String?=null,
    @SerializedName("number")
    val number: String?=null

    )

