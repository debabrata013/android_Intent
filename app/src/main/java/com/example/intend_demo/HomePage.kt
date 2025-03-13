package com.example.intend_demo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intend_demo.R

class HomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val editText = findViewById<EditText>(R.id.editTextText)
        val searchButton = findViewById<Button>(R.id.button2)

        searchButton.setOnClickListener {
            val query = editText.text.toString().trim()
            if (query.isNotBlank()) {
                // Construct the URL for Wikipedia search with the user query encoded properly.
                val url = "https://en.wikipedia.org/w/index.php?search=" + Uri.encode(query)
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            } else {
                Toast.makeText(this, "Please enter a query", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
