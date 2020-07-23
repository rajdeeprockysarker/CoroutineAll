package com.raj.coroutineall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import kotlinx.android.synthetic.main.activity_main.*

class LiveDataScopeActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModelLiveDataScope
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //////////////////////  ViewModelLiveDataScope
        viewModel = ViewModelProvider(this).get(ViewModelLiveDataScope::class.java)
        viewModel.user.observe(this, Observer {
            println("DEBUG: $it")
            Log.e("xfdfdfd",it.toString())
            text.text=it.toString()

        })
         viewModel.setUserId(1)
        //////////////////////


    }

    fun settxe(s:String){
        text.text=s
    }
}