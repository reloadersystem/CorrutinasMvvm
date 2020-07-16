package com.reloader.corrutinasvmodel.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


//reutilizaremos  extender  y sobreescribir metodos de  MainActivity como el OnCreate
abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getViewID())
    }

    protected abstract fun getViewID(): Int

    fun showProgress() {
        progressbar.visibility = View.VISIBLE
    }

    fun hideProgress(){
        progressbar.visibility = View.GONE
    }
}