package com.reloader.corrutinasvmodel

import android.os.Bundle
import com.reloader.corrutinasvmodel.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }

    override fun getViewID(): Int = R.layout.activity_main
}
