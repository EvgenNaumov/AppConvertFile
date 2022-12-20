package com.naumov.appconvertfile

import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts

class MainPresenter(private val view:MainView,private val registry : ActivityResultRegistry) {

    private val contract = ActivityResultContracts.GetContent()
    private val conversionFile = ConversionFileImpl()
    private lateinit var getContent : ActivityResultLauncher<String>

    fun initView(){
        view.initView()
        getContent = registry.register("key",contract){
            setImageOld(it)

            if (it != null) {
                doConvertFile(it.path.toString())
                setImageNew(it)

            }

        }
    }

    private fun doConvertFile(t: String) {

        conversionFile.conversionFile(t, object :callbaclConversion{
            override fun onSucces(t: String) {

            }

            override fun onError(e: Throwable) {

            }
        })
    }

    interface callbaclConversion{
        fun onSucces(t:String)
        fun onError(e:Throwable)

    }

    fun сonvertFile(){
        getContent.launch("image/*.jpg")
    }

    private fun setImageOld(uri: Uri?){
        if (uri != null) {
            view.setImageOld(uri)
            view.setTextImageOld(uri.path.toString())
        }
    }

    private fun setImageNew(uri: Uri?){
        if (uri != null) {
            view.setImageNew(uri)
            view.setTextImageNew(uri.path.toString())
        }
    }

}