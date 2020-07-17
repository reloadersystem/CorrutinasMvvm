package com.reloader.corrutinasvmodel.base

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
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

    fun hideProgress() {
        progressbar.visibility = View.GONE
    }

    fun showUpdateProgress() {

        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Existe una nueva version de la App, por favor Actulize")
            .setCancelable(false)
            //{ dialog, which -> { dialog, which ->  DialogInterface.setOnclickListener
            .setPositiveButton("Actualizar Ahora") { dialog, which ->

                openAppInPlaystore("com.mobile.legends")
                dialog.dismiss()
            }
            .setNegativeButton("Ahora no") { dialog, which ->
                dialog.dismiss()
            }

        val alert = dialogBuilder.create()
        alert.setTitle("Actulización Disponible")
        alert.show()
    }

    private fun openAppInPlaystore(appPackageName: String) {
        //si la app existe
        try {

            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=$appPackageName")
                )
            )
        } catch (e: ActivityNotFoundException) {
            startActivity(
                Intent(
                    (Intent.ACTION_VIEW),
                    Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                )
            )
        }

    }
}