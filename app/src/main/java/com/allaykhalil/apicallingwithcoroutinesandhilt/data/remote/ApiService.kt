package com.allaykhalil.apicallingwithcoroutinesandhilt.data.remote

import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.GetBuyListingScreen
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.receiveModels.GetCallListingScreen
import retrofit2.http.GET
import retrofit2.Response

/*
 * Created by Allay on 3/15/2022
 */

interface ApiService {
    @GET("imkhan334/demo-1/call")
    suspend fun getCallListing(): Response<ArrayList<GetCallListingScreen>>


    @GET("imkhan334/demo-1/buy")
    suspend fun getBuyListing(): Response<ArrayList<GetBuyListingScreen>>

}