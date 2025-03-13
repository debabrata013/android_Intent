//package com.example.intend_demo
//
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.ImageView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.intend_demo.R
//
//class HomePage : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home_page)
//
//        val editText = findViewById<EditText>(R.id.editTextText)
//        val searchButton = findViewById<Button>(R.id.button2)
//
//        searchButton.setOnClickListener {
//            val query = editText.text.toString().trim()
//            if (query.isNotBlank()) {
//                // Construct the URL for Wikipedia search with the user query encoded properly.
//                val url = "https://en.wikipedia.org/w/index.php?search=" + Uri.encode(query)
//                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                startActivity(browserIntent)
//            } else {
//                Toast.makeText(this, "Please enter a query", Toast.LENGTH_SHORT).show()
//            }
//        }
//         var Camera =findViewById<Button>(R.id.Camera)
//        var ImageViwe =findViewById<ImageView>(R.id.ImageViwe)
//        Camera.setOnClickListener {
//            val intent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivity(intent)
//
//        }
//    }
//}
package com.example.intend_demo

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intend_demo.R

class HomePage : AppCompatActivity() {

    companion object {
        private const val CAMERA_REQUEST_CODE = 100
    }

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val editText = findViewById<EditText>(R.id.editTextText)
        val searchButton = findViewById<Button>(R.id.button2)
        val DateAndTimePicker = findViewById<Button>(R.id.button3)
        DateAndTimePicker.setOnClickListener {
            val intent = Intent(this, DateAndTimePicker::class.java)
            startActivity(intent)
        }
        imageView = findViewById(R.id.ImageViwe)
        val cameraButton = findViewById<Button>(R.id.Camera)

        // Wikipedia search functionality
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

        // Camera functionality
        cameraButton.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, CAMERA_REQUEST_CODE)
        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val photo: Bitmap? = data?.extras?.get("data") as? Bitmap
            if (photo != null) {
                imageView.setImageBitmap(photo)
            } else {
                Toast.makeText(this, "Failed to capture image", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
