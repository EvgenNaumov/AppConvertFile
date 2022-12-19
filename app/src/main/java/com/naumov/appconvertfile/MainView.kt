package com.naumov.appconvertfile

import moxy.MvpView

interface MainView:MvpView {
    fun initView()
    fun pressButtonConvertFile()
}