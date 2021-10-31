package com.example.elk_gui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2

@SuppressLint("ClickableViewAccessibility")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_main)

        val btnRight: ImageView = findViewById(R.id.buttonRight)
        val btnLeft: ImageView = findViewById(R.id.buttonLeft)
        val viewPager: ViewPager2 = findViewById(R.id.introViewPager)
        val adapter = SimpleFragmentPagerAdapter(this, viewPager)
        viewPager.adapter = adapter

        viewPager.isUserInputEnabled = false
        viewPager.currentItem = 1

        btnRight.setOnClickListener {
            //viewPager.isUserInputEnabled = true
            btnLeft.isVisible = true
            if (viewPager.currentItem + 1 < adapter.itemCount)
                viewPager.currentItem += 1
            if (viewPager.currentItem + 2 == adapter.itemCount)
                btnRight.setImageResource(R.drawable.about_app)
            if (viewPager.currentItem + 1 == adapter.itemCount)
                btnRight.isVisible = false
        }

        btnLeft.setOnClickListener {
            //viewPager.isUserInputEnabled = true
            btnRight.setImageResource(R.drawable.arrow_right)
            btnRight.isVisible = true
            if (viewPager.currentItem + 1 == adapter.itemCount)
                btnRight.setImageResource(R.drawable.about_app)
            if (viewPager.currentItem - 1 >= 0)
                viewPager.currentItem -= 1
            if (viewPager.currentItem - 1 < 0) {
                /*
                PersistantStorage.init(this)
                PersistantStorage.addProperty("asd","NYUA")
                val asr :String = PersistantStorage.getProperty("asd")
                println(asr)
                */
                val intent = (Intent(this, Camera_activity::class.java))

                startActivity(intent)
                //btnLeft.isVisible = false
            }

        }
    }
}