package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var etName: EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart: Button =findViewById(R.id.btn_start)
        etName=findViewById(R.id.et_name)
        btnStart.setOnClickListener {
            var username=etName?.text.toString()
            if (username.isEmpty()){
               Toast.makeText(this,"Please enter your name.",Toast.LENGTH_SHORT).show()
            }else{
                var intent= Intent(this,QuizQuestionActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
    }
}