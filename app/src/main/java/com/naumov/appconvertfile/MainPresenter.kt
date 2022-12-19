package com.naumov.appconvertfile

import moxy.MvpPresenter

class MainPresenter:MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initView()
    }




}