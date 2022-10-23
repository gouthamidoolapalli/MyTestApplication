package com.waracle.mytestapplication.network

import com.waracle.mytestapplication.model.Cake
import retrofit2.Response

interface ApiHelper {
    suspend fun getCakes():Response<List<Cake>>
}
