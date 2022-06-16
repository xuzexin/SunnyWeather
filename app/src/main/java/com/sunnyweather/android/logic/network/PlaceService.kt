package com.sunnyweather.android.logic.network

import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {



    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    //Call<PlaceResponse> 这样Retrofit会将服务器返回的JSAON数据自动解析成PlaceResponse对象
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>

}