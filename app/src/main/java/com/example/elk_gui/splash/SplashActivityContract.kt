package com.example.elk_gui.splash

import com.example.elk_gui.mvp.BaseMvpPresenter
import com.example.elk_gui.mvp.BaseMvpView

object SplashActivityContract {

    interface View : BaseMvpView {
        fun setupPermissions()
        fun startActivity()
        fun requestPermissions()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun permissionGranted()
        fun permissionDenied()
    }
}