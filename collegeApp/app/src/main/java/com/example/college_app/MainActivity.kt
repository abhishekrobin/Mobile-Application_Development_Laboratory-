package com.example.college_app

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.regex.Pattern

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

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnValidate = findViewById<Button>(R.id.btnValidate)

        btnValidate.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // i) Both the fields should not be empty
            if (email.isEmpty()) {
                etEmail.error = "Email ID cannot be empty"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                etPassword.error = "Password cannot be empty"
                return@setOnClickListener
            }

            // ii) Email id field should have proper college email id (ending with .edu or similar)
            if (!isValidCollegeEmail(email)) {
                etEmail.error = "Enter a valid college email ID (e.g., name@college.edu)"
                return@setOnClickListener
            }

            // iii) Password field validation
            if (!isValidPassword(password)) {
                etPassword.error = "Password must be at least 12 chars, include 1 uppercase, 1 digit, and 1 special symbol"
                return@setOnClickListener
            }

            Toast.makeText(this, "Validation Successful!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidCollegeEmail(email: String): Boolean {
        // Standard email pattern and typically college emails end with .edu
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.endsWith(".edu", ignoreCase = true)
    }

    private fun isValidPassword(password: String): Boolean {
        // Regex for: 1 Uppercase, 1 Numeric, 1 Special Symbol, Min 12 Characters
        val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{12,}$"
        val pattern = Pattern.compile(passwordPattern)
        return pattern.matcher(password).matches()
    }
}