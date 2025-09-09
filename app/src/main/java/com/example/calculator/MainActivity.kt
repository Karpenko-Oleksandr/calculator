package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding
import com.ezylang.evalex.Expression

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val numberStringBuilder = StringBuilder()

    private val historyList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setListeners()
    }
    private fun setListeners() = with(binding) {
        oneNumber.setOnClickListener {
            numberStringBuilder.append(1)
            resultTextView.text = numberStringBuilder
        }
        twoNumber.setOnClickListener {
            numberStringBuilder.append(2)
            resultTextView.text = numberStringBuilder
        }
        threeNumber.setOnClickListener {
            numberStringBuilder.append(3)
            resultTextView.text = numberStringBuilder
        }
        fourNumber.setOnClickListener {
            numberStringBuilder.append(4)
            resultTextView.text = numberStringBuilder
        }
        fiveNumber.setOnClickListener {
            numberStringBuilder.append(5)
            resultTextView.text = numberStringBuilder
        }
        sixNumber.setOnClickListener {
            numberStringBuilder.append(6)
            resultTextView.text = numberStringBuilder
        }
        sevenNumber.setOnClickListener {
            numberStringBuilder.append(7)
            resultTextView.text = numberStringBuilder
        }
        eightNumber.setOnClickListener {
            numberStringBuilder.append(8)
            resultTextView.text = numberStringBuilder
        }
        nineNumber.setOnClickListener {
            numberStringBuilder.append(9)
            resultTextView.text = numberStringBuilder
        }
        zeroButton.setOnClickListener {
            numberStringBuilder.append(0)
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
        divideButton.setOnClickListener {
            numberStringBuilder.append("/")
            resultTextView.text = numberStringBuilder
        }
        pointButton.setOnClickListener {
            numberStringBuilder.append(".")
            resultTextView.text = numberStringBuilder
        }
        clearButton.setOnClickListener {
            resultTextView.text="0"
            numberStringBuilder.clear()
        }
        equalButton.setOnClickListener {
            saveToHistory()
            calculate()
        }
        resetButton.setOnClickListener {
            numberStringBuilder.deleteCharAt(numberStringBuilder.length - 1)
            resultTextView.text = numberStringBuilder
        }
        historyButton.setOnClickListener {
            val h = historyList
            val intent = Intent(this@MainActivity, HistoryActivity::class.java)
            intent.putExtra("history_list", historyList.toTypedArray())
            startActivity(intent)
        }
    }

    private fun saveToHistory() {
        val stringExpression = numberStringBuilder.toString()
        historyList.add(stringExpression)
    }

    private fun ActivityMainBinding.calculate() {
        try {

            val stringExpression = numberStringBuilder.toString()
            val expression = Expression(stringExpression)
            val expressionResult = expression.evaluate().numberValue

            resultTextView.text = expressionResult.toString()

            numberStringBuilder.clear()
            numberStringBuilder.append(expressionResult.toString())
        } catch (t: Throwable) {
            Toast.makeText(this@MainActivity, "Exception: $t", Toast.LENGTH_LONG)
                .show()
        }
    }
}