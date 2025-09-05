package com.example.calculator

import android.os.Bundle
import android.widget.Button
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

        val zeroButton = findViewById<Button>(R.id.zero_button)
        val oneButton = findViewById<Button>(R.id.one_number)
        val twoButton = findViewById<Button>(R.id.two_number)
        val threeButton = findViewById<Button>(R.id.three_number)
        val fourButton = findViewById<Button>(R.id.four_number)
        val fiveButton = findViewById<Button>(R.id.five_number)
        val sixButton = findViewById<Button>(R.id.six_number)
        val sevenButton = findViewById<Button>(R.id.seven_number)
        val eightButton = findViewById<Button>(R.id.eight_number)
        val nineButton = findViewById<Button>(R.id.nine_number)
        val pointButton = findViewById<Button>(R.id.point_button)

        val equalButton = findViewById<Button>(R.id.equal_button)
        val minusButton = findViewById<Button>(R.id.minus_button)
        val plusButton = findViewById<Button>(R.id.plus_button)
        val multiplyButton = findViewById<Button>(R.id.multiply_button)

        val resultTextView = findViewById<TextView>(R.id.result_textView)

        val numberStringBuilder = StringBuilder()

        oneButton.setOnClickListener {
            numberStringBuilder.append(1)
            resultTextView.text = numberStringBuilder
        }
        twoButton.setOnClickListener {
            numberStringBuilder.append(2)
            resultTextView.text = numberStringBuilder
        }
        threeButton.setOnClickListener {
            numberStringBuilder.append(3)
            resultTextView.text = numberStringBuilder
        }
        fourButton.setOnClickListener {
            numberStringBuilder.append(4)
            resultTextView.text = numberStringBuilder
        }
        fiveButton.setOnClickListener {
            numberStringBuilder.append(5)
            resultTextView.text = numberStringBuilder
        }
        sixButton.setOnClickListener {
            numberStringBuilder.append(6)
            resultTextView.text = numberStringBuilder
        }
        sevenButton.setOnClickListener {
            numberStringBuilder.append(7)
            resultTextView.text = numberStringBuilder
        }
        eightButton.setOnClickListener {
            numberStringBuilder.append(8)
            resultTextView.text = numberStringBuilder
        }
        nineButton.setOnClickListener {
            numberStringBuilder.append(9)
            resultTextView.text = numberStringBuilder
        }
        zeroButton.setOnClickListener {
            numberStringBuilder.append(0)
            resultTextView.text = numberStringBuilder
        }
        equalButton.setOnClickListener {
            numberStringBuilder.append("=")
            resultTextView.text = numberStringBuilder
        }
        plusButton.setOnClickListener {
            numberStringBuilder.append("+")
            resultTextView.text = numberStringBuilder
        }
        minusButton.setOnClickListener {
            numberStringBuilder.append("-")
            resultTextView.text = numberStringBuilder
        }
        multiplyButton.setOnClickListener {
            numberStringBuilder.append("*")
            resultTextView.text = numberStringBuilder
        }
        pointButton.setOnClickListener {
            numberStringBuilder.append(".")
            resultTextView.text = numberStringBuilder
        }
    }
}