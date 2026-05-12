package com.example.user_app

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etAge: EditText
    private lateinit var rgColour: RadioGroup
    private lateinit var etBio: EditText
    private lateinit var btnSave: Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etAge = findViewById(R.id.etAge)
        rgColour = findViewById(R.id.rgColour)
        etBio = findViewById(R.id.etBio)
        btnSave = findViewById(R.id.btnSave)

        sharedPreferences = getSharedPreferences("UserProfilePrefs", Context.MODE_PRIVATE)

        // Load saved data
        loadProfileData()

        btnSave.setOnClickListener {
            saveProfileData()
        }
    }

    private fun saveProfileData() {
        val name = etName.text.toString()
        val email = etEmail.text.toString()
        val age = etAge.text.toString()
        val bio = etBio.text.toString()
        val selectedColourId = rgColour.checkedRadioButtonId

        sharedPreferences.edit {
            putString("name", name)
            putString("email", email)
            putString("age", age)
            putString("bio", bio)
            putInt("colour_id", selectedColourId)
        }

        Toast.makeText(this, "Profile Saved", Toast.LENGTH_SHORT).show()
    }

    private fun loadProfileData() {
        val name = sharedPreferences.getString("name", "")
        val email = sharedPreferences.getString("email", "")
        val age = sharedPreferences.getString("age", "")
        val bio = sharedPreferences.getString("bio", "")
        val colourId = sharedPreferences.getInt("colour_id", -1)

        etName.setText(name)
        etEmail.setText(email)
        etAge.setText(age)
        etBio.setText(bio)
        if (colourId != -1) {
            rgColour.check(colourId)
        }
    }
}
