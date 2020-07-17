package com.reloader.corrutinasvmodel

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.reloader.corrutinasvmodel.base.BaseActivity
import com.reloader.corrutinasvmodel.data.RepoImpl
import com.reloader.corrutinasvmodel.domain.UseCaseImpl
import com.reloader.corrutinasvmodel.presentation.viewmodel.MainViewModel
import com.reloader.corrutinasvmodel.presentation.viewmodel.MainViewModelFactory
import com.reloader.corrutinasvmodel.vo.Resource

class MainActivity : BaseActivity() {

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            MainViewModelFactory(UseCaseImpl(RepoImpl()))
        ).get(MainViewModel::class.java)
    }

    override fun getViewID(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        observerData()

    }


    private fun observerData() {


        //si es activity usamos  this,  si es un fragment, viewLifeCicleOwner
        viewModel.fetchVersionCode.observe(this, Observer { result ->
            when (result) {

                is Resource.Loading -> {
                    showProgress()
                }

                is Resource.Success -> {
                    //  txt_version.text = result.data.toString()
                    val actualVersion = result.data
                    if (appIsOutDated(actualVersion)) {
                        showUpdateProgress()
                    }
                    hideProgress()
                }

                is Resource.Failure -> {

                    Toast.makeText(
                        this,
                        "Ocurrio un error ${result.exception.message}",
                        Toast.LENGTH_SHORT
                    ).show()


                    Log.e("ERROR", result.exception.message)

                }
            }
        })
    }


   private fun appIsOutDated(actualVersion: Int): Boolean {

        val buildeVersionCode = BuildConfig.VERSION_CODE
        return buildeVersionCode < actualVersion

    }


}
