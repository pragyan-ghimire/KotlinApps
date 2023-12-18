package com.example.agecalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var tVSelectedDate: TextView? = null
    private var tVDateInMin: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePicker: Button = findViewById(R.id.btn_datePicker)
        tVSelectedDate = findViewById(R.id.tV_selectedDate)
        tVDateInMin = findViewById(R.id.tV_dateInMin)
        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }
    }

    private fun clickDatePicker() {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
            this,
            { view, selectedYear, selectedMonth, dayOfMonth ->

                val selectedDate = "$dayOfMonth/${selectedMonth + 1}/$selectedYear"
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)
                //If theDate is not empty
                theDate?.let {
                    val selectedDateInMins =
                        theDate.time / 60000 // divide by 1000 to convert milliseconds to seconds then by 60 to convert into minutes
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    currentDate?.let {
                        val currentDateInMinutes = currentDate.time / 60000
                        val diffInMinutes = currentDateInMinutes - selectedDateInMins
                        tVSelectedDate?.text = selectedDate  // months starts with 0..11
                        tVDateInMin?.text = diffInMinutes.toString()
                    }


                }

                Toast.makeText(
                    this,
                    " Selected date is $dayOfMonth/${selectedMonth + 1}/$selectedYear",
                    Toast.LENGTH_SHORT
                ).show()

            },
            year,
            month,
            day
        )
        datePickerDialog.datePicker.maxDate =
            System.currentTimeMillis() - 86400000 //current total milliseconds- 1 day milliseconds sets max to yesterday
        datePickerDialog.show()

    }

}