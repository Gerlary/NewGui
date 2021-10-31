package com.example.elk_gui.quiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.elk_gui.MainActivity
import com.example.elk_gui.R
import kotlinx.android.synthetic.main.activity_place_info.*
var mPlaceInfo: String? = null
var intMar:Int? = null

class PlaceInfo : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_info)
        //placePic.setImageResource(R.drawable.pic2)
        /*mPlaceInfo = Constants.getPlaceInfo1()
        tv_info.text = mPlaceInfo
        */
        /*
        for(item in Startlock.indices)
        {
            if(Startlock[item] == 2)
            {
                when(item)
                {
                    0->{
                        mPlaceInfo = Constants.getPlaceInfo1()
                        placePic.setImageResource(R.drawable.pic1)
                    }
                    1->{
                        mPlaceInfo = Constants.getPlaceInfo2()
                        placePic.setImageResource(R.drawable.pic2)
                    }
                    2->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic3)

                    }
                    3->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic4)

                    }
                    4->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic5)

                    }
                    5->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic6)

                    }
                    6->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic7)

                    }
                    7->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic8)

                    }
                    8->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic9)

                    }
                    9->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic10)

                    }
                    10->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic11)

                    }
                    11->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic12)

                    }
                    12->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic13)

                    }
                    13->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic14)

                    }
                    14->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic15)

                    }
                    15->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic16)

                    }
                    16->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic17)

                    }
                    17->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic18)

                    }
                    18->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic19)

                    }
                    19->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic20)

                    }
                    20->{
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic21)

                    }

                }

            }
            if (Startlock[item] == 3) {
                when(item){
                    5 -> {
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic6)
                    }
                    15 -> {
                        mPlaceInfo = Constants.getPlaceInfo3()
                        placePic.setImageResource(R.drawable.pic16)

                    }
                }
            }


        }
        */


        when(intMar)
        {
            1 ->{placePic.setImageResource(R.drawable.pic1)}
            2 ->{placePic.setImageResource(R.drawable.pic2)}
            3 ->{placePic.setImageResource(R.drawable.pic3)}
            4 ->{placePic.setImageResource(R.drawable.pic4)}

            5 ->{placePic.setImageResource(R.drawable.pic5)}
            6 ->{placePic.setImageResource(R.drawable.pic6)}
            7 ->{placePic.setImageResource(R.drawable.pic7)}
            8 ->{placePic.setImageResource(R.drawable.pic8)}
            9 ->{placePic.setImageResource(R.drawable.pic9)}
            10 ->{placePic.setImageResource(R.drawable.pic10)}
            11 ->{placePic.setImageResource(R.drawable.pic11)}
            12 ->{placePic.setImageResource(R.drawable.pic12)}
            13 ->{placePic.setImageResource(R.drawable.pic13)}
            14 ->{placePic.setImageResource(R.drawable.pic14)}
            15 ->{placePic.setImageResource(R.drawable.pic15)}
            16 ->{placePic.setImageResource(R.drawable.pic16)}
            17 ->{placePic.setImageResource(R.drawable.pic17)}
            18 ->{placePic.setImageResource(R.drawable.pic18)}
            19 ->{placePic.setImageResource(R.drawable.pic19)}
            20 ->{placePic.setImageResource(R.drawable.pic20)}
            21 ->{placePic.setImageResource(R.drawable.pic21)}


        }


        tv_info.text = mPlaceInfo
        btn_finish.setOnClickListener {
            for(item in Startlock.indices)
            {

                if(Startlock[item] == 2 || Startlock[item] == 3)
                {
                    Startlock[item] = 3
                    val intent = (Intent(this, MainActivity::class.java))
                    startActivity(intent)
                }
            }
        }


    }
}