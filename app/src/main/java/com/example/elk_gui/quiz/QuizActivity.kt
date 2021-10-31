package com.example.elk_gui.quiz

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.elk_gui.MainActivity
import com.example.elk_gui.R

var Startlock: Array<Int> = arrayOf(1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1) //6 и 16 - чисто справки
val ButtonList: Array<Button?> = arrayOfNulls(21)
val QuestionsList: Array<ArrayList<Questions>?> = arrayOfNulls(21)
val plcInfoList: Array<String?> = arrayOfNulls(21)

var strForNumb: String? = null


//1 - открыто
//3 - закрыто
class QuizActivity : AppCompatActivity() {

     fun init2() {

        ButtonList[0] = findViewById(R.id.firstlvlbtn)
        ButtonList[1] = findViewById(R.id.secondlvlbtn)
        ButtonList[2] = findViewById(R.id.thirdlvlbtn)
        ButtonList[3] = findViewById(R.id.fourthlvlbtn)
        ButtonList[4] = findViewById(R.id.fifthlvlbtn)
        ButtonList[5] = findViewById(R.id.sixthlvlbtn)
        ButtonList[6] = findViewById(R.id.seventhlvlbtn)
        ButtonList[7] = findViewById(R.id.eighthlvlbtn)
        ButtonList[8] = findViewById(R.id.ninethlvlbtn)
        ButtonList[9] = findViewById(R.id.tenthlvlbtn)
        ButtonList[10] = findViewById(R.id.eleventhlvlbtn)
        ButtonList[11] = findViewById(R.id.twelvelvlbtn)
        ButtonList[12] = findViewById(R.id.thirteenthlvlbtn)
        ButtonList[13] = findViewById(R.id.fourteenthlvlbtn)
        ButtonList[14] = findViewById(R.id.fifteenthlvlbtn)
        ButtonList[15] = findViewById(R.id.sixteenthlvlbtn)
        ButtonList[16] = findViewById(R.id.seventeenthlvlbtn)
        ButtonList[17] = findViewById(R.id.eighteenthlvlbtn)
        ButtonList[18] = findViewById(R.id.nineteenthlvlbtn)
        ButtonList[19] = findViewById(R.id.twentylvlbtn)
        ButtonList[20] = findViewById(R.id.twentyfirstlvlbtn)



        QuestionsList[0] = Constants.getQuestions1()
        QuestionsList[1] = Constants.getQuestions2()
        QuestionsList[2] = Constants.getQuestions3()
        QuestionsList[3] = Constants.getQuestions4()
        QuestionsList[4] = Constants.getQuestions5()
        QuestionsList[6] = Constants.getQuestions7()
        QuestionsList[7] = Constants.getQuestions8()
        QuestionsList[8] = Constants.getQuestions9()
        QuestionsList[9] = Constants.getQuestions10()
        QuestionsList[10] = Constants.getQuestions11()
        QuestionsList[11] = Constants.getQuestions12()
        QuestionsList[12] = Constants.getQuestions13()
        QuestionsList[13] = Constants.getQuestions14()
        QuestionsList[14] = Constants.getQuestions15()
        QuestionsList[16] = Constants.getQuestions17()
        QuestionsList[17] = Constants.getQuestions18()
        QuestionsList[18] = Constants.getQuestions19()
        QuestionsList[19] = Constants.getQuestions20()
        QuestionsList[20] = Constants.getQuestions21()


        plcInfoList[0] = Constants.getPlaceInfo1()
        plcInfoList[1] = Constants.getPlaceInfo2()
        plcInfoList[2] = Constants.getPlaceInfo3()
        plcInfoList[3] = Constants.getPlaceInfo4()
        plcInfoList[4] = Constants.getPlaceInfo5()
        plcInfoList[5] = Constants.getPlaceInfo6()
        plcInfoList[6] = Constants.getPlaceInfo7()
        plcInfoList[7] = Constants.getPlaceInfo8()
        plcInfoList[8] = Constants.getPlaceInfo9()
        plcInfoList[9] = Constants.getPlaceInfo10()
        plcInfoList[10] = Constants.getPlaceInfo11()
        plcInfoList[11] = Constants.getPlaceInfo12()
        plcInfoList[12] = Constants.getPlaceInfo13()
        plcInfoList[13] = Constants.getPlaceInfo14()
        plcInfoList[14] = Constants.getPlaceInfo15()
        plcInfoList[15] = Constants.getPlaceInfo16()
        plcInfoList[16] = Constants.getPlaceInfo17()
        plcInfoList[17] = Constants.getPlaceInfo18()
        plcInfoList[18] = Constants.getPlaceInfo19()
        plcInfoList[19] = Constants.getPlaceInfo20()
        plcInfoList[20] = Constants.getPlaceInfo21()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        var BtnBack:Button? = null
        init2()
        BtnBack = findViewById(R.id.BtnBacknow)
        BtnBack.setOnClickListener{
            val browserIntent = Intent(this, MainActivity::class.java)
            startActivity(browserIntent)
        }

        for(item in ButtonList.indices) {
             if(Startlock[item] == 3){
                 ButtonList[item]!!.setBackgroundColor(Color.GRAY)
             }
                ButtonList[item]!!.setOnClickListener{
                    if (Startlock[item] == 1 || Startlock[item] == 2)
                    {
                        Startlock[item] = 2
                        mPlaceInfo = plcInfoList[item]
                        mQuestionsList = QuestionsList[item]
                        val intent = Intent(this, Test::class.java)
                        startActivity(intent)
                    }
                    else{
                            mPlaceInfo = plcInfoList[item]
                            val intent = Intent(this, PlaceInfo::class.java)
                            startActivity(intent)
                }
            }
        }
    }
}