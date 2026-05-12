package com.example.temp_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tempInput = findViewById<EditText>(R.id.tempInput)
        val conversionType = findViewById<RadioGroup>(R.id.conversionType)
        val convertButton = findViewById<Button>(R.id.convertButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        convertButton.setOnClickListener {
            val inputStr = tempInput.text.toString()
            if (inputStr.isNotEmpty()) {
                val inputTemp = inputStr.toDouble()
                val selectedId = conversionType.checkedRadioButtonId
                
                if (selectedId == R.id.toFahrenheit) {
                    // Celsius to Fahrenheit: (C * 9/5) + 32
                    val result = (inputTemp * 9 / 5) + 32
                    resultText.text = getString(R.string.fahrenheit_result, result)
                } else {
                    // Fahrenheit to Celsius: (F - 32) * 5/9
                    val result = (inputTemp - 32) * 5 / 9
                    resultText.text = getString(R.string.celsius_result, result)
                }
            } else {
                resultText.text = getString(R.string.please_enter_value)
            }
        }
    }
}
