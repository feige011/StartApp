package com.sunnyweather.fsystem.network


import com.sunnyweather.fsystem.model.SearchLogin
import com.sunnyweather.fsystem.model.SearchRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object ThingsNetwork {
    private val placeService = ServiceCreator.create(ThingsService::class.java)
    suspend fun searchThings( searchRegister: SearchRegister)= placeService.searchRegister(searchRegister.username,searchRegister.password,searchRegister.email,searchRegister.nicknames).await()

    suspend fun searchLogin( searchAdmin: SearchLogin)= placeService.searchLogin(searchAdmin.username,searchAdmin.password).await()
//    suspend fun searchLogin( searchAdmin: SearchLogin)= placeService.searchLogin(searchAdmin.username,searchAdmin.password).await()
    private suspend fun <T>Call<T>.await():T{
        return suspendCoroutine {
            enqueue(object:Callback<T>{
                override fun onFailure(call: Call<T>, t: Throwable) {
                    it.resumeWithException(t)
                }
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body=response.body()
                    if(body!=null) it.resume(body)
                    else it.resumeWithException(
                        RuntimeException("response body is null")
                    )
                }
            })
        }
    }



}