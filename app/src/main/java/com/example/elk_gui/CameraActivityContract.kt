package com.example.elk_gui

import com.example.elk_gui.mvp.BaseMvpPresenter
import com.example.elk_gui.mvp.BaseMvpView
object CameraActivityContract {
    interface View : BaseMvpView {
        fun showSuccessScanningDialog(result: String)
        fun continueScanning()
    }
    interface Presenter: BaseMvpPresenter<View> {

        fun searchByResultBtnPressed(result:String)
        fun copyResultBtnPressed(result: String)
        fun shareResultBtnPressed(result: String)
    }
}