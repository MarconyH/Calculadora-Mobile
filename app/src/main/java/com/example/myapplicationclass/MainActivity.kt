package com.example.myapplicationclass

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private fun getNumbers(): List<Double> {
        val text1 = findViewById<TextInputEditText>(R.id.textInputEditText).text.toString()
        val text2 = findViewById<TextInputEditText>(R.id.textInputEditText2).text.toString()
        val numbers = mutableListOf<Double>()
        if (text1.isEmpty() || text2.isEmpty()) {
            return numbers
        }
        numbers.add(text1.toDouble())
        numbers.add(text2.toDouble())
        return numbers
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonPlus = findViewById<Button>(R.id.button)
        val buttonMinus = findViewById<Button>(R.id.button2)
        val buttonTimes = findViewById<Button>(R.id.button3)
        val buttonDivides = findViewById<Button>(R.id.button4)

        buttonPlus.setOnClickListener {
            val numbers = getNumbers()
            if (numbers.isNotEmpty()){
                val result = numbers[0] + numbers[1]
                findViewById<TextView>(R.id.textView2).text = result.toString()
            }
            else{
                findViewById<TextView>(R.id.textView2).text = "Invalido"
            }
        }
        buttonMinus.setOnClickListener {
            val numbers = getNumbers()
            if (numbers.isNotEmpty()){
                val result = numbers[0] - numbers[1]
                findViewById<TextView>(R.id.textView2).text = result.toString()
            }
            else{
                findViewById<TextView>(R.id.textView2).text = "Invalido"
            }
        }
        buttonTimes.setOnClickListener {
            val numbers = getNumbers()
            if (numbers.isNotEmpty()){
                val result = numbers[0] * numbers[1]
                findViewById<TextView>(R.id.textView2).text = result.toString()
            }
            else{
                findViewById<TextView>(R.id.textView2).text = "Invalido"
            }
        }
        buttonDivides.setOnClickListener {
            val numbers = getNumbers()
            if (numbers.isNotEmpty() && numbers[1] != 0.0){
                val result = numbers[0] / numbers[1]
                findViewById<TextView>(R.id.textView2).text = result.toString()
            }
            else{
                findViewById<TextView>(R.id.textView2).text = "Invalido"
            }
        }

    }

}

