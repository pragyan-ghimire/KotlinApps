package com.example.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var i=0
        var txtView = findViewById<TextView>(R.id.textView)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            Toast.makeText(this,"You clicked button!",Toast.LENGTH_SHORT).show()
            i++
            txtView.text=i.toString()
        }

    }
}