package com.example.elk_gui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.elk_gui.storage.PersistantStorage

class Fragment2() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.profile_view, container, false)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Add Data to Database

        var exp: Int = 10
        var places: Int = 0
       var hooves: Int = PersistantStorage.getInt("hooves")
       /* val db = Room.databaseBuilder(
            ,
            AppDatabase::class.java,
            "MyDatabase.db"
        ).build()

        //val db = AppDatabase(this)

        var data = db?.userDao()?.gethooves()
        var hooves = data?.first()?.hooves
        *///var hooves: Int =
        //var hooves: Int = data.
        //hooves =args.currentUser.age
        val profileName: TextView = view.findViewById(R.id.profileName)
        val expText: TextView = view.findViewById(R.id.varTextAchievements)
        val placesText: TextView = view.findViewById(R.id.varTextPlaces)
        val hoovesText: TextView = view.findViewById(R.id.varTextHooves)
        val buttonAchievements: Button = view.findViewById(R.id.btnAchievements)
        val buttonShop: Button = view.findViewById(R.id.btnShop)
        val switchView: ViewFlipper = view.findViewById(R.id.viewSwitcher)
        val btnName: Button = view.findViewById(R.id.btnName)
        val textName: EditText = view.findViewById(R.id.dialogNameEt)
        val btnBack: Button = view.findViewById(R.id.dialogAgreeBtn)

        profileName.text = PersistantStorage.getName("name")
        expText.text = "$exp"
        placesText.text = "$places"
        hoovesText.text = "$hooves"

        buttonAchievements.setOnClickListener {
            switchView.displayedChild = 3
        }
        btnName.setOnClickListener {

            switchView.displayedChild = 2
            btnBack.setOnClickListener {
                PersistantStorage.addName("name", textName.text.toString())
                profileName.text = PersistantStorage.getName("name")
            }
        }
        buttonShop.setOnClickListener {
            switchView.displayedChild = 1
            val btnGet: Array<Button?> = arrayOfNulls(4)
            btnGet[0] = view.findViewById(R.id.btnGet1)
            btnGet[1] = view.findViewById(R.id.btnGet2)
            btnGet[2] = view.findViewById(R.id.btnGet3)
            btnGet[3] = view.findViewById(R.id.btnGet4)
            val checkIcon: Array<ImageView?> = arrayOfNulls(4)
            checkIcon[0] = view.findViewById(R.id.shopCheckIcon1)
            checkIcon[1] = view.findViewById(R.id.shopCheckIcon2)
            checkIcon[2] = view.findViewById(R.id.shopCheckIcon3)
            checkIcon[3] = view.findViewById(R.id.shopCheckIcon4)

            if(PersistantStorage.getTestValue("shop1")) {
                btnGet[0]!!.isVisible = false
                checkIcon[0]!!.setImageResource(R.drawable.check)
            }
            if(PersistantStorage.getTestValue("shop2")) {
                btnGet[1]!!.isVisible = false
                checkIcon[1]!!.setImageResource(R.drawable.check)
            }
            if(PersistantStorage.getTestValue("shop3")) {
                btnGet[2]!!.isVisible = false
                checkIcon[2]!!.setImageResource(R.drawable.check)
            }
            if(PersistantStorage.getTestValue("shop4")) {
                btnGet[3]!!.isVisible = false
                checkIcon[3]!!.setImageResource(R.drawable.check)
            }

            btnGet[0]!!.setOnClickListener {
                if (hooves!! - 10 >= 0) {
                    hooves -= 10
                    hoovesText.text = "$hooves"
                    PersistantStorage.addInt("hooves", hooves)
                    checkIcon[0]!!.setImageResource(R.drawable.check)
                    PersistantStorage.addTestValue("shop1",true)
                    btnGet[0]!!.isVisible = false
                }
            }
            btnGet[1]!!.setOnClickListener {
                if (hooves!! - 20 >= 0) {
                    hooves -= 20
                    hoovesText.text = "$hooves"
                    checkIcon[1]!!.setImageResource(R.drawable.check)
                    PersistantStorage.addInt("hooves", hooves)
                    PersistantStorage.addTestValue("shop2",true)
                    btnGet[1]!!.isVisible = false
                }
            }
            btnGet[2]!!.setOnClickListener {
                if (hooves!! - 50 >= 0) {
                    hooves -= 50
                    hoovesText.text = "$hooves"
                    PersistantStorage.addInt("hooves", hooves)
                    checkIcon[2]!!.setImageResource(R.drawable.check)
                    PersistantStorage.addTestValue("shop3",true)
                    btnGet[2]!!.isVisible = false
                }
            }
            btnGet[3]!!.setOnClickListener {
                if (hooves!! - 100 >= 0) {
                    hooves -= 100
                    hoovesText.text = "$hooves"
                    PersistantStorage.addInt("hooves", hooves)
                    checkIcon[3]!!.setImageResource(R.drawable.check)
                    PersistantStorage.addTestValue("shop4",true)
                    btnGet[3]!!.isVisible = false
                }
            }
        }
    }
}