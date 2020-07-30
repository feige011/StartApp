package com.sunnyweather.fsystem.network


import com.sunnyweather.fsystem.model.ThingsLogin
import com.sunnyweather.fsystem.model.ThingsResponse
import retrofit2.Call
import retrofit2.http.*

interface ThingsService  {
    @GET("/user/getUser/{username}/{password}")
    fun searchThings(@Path("username")queryAdmin:String,@Path("password")queryPassword:String): Call<ThingsResponse>

    @FormUrlEncoded
    @POST("api/user/register")
    fun searchRegister(@Field("username")username :String,@Field("password")password :String, @Field("email") email:String,@Field("nicknames")nicknames:String):Call<ThingsResponse>

    @FormUrlEncoded
    @POST("api/user/login")
    fun searchLogin(@Field("username")account :String,@Field("password") password:String):Call<ThingsLogin>

//    @POST("/api/file/uploadFolder")
//    fun getPhoto(@Field("file"))
}