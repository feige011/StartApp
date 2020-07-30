package com.sunnyweather.fsystem.model
data class ThingsResponse(val status:Int,val description:String,val data:ThingsResponseis)
data class ThingsResponseis(val id:String,val username:String,val password:String,val nicknames:String,
                            val email:String,val phone:String,val enabled:String,
                            val createtime:String,val remark:String)
data class ThingsLogin(val timestamp :String, val status: Int, val  error:String, val message:String,val path:String)
data class SearchLogin(var username:String, var password:String)

data class SearchRegister(var username:String,var password :String,var email:String,var nicknames:String)

//data class Things()