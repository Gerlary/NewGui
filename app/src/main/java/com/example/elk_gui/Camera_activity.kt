package com.example.elk_gui


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.example.elk_gui.mvp.BaseMvpActivity
import com.example.elk_gui.quiz.*
import com.example.elk_gui.storage.PersistantStorage
import com.example.elk_gui.utils.Constants
import com.google.zxing.Result
import kotlinx.android.synthetic.main.camera_activity.*
import me.dm7.barcodescanner.zxing.ZXingScannerView

class Camera_activity : BaseMvpActivity<CameraActivityContract.View, CameraActivityContract.Presenter>(),
    CameraActivityContract.View, View.OnClickListener, ZXingScannerView.ResultHandler {

    private var mScannerView: ZXingScannerView? = null
    private var flashState: Boolean = false
    private var dialog: AlertDialog? = null


    override var mPresenter: CameraActivityContract.Presenter = CameraActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.camera_activity)
        val btnRight: ImageView = findViewById(R.id.btnRightCamera)
        btnRight.setOnClickListener{
            val browserIntent = Intent(this, MainActivity::class.java)
            startActivity(browserIntent)
        }

        initUI()
    }

    override fun onResume() {
        super.onResume()
        mScannerView?.setResultHandler(this)
        mScannerView?.startCamera()
    }

    override fun onPause() {
        super.onPause()
        mScannerView?.stopCamera()
    }

    private fun initUI() {

        mScannerView = ZXingScannerView(this)
        frmContent.addView(mScannerView)

        btnLight.setOnClickListener(this)

        privacyPolicyTextView.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btnLight -> {
                if(flashState) {
                    v.setBackgroundResource(R.drawable.ic_flash_on)
                    showMessage(R.string.flashlight_turned_off)
                    mScannerView?.setFlash(false)
                    flashState = false
                }else {
                    v.setBackgroundResource(R.drawable.ic_flash_off)
                    showMessage(R.string.flashlight_turned_on)
                    mScannerView?.setFlash(true)
                    flashState = true
                }
            }
            R.id.btnRightCamera -> {
                val browserIntent = Intent(this, MainActivity::class.java)
                startActivity(browserIntent)
            }
            R.id.privacyPolicyTextView -> {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(Constants.privacyPolicy))
                startActivity(browserIntent)
            }
        }
    }



    override fun showSuccessScanningDialog(result: String) {

    }

    override fun continueScanning() {
        dialog?.dismiss()
        mScannerView?.resumeCameraPreview(this)
    }

    override fun searchInWWW(url: String) {
        TODO("Not yet implemented")
    }

    override fun handleResult(result: Result?) {
        if(result?.text == "https://www.kaspersky.com") {

            val intent = (Intent(this, QuizActivity::class.java))
            startActivity(intent)
        }
        else if(result?.text == "DEER@ALOXKOOPSX1PSW")
        {
            intMar = 1
            if(!PersistantStorage.getTestValue("1")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo1()

                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions1()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo1()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }

        else if(result?.text == "DEER@TPPFVLSAQR2PDD")
        {
            intMar = 2
            if(!PersistantStorage.getTestValue("2")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo2()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions2()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo2()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@PRIVETMIRU3PUF")
        {
            intMar = 3
            if(!PersistantStorage.getTestValue("3")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo3()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions3()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo3()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@KOLESOEDET4PAW")
        {
            intMar = 4
            if(!PersistantStorage.getTestValue("4")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo4()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions4()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo4()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@LOSYASHIKI5PIY")
        {
            intMar = 5
            if(!PersistantStorage.getTestValue("5")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo5()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions5()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo5()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@DMITRYKLAD6POV")
        {
                intMar = 6
                PersistantStorage.addTestValue("6",true)
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo6()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)

        }
        else if(result?.text == "DEER@KRINGEKIRI7PLL")
        {
            intMar = 7
            if(!PersistantStorage.getTestValue("7")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo7()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions7()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo7()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@XPSKZSIDIS8PPP")
        {
            intMar = 8
            if(!PersistantStorage.getTestValue("8")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo8()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions8()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo8()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@RAZUMNEDUS9PHI")
        {
            intMar = 9
            if(!PersistantStorage.getTestValue("9")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo9()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions9()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo9()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@DBONEDBTWO10PI")
        {
            intMar = 10
            if(!PersistantStorage.getTestValue("10")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo10()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions10()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo10()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@DANYAANTIP11PN")
        {
            intMar = 11
            if(!PersistantStorage.getTestValue("11")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo11()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions11()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo11()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@DEDBIGTAST12PY")
        {
            intMar = 12
            if(!PersistantStorage.getTestValue("12")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo12()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions12()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo12()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@ANNVALORAN13PT")
        {
            intMar = 13
            if(!PersistantStorage.getTestValue("13")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo13()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions13()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo13()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@DANYABELII14PT")
        {
            intMar = 14
            if(!PersistantStorage.getTestValue("14")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo14()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions14()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo14()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@ALYONABEER15PX")
        {
            intMar = 5
            if(!PersistantStorage.getTestValue("15")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo15()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions15()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo15()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@NIKA♥CHIKA16PX")
        {
            intMar = 16
            PersistantStorage.addTestValue("16",true)
            mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo16()
            val intent = Intent(this, PlaceInfo::class.java)
            startActivity(intent)
        }
        else if(result?.text == "DEER@LEXALEPEXA17PP")
        {
            intMar = 17
            if(!PersistantStorage.getTestValue("17")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo17()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions17()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo17()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@LULKEKCHEB18PZ")
        {
            intMar = 18
            if(!PersistantStorage.getTestValue("18")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo18()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions18()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo18()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@PUTITINMYA19PS")
        {
            intMar = 19
            if(!PersistantStorage.getTestValue("19")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo19()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions19()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo19()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@DOKANEPLOX20PO")
        {
            intMar = 20
            if(!PersistantStorage.getTestValue("20")) {

                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo20()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions20()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo20()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else if(result?.text == "DEER@JOJOREFERE21PN")
        {
            intMar = 21
            if(!PersistantStorage.getTestValue("21")) {
                
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo21()
                mQuestionsList = com.example.elk_gui.quiz.Constants.getQuestions21()
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
            else
            {
                mPlaceInfo = com.example.elk_gui.quiz.Constants.getPlaceInfo21()
                val intent = Intent(this, PlaceInfo::class.java)
                startActivity(intent)
            }
        }
        else {
            super.onResume()
            mScannerView?.startCamera()
        }
    }
}
