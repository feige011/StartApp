package com.sunnyweather.fsystem.activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sunnyweather.fsystem.R
import com.sunnyweather.fsystem.model.ThingsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val viewModel by lazy { ViewModelProvider(this).get(ThingsViewModel::class.java)}
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val decorView = window.decorView
        decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = Color.TRANSPARENT
        losePassword.setOnClickListener {
            val intent=Intent(this,LoginForgetPassword::class.java)
            startActivity(intent)
        }
        newUser.setOnClickListener {
            val intent =Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
        login.setOnClickListener {
            viewModel.searchLogin(admin.text.toString(),password.text.toString())
//           val intent=Intent(this,UserActivity::class.java)
//            startActivity(intent)
        }

        viewModel.placeLiveDataLogin.observe(this, Observer {
            val things=it.getOrNull()
            if(things!=null){
                if(things.status==200){
                    val intent=Intent(this,UserActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Log.e("feifei",things.status.toString())
                }
            }else{
                Log.e("feifei","shibai333333")
            }
        })

        viewModel.searchLiveData.observe(this, Observer {
            Log.e("feifei","shibai22222222222")
        })
    }
}
