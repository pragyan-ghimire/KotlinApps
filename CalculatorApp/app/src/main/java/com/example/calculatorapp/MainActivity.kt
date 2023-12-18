package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var inputOperation: TextView? = null
    private var lastNumeric: Boolean = true
    private var lastDot: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputOperation = findViewById(R.id.tV_input)

    }

    fun onDigit(view: View) {
        inputOperation?.append((view as Button).text)
        lastNumeric = true
        lastDot = false

//        Toast.makeText(this,"Button is clicked!",Toast.LENGTH_SHORT).show()
    }

    fun onClear(view: View) {
        inputOperation?.text = ""
        lastNumeric = true
        lastDot = false
    }

    fun onDecimalPoint(view: View) {
        if (lastNumeric && !lastDot) {
            inputOperation?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/") ||
                    value.contains("*") ||
                    value.contains("+") ||
                    value.contains("-")
        }
    }

    fun onOperator(view: View) {
        inputOperation?.text?.let {
            if (lastNumeric && !isOperatorAdded(it.toString())) {
                inputOperation?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }

        }


    }

    fun onEqual(view: View) {
        if (lastNumeric) {
            try {
                var prefix = ""
                var tvValue = inputOperation?.text.toString()
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue =
                        tvValue.substring(1) //omits character at position 1. Takes range as argument
                }

//                for subtraction
                if (tvValue.contains("-")) {
                    var splitValue = tvValue.split("-")
                    var firstOperand = splitValue[0]
                    var secondOperand = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        firstOperand = prefix + firstOperand
                    }
                    inputOperation?.text =
                        (firstOperand.toDouble() - secondOperand.toDouble()).toString()
                }


                //                for addition
                if (tvValue.contains("+")) {
                    var splitValue = tvValue.split("+")
                    var firstOperand = splitValue[0]
                    var secondOperand = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        firstOperand = prefix + firstOperand
                    }
                    inputOperation?.text =
                        (firstOperand.toDouble() + secondOperand.toDouble()).toString()
                }


                //                for multiplication
                if (tvValue.contains("*")) {
                    var splitValue = tvValue.split("*")
                    var firstOperand = splitValue[0]
                    var secondOperand = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        firstOperand = prefix + firstOperand
                    }
                    inputOperation?.text =
                        (firstOperand.toDouble() * secondOperand.toDouble()).toString()
                }


                //                for division
                if (tvValue.contains("/")) {
                    var splitValue = tvValue.split("/")
                    var firstOperand = splitValue[0]
                    var secondOperand = splitValue[1]
                    if (prefix.isNotEmpty()) {
                        firstOperand = prefix + firstOperand
                    }
                    inputOperation?.text =
                        (firstOperand.toDouble() / secondOperand.toDouble()).toString()
                }


            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }

        }
    }

    fun onDel(view: View){
        var getValue=inputOperation?.text.toString()
        if (getValue.isNotEmpty()){
            getValue=getValue.substring(0,getValue.length-1)// omits last character
            inputOperation?.text=getValue
        }
    }
}