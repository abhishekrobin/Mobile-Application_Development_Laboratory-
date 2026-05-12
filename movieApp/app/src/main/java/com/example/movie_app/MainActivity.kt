package com.example.movie_app

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBasic = findViewById<Button>(R.id.btnBasicDetails)
        val btnAdditional = findViewById<Button>(R.id.btnAdditionalDetails)

        // Load default fragment
        loadFragment(MovieBasicDetailsFragment())

        btnBasic.setOnClickListener {
            loadFragment(MovieBasicDetailsFragment())
        }

        btnAdditional.setOnClickListener {
            loadFragment(MovieAdditionalDetailsFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}