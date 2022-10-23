package com.waracle.mytestapplication.network

import com.waracle.mytestapplication.model.Cake
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl  @Inject constructor(
    private val apiService: ApiService
):ApiHelper{

    override suspend fun getCakes(): Response<List<Cake>> = apiService.getCakes()


}
