package com.dangerx.quoteapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val quotes = mutableListOf(
        "The only way to do great work is to love what you do. - Steve Jobs",
        "Success is not final, failure is not fatal: It is the courage to continue that counts. - Winston Churchill",
        "Don't watch the clock; do what it does. Keep going. - Sam Levenson"
        // Add more quotes as needed
    )

    private lateinit var quoteText: TextView
    private lateinit var userQuoteInput: EditText
    private lateinit var quoteContainerButton: Button
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteText = findViewById(R.id.quoteText)
        userQuoteInput = findViewById(R.id.userQuoteInput)
        quoteContainerButton = findViewById(R.id.quoteContainer)
        saveButton = findViewById(R.id.saveButton)

        quoteContainerButton.setOnClickListener {
            showRandomQuote()
        }

        saveButton.setOnClickListener {
            saveUserQuote()
        }
    }

    private fun showRandomQuote() {
        val randomIndex = Random.nextInt(quotes.size)
        val randomQuote = quotes[randomIndex]
        quoteText.text = randomQuote
    }

    private fun saveUserQuote() {
        val userQuote = userQuoteInput.text.toString().trim()

        if (userQuote.isNotEmpty()) {
            quotes.add(userQuote)
            userQuoteInput.text.clear()
        }
    }
}
