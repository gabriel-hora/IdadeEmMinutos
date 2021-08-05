package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var txt_date_picker : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDataPicker = findViewById<Button>(R.id.btnDatePicker)
        txt_date_picker = findViewById<TextView>(R.id.txt_date_picker)

        btnDataPicker.setOnClickListener {view ->
            clickDatePicker(view)
        }
    }

    fun clickDatePicker(view: View) {

        val calendario = Calendar.getInstance()
        val year = calendario.get(Calendar.YEAR)
        val month = calendario.get(Calendar.MONTH)
        val day = calendario.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            Toast.makeText(this, "$dayOfMonth/${month + 1}/$year", Toast.LENGTH_LONG).show()

            val dataSelecionada = "$dayOfMonth/${month + 1}/$year"
            txt_date_picker?.text = dataSelecionada

        }, year, month, day).show()
    }
}