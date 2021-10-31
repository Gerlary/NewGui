package com.example.elk_gui.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.elk_gui.R
import com.example.elk_gui.storage.PersistantStorage
import kotlinx.android.synthetic.main.activity_test.*
var mQuestionsList: ArrayList<Questions>? = null
class Test : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private  var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers: Int = 0
    private var locked: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        supportActionBar?.hide();

        when(intMar)
        {
            1->{progBar.max = 3}
            2->{progBar.max = 4}
            3->{progBar.max = 7}
            4->{progBar.max = 8}
            5->{progBar.max = 8}

            7->{progBar.max = 3}
            8->{progBar.max = 2}
            9->{progBar.max = 2}
            10->{progBar.max = 2}
            11->{progBar.max = 2}
            12->{progBar.max = 1}
            13->{progBar.max = 3}
            14->{progBar.max = 3}
            15->{progBar.max = 2}

            17->{progBar.max = 2}
            18->{progBar.max = 1}
            19->{progBar.max = 2}
            20->{progBar.max = 2}
            21->{progBar.max = 2}
        }



        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)

        btn_submit.setOnClickListener(this)
    }
    private fun setQuestion()
    {
        val questions = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        btn_submit.text = "ВЫБРАТЬ"

        if(btn_submit.text == "ВЫБРАТЬ"){
            locked = true
        }



        progBar.progress = mCurrentPosition//?????
        txtprogress.text = "$mCurrentPosition" + "/" + progBar.getMax()

        tv_question.text = questions.question
        tv_option_one.text = questions.optOne
        tv_option_two.text = questions.optTwo
        tv_option_three.text = questions.optThree
        tv_option_four.text = questions.optFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.tv_option_one->{
                if(locked){
                    selectedOptionView(tv_option_one, 1)
                }
            }
            R.id.tv_option_two->{
                if(locked){
                    selectedOptionView(tv_option_two, 2)
                }
            }
            R.id.tv_option_three->{
                if(locked){
                    selectedOptionView(tv_option_three, 3)
                }
            }
            R.id.tv_option_four->{
                if(locked){
                    selectedOptionView(tv_option_four, 4)
                }
            }

            R.id.btn_submit->{


                if(mSelectedOptionPosition == 0)
                {
                    mCurrentPosition++

                    when
                    {
                        mCurrentPosition <= mQuestionsList!!.size->
                        {
                            setQuestion()
                        }
                        else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            PersistantStorage.addTestValue(intMar?.toString(),true)
                            PersistantStorage.addInt("hooves",PersistantStorage.getInt("hooves")+10)
                            startActivity(intent)
                        }

                    }
                }
                else
                {
                    val questions = mQuestionsList?.get(mCurrentPosition -1)
                    if(questions!!.correctAnswer != mSelectedOptionPosition)
                    {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(questions.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btn_submit.text = "ЗАВЕРШИТЬ"
                    }else{
                        btn_submit.text = "СЛЕДУЮЩИЙ ВОПРОС"
                    }
                    if(btn_submit.text == "СЛЕДУЮЩИЙ ВОПРОС"){
                        locked = false
                    }
                }
                mSelectedOptionPosition = 0
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 ->{
                tv_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 ->{
                tv_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 ->{
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 ->{
                tv_option_four.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int)
    {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

}