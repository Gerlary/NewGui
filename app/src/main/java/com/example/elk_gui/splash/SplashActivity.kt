package com.example.elk_gui.splash

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.room.Room
import com.example.elk_gui.MainActivity
import com.example.elk_gui.R

import com.example.elk_gui.mvp.BaseMvpActivity
import com.example.elk_gui.storage.PersistantStorage

class SplashActivity: BaseMvpActivity<SplashActivityContract.View, SplashActivityContract.Presenter>(),
        SplashActivityContract.View {

    private val RECORD_REQUEST_CODE = 101
    override var mPresenter: SplashActivityContract.Presenter = SplashActivityPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        PersistantStorage.init(this)
        setupPermissions()
    }

    override fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)

        if (permission != PackageManager.PERMISSION_GRANTED)
        {
            /*
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "MyDatabase.db"
            ).build()
            val newOne = UserData(0,123,"asd")
            db.userDao().insert(newOne)
            val data = db.userDao().gethooves()
            System.out.print(data.first().hooves)
            */requestPermissions()
        }
        else
            mPresenter.permissionGranted()
    }

    override fun startActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

    override fun requestPermissions() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CAMERA),
                RECORD_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            RECORD_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    mPresenter.permissionDenied()
                } else {
                    mPresenter.permissionGranted()
                }
            }
        }
    }

}