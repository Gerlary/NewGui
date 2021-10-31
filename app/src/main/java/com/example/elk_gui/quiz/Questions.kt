package com.example.elk_gui.quiz

data class Questions (
    val id:Int,
    val question : String,
    val optOne: String,
    val optTwo: String,
    val optThree: String,
    val optFour: String,
    val correctAnswer: Int
)