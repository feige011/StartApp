package com.sunnyweather.fsystem.activity.ui.notifications

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.sunnyweather.fsystem.R
import com.sunnyweather.fsystem.model.ThingsViewModel
import kotlinx.android.synthetic.main.activity_login_forget_password.*
import kotlinx.android.synthetic.main.layout_create_project.*

class NewProject : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_create_project)
        val decorView = window.decorView
        decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = Color.TRANSPARENT
        setSupportActionBar(create_project_tb_toolbar)
        create_project_tb_toolbar.setNavigationIcon(R.drawable.ic_back1)
        create_project_tb_toolbar.setNavigationOnClickListener {
                this.finish()
        }
    }

}