package com.sunnyweather.fsystem.model

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.*
import com.sunnyweather.fsystem.network.Repository

class ThingsViewModel :ViewModel(){
     val searchLiveData=MutableLiveData<SearchRegister>()
//    val placeList=ArrayList<ThingsMe>()
    val placeLiveData=Transformations.switchMap(searchLiveData){
        Log.e("feifei","shibai")
        Repository.searchThings(it)
    }
    fun searchPlaces(name:String,queryPassword :String,queryEmile:String,queryNickname: String){
        Log.e("feifei","shibai3")
        val m=  SearchRegister(name,queryPassword,queryEmile,queryNickname)
        searchLiveData.value=m
        Log.e("feifei",m.username)
    }

    val searchLogin=MutableLiveData<SearchLogin>()
    val placeLiveDataLogin=Transformations.switchMap(searchLogin){
        Log.e("feifei","shibai")
        Repository.searchLogin(it)
    }
    fun searchLogin(queryAdmin:String,queryPassword :String){
        Log.e("feifei","shibai3")
        val m=  SearchLogin(queryAdmin,queryPassword)
        searchLogin.value=m
        Log.e("feifei",m.username)
    }

}