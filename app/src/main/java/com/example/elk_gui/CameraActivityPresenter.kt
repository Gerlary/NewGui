package com.example.elk_gui
import android.util.Patterns
import com.example.elk_gui.mvp.BaseMvpPresenterImpl

open class CameraActivityPresenter: BaseMvpPresenterImpl<CameraActivityContract.View>(),
    CameraActivityContract.Presenter {
    private val preUrl: String = "http://www.google.com/#q="

    override fun searchByResultBtnPressed(result: String) {
        var url: String = result
        if (!Patterns.WEB_URL.matcher(result).matches())
            url = preUrl + result
        mView?.continueScanning()
        mView?.searchInWWW(url)
    }

    override fun copyResultBtnPressed(result: String) {
        mView?.copyToClipboard(result)
        mView?.continueScanning()
        mView?.showMessage(R.string.text_copied)
    }

    override fun shareResultBtnPressed(result: String) {
        mView?.continueScanning()
        mView?.shareResultViewSharingIntent(result)
    }


}