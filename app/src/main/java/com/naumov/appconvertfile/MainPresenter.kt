package com.naumov.appconvertfile

import android.view.View
import moxy.MvpPresenter

class MainPresenter(private val view:MainView) {

    private val conversionFile = ConversionFileImpl()

    fun initView(){
        view.initView()
    }

    fun pressButtonConvertFile() {
        view.setImage("ddd")
    }
}