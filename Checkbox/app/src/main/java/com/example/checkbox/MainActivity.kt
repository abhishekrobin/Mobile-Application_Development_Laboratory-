package com.example.checkbox

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
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

        val cbPizza = findViewById<CheckBox>(R.id.cbPizza)
        val cbBurger = findViewById<CheckBox>(R.id.cbBurger)
        val cbCoffee = findViewById<CheckBox>(R.id.cbCoffee)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            var totalAmount = 0
            val result = StringBuilder()
            result.append("Selected Items:\n")

            if (cbPizza.isChecked) {
                totalAmount += 150
                result.append("Pizza: 150\n")
            }
            if (cbBurger.isChecked) {
                totalAmount += 120
                result.append("Burger: 120\n")
            }
            if (cbCoffee.isChecked) {
                totalAmount += 80
                result.append("Coffee: 80\n")
            }

            result.append("Total: $totalAmount")

            Toast.makeText(applicationContext, result.toString(), Toast.LENGTH_LONG).show()
        }
    }
}
