package com.sunnyweather.fsystem.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val URL = "http://106.54.55.188:8082/xingcheng/"
    private val retrofit =
        Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create())
            .build()
    fun <T> create(serviceClass:Class<T>):T= retrofit.create(serviceClass)

    inline fun <reified T>create():T= create(T::class.java)
}