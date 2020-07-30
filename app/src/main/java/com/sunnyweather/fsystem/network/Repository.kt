package com.sunnyweather.fsystem.network

import android.util.Log
import androidx.lifecycle.liveData
import com.sunnyweather.fsystem.model.*

import com.sunnyweather.fsystem.network.ThingsNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

object Repository {
    fun searchThings( searchRegister: SearchRegister)= liveData(Dispatchers.IO) {
        val result:Result<ThingsResponse> =try {
            Log.e("feifei",searchRegister.email)
            Log.e("feifei",searchRegister.username)
            Log.e("feifei",searchRegister.password)
            val thingsResponse= ThingsNetwork.searchThings(searchRegister)
            Log.e("feifei","HHHHHHHHHHHHHHHH")
            Log.e("feifei",searchRegister.email)
                if(thingsResponse.status!=0){
//                    Log.e("feifei","????????????????????")
                    val Things=thingsResponse
//                    Log.e("feifei","${Things.code}")
                Result.success(Things)
            }else{
//                    Log.e("feifei","????????????????????2")
                Result.failure(RuntimeException("response status is ${thingsResponse.status}"))
            }
        }catch (e:Exception){
            Log.e("feifeicuole",e.message)
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }
    fun searchLogin(searchLogin: SearchLogin) = liveData(Dispatchers.IO) {
        val result:Result<ThingsLogin> = try {
            val thingsResponse = ThingsNetwork.searchLogin(searchLogin)
            if (thingsResponse.status == 200) {
                Log.e("feifei", "????????????????????222")
                val Things = thingsResponse
                Log.e("feifei", "${Things.status}")
                Result.success(Things)
            } else {
                Log.e("feifei", "????????????????????333333")
                Result.failure(RuntimeException("response status is ${thingsResponse.status}"))
            }
        } catch (e: Exception) {
            Log.e("feifeicuole", e.message)
//            Log.e("feifei","????????????????????")
            Result.failure(RuntimeException("response status"))
//            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
        }
        emit(result)
    }
//    fun searchLogin( searchLogin: SearchLogin)= liveData(Dispatchers.IO) {
//        val result:Result<ThingsLogin> =try {
//            val thingsResponse= ThingsNetwork.searchLogin(searchLogin)
//            if(thingsResponse.status!=0){
//                Log.e("feifei","????????????????????222")
//                val Things=thingsResponse
////                Log.e("feifei","${Things.status}")
//                Result.success(Things)
//            }else{
////                Log.e("feifei","????????????????????22")
//                Result.failure(RuntimeException("response status is ${thingsResponse.status}"))
//            }
//        }catch (e:Exception){
//            Log.e("feifeicuole",e.message)
////            Log.e("feifei","????????????????????")
//            Result.failure(RuntimeException("response status"))
////            Result.failure<com.sunnyweather.fsystem.model.ThingsMe>(e)
//        }
//        emit(result)
//    }
}