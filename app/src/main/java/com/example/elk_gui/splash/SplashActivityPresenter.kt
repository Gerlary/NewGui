package com.example.elk_gui.splash

import com.example.elk_gui.mvp.BaseMvpPresenterImpl

open class SplashActivityPresenter: BaseMvpPresenterImpl<SplashActivityContract.View>(),
        SplashActivityContract.Presenter {

    override fun permissionGranted() {
        mView?.startActivity()
    }

    override fun permissionDenied() {
        mView?.setupPermissions()
    }


}