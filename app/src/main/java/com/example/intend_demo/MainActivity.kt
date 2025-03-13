package com.example.intend_demo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val editTextUsername = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.editTextPassword)

        val button = findViewById<Button>(R.id.buttonLogin)
        button.setOnClickListener {
            // Launch the HomePage activity
            // Replace HomePage::class.java with the actual name of your HomePage activity
            if (editTextUsername.text.toString() == "admin" && editTextPassword.text.toString() == "admin") {

            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
            else{
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
    }






}}
