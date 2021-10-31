package com.example.elk_gui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.elk_gui.quiz.*
import com.example.elk_gui.storage.PersistantStorage


@SuppressLint("ClickableViewAccessibility")
class Fragment1() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val draggableMap: ImageView = view.findViewById(R.id.draggableMap)
        val marks: Array<ImageView?> = arrayOfNulls(23)

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



        marks[0] = view.findViewById(R.id.mark1)
        marks[1] = view.findViewById(R.id.mark2)
        marks[2] = view.findViewById(R.id.mark3)
        marks[3] = view.findViewById(R.id.mark4)
        marks[4] = view.findViewById(R.id.mark5)
        marks[5] = view.findViewById(R.id.mark6)
        marks[6] = view.findViewById(R.id.mark7)
        marks[7] = view.findViewById(R.id.mark8)
        marks[8] = view.findViewById(R.id.mark9)
        marks[9] = view.findViewById(R.id.mark10)
        marks[10] = view.findViewById(R.id.mark11_1)
        marks[11] = view.findViewById(R.id.mark11_2)
        marks[12] = view.findViewById(R.id.mark11_3)
        marks[13] = view.findViewById(R.id.mark12)
        marks[14] = view.findViewById(R.id.mark13)
        marks[15] = view.findViewById(R.id.mark14)
        marks[16] = view.findViewById(R.id.mark15)
        marks[17] = view.findViewById(R.id.mark16)
        marks[18] = view.findViewById(R.id.mark17)
        marks[19] = view.findViewById(R.id.mark18)
        marks[20] = view.findViewById(R.id.mark19)
        marks[21] = view.findViewById(R.id.mark20)
        marks[22] = view.findViewById(R.id.mark21)

        for((intMark, i) in marks.withIndex())
            if(PersistantStorage.getTestValue(intMark.toString())){
                i!!.setImageResource(R.drawable.mark_red)
                i.setOnClickListener {
                    mPlaceInfo = plcInfoList[intMark-1]
                    intMar = intMark
                    val intent = Intent(context, PlaceInfo::class.java)
                    startActivity(intent)
                }
            }

        var x: Float = 0f
        var y: Float = 0f

        var scaleFactor = 1f
        val scaleGestureDetector = ScaleGestureDetector(
            view.context,
            object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
                override fun onScale(detector: ScaleGestureDetector): Boolean {
                    scaleFactor *= detector.scaleFactor
                    scaleFactor = scaleFactor.coerceIn(1.0f, 3.0f)
                    draggableMap.scaleX = scaleFactor
                    draggableMap.scaleY = scaleFactor
                    println(marks[10]!!.x)
                    println(marks[10]!!.y)
                    /*for (item in marks.indices) {
                        if (marks[item]!!.y < draggableMap.scaleY/2)
                            marks[item]!!.y -= scaleFactor
                        else
                            marks[item]!!.y += scaleFactor
                        if (marks[item]!!.x < draggableMap.scaleX/2)
                            marks[item]!!.x -= scaleFactor
                        else
                            marks[item]!!.x += scaleFactor
                    }*/

                    return super.onScale(detector)
                }
            })

        var xDown: Float = 0f
        var yDown: Float = 0f
        var listener = View.OnTouchListener(function = { view, motionEvent ->
            x = motionEvent.x
            y = motionEvent.y

            if (motionEvent.pointerCount > 1) {
                //scaleGestureDetector.onTouchEvent(motionEvent)
            } else {
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        //viewPager.isUserInputEnabled = false
                        xDown = x
                        yDown = y
                    }
                    MotionEvent.ACTION_MOVE -> {
                        //view.y = view.y.coerceIn(1.0f, 7.0f)
                        view.y += y - yDown
                        view.x += x - xDown
                        for (item in marks.indices) {
                            marks[item]!!.y += y - yDown
                            marks[item]!!.x += x - xDown
                        }
                        //view.x = view.x.coerceIn(90f, 1830f)
                        //view.x = view.x.coerceIn(-750 - draggableImage.x*draggableImage.scaleX, -90 + draggableImage.x*draggableImage.scaleX)
                        //view.y = view.y.coerceIn(-732f*scaleFactor, -100f*scaleFactor)
                        //println(view.x)
                        //println(view.y)
                    }
                }
            }
            //view.x = motionEvent.rawX - view.x / 2
            true
        })
        draggableMap.setOnTouchListener(listener)
    }
}
