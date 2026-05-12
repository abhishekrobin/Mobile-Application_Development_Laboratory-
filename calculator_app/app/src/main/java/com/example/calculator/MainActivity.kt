package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        val etNum1 = findViewById<EditText>(R.id.etNum1)
        val etNum2 = findViewById<EditText>(R.id.etNum2)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnAdd.setOnClickListener {
            val num1 = etNum1.text.toString().toDoubleOrNull()
            val num2 = etNum2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                tvResult.text = (num1 + num2).toString()
            } else {
                tvResult.text = getString(R.string.error_invalid_input)
            }
        }

        btnSubtract.setOnClickListener {
            val num1 = etNum1.text.toString().toDoubleOrNull()
            val num2 = etNum2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                tvResult.text = (num1 - num2).toString()
            } else {
                tvResult.text = getString(R.string.error_invalid_input)
            }
        }

        btnMultiply.setOnClickListener {
            val num1 = etNum1.text.toString().toDoubleOrNull()
            val num2 = etNum2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                tvResult.text = (num1 * num2).toString()
            } else {
                tvResult.text = getString(R.string.error_invalid_input)
            }
        }

        btnDivide.setOnClickListener {
            val num1 = etNum1.text.toString().toDoubleOrNull()
            val num2 = etNum2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                if (num2 != 0.0) {
                    tvResult.text = (num1 / num2).toString()
                } else {
                    tvResult.text = getString(R.string.error_divide_by_zero)
                }
            } else {
                tvResult.text = getString(R.string.error_invalid_input)
            }
        }
    }
}
