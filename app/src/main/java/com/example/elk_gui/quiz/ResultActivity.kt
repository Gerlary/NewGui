package com.example.elk_gui.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.elk_gui.R
import kotlinx.android.synthetic.main.activity_place_info.*
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val totalQuestions: Float = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0).toFloat()
        val correctAnswer:Float = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0).toFloat()

        tv_score.text = "${correctAnswer.toInt()} / ${totalQuestions.toInt()}"

        val a = (correctAnswer / totalQuestions)

        when {
            a < 0.4 -> {
                tv_comment.text = "Повезет в следующий раз"
            }
            a in 0.4..0.68 -> {
                tv_comment.text = "Неплохо!"
            }
            a in 0.68..1.0 -> {
                tv_comment.text = "Отлично!"
            }
        }
        for(item in Startlock.indices)
        {
            if(Startlock[item] == 2)
            {
                when(item)
                {
                    0->{
                        gifka.setImageResource(R.drawable.monument)
                    }
                    1->{
                        gifka.setImageResource(R.drawable.coin)
                    }
                    2->{
                        gifka.setImageResource(R.drawable.mysight)
                    }
                    3->{
                        gifka.setImageResource(R.drawable.loupe)
                    }
                    4->{
                        gifka.setImageResource(R.drawable.landmark)
                    }
                    5->{
                        gifka.setImageResource(R.drawable.mysight)
                    }
                    6->{
                        gifka.setImageResource(R.drawable.landmark)
                    }
                    7->{
                        gifka.setImageResource(R.drawable.book)
                    }
                    8->{
                        gifka.setImageResource(R.drawable.monument)
                    }
                    9->{
                        gifka.setImageResource(R.drawable.book)
                    }
                    10->{
                        gifka.setImageResource(R.drawable.book)
                    }
                    11->{
                        gifka.setImageResource(R.drawable.monument)
                    }
                    12->{
                        gifka.setImageResource(R.drawable.ww1)
                    }
                    13->{
                        gifka.setImageResource(R.drawable.ww2)
                    }
                    14->{
                        gifka.setImageResource(R.drawable.monument)
                    }
                    15->{
                        gifka.setImageResource(R.drawable.mim)
                    }
                    16->{
                        gifka.setImageResource(R.drawable.book)
                    }
                    17->{
                        gifka.setImageResource(R.drawable.bug)
                    }
                    18->{
                        gifka.setImageResource(R.drawable.train)
                    }
                    19->{
                        gifka.setImageResource(R.drawable.planet)
                    }
                    20->{
                        gifka.setImageResource(R.drawable.book)
                    }
                }
            }

        }
        btn_info.setOnClickListener {
            val intent = (Intent(this, PlaceInfo::class.java))
            startActivity(intent)
        }
    }
}