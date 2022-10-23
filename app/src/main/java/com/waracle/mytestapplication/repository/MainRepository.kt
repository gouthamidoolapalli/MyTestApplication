package com.waracle.mytestapplication.repository

import com.waracle.mytestapplication.network.ApiHelper
import javax.inject.Inject

class MainRepository@Inject constructor(
     val apiHelper: ApiHelper
){

    suspend fun getCakes() = apiHelper.getCakes()

}