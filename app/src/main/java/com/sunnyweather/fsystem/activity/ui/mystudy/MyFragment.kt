package com.sunnyweather.fsystem.activity.ui.mystudy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sunnyweather.fsystem.R
import com.sunnyweather.fsystem.activity.UserActivity
import com.sunnyweather.fsystem.activity.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.activity_user.*

class MyFragment: Fragment() {
    private lateinit var myViewModel: MyViewModel
//    private val activity=getActivity() as UserActivity
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myViewModel =
            ViewModelProviders.of(this).get(MyViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_my, container, false)
        val textView: TextView = root.findViewById(R.id.text_my)
        myViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.user_toolbar_textView?.text="我"
    }

}