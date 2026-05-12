package com.example.pan_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

        val etPan = findViewById<EditText>(R.id.et_pan)
        val etPincode = findViewById<EditText>(R.id.et_pincode)
        val btnValidate = findViewById<Button>(R.id.btn_validate)

        btnValidate.setOnClickListener {
            val pan = etPan.text.toString().trim()
            val pincode = etPincode.text.toString().trim()

            if (pan.isEmpty() || pincode.isEmpty()) {
                Toast.makeText(this, "Both fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pan.length != 10 || !isAlphaNumeric(pan)) {
                etPan.error = "PAN must be 10 alphanumeric characters"
                return@setOnClickListener
            }

            if (pincode.length != 6 || !pincode.all { it.isDigit() }) {
                etPincode.error = "Pincode must be 6 digits"
                return@setOnClickListener
            }

            Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isAlphaNumeric(s: String): Boolean {
        val pattern = "^[a-zA-Z0-9]*$".toRegex()
        return s.matches(pattern)
    }
}
