package com.example.studyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var kotlinBt: Button
    lateinit var androidBt: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Study App"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kotlinBt = findViewById(R.id.kotlinBtn)
        androidBt = findViewById(R.id.androidBtn)

        kotlinBt.setOnClickListener {
            val intent = Intent(this, KotlinActivity ::class.java)
            startActivity(intent)
        }
        androidBt.setOnClickListener {
            val intent = Intent(this, AndroidActivity ::class.java)
            startActivity(intent)
        }
    }
    fun navigateTo(activityName:String){
        val intent = Intent(this, activityName ::class.java)
        startActivity(intent)
    }
}