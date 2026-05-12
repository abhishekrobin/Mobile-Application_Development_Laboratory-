package com.example.toggle

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.ToggleButton
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

        val toggleButton: ToggleButton = findViewById(R.id.toggleButton)
        val textView: TextView = findViewById(R.id.textView)

        // Set initial state based on ToggleButton's default checked state in XML
        textView.visibility = if (toggleButton.isChecked) View.VISIBLE else View.GONE

        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                textView.visibility = View.VISIBLE
            } else {
                textView.visibility = View.GONE
            }
        }
    }
}
