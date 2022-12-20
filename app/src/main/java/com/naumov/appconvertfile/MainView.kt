package com.naumov.appconvertfile

import android.net.Uri
import moxy.MvpView

interface MainView {
    fun initView()
    fun setImageOld(path: Uri)
    fun setTextImageOld(t:String)
    fun setImageNew(path: Uri)
    fun setTextImageNew(t:String)
}