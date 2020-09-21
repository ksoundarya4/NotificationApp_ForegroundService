package com.example.notificationapp

import android.R.id
import android.R.layout
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity: AppCompatActivity() {
    private val editTextInput by lazy {
        findViewById<EditText>(R.id.edit_text_input)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startService(view: View) {
        val input = editTextInput!!.text.toString()
        val serviceIntent = Intent(this, ExampleService::class.java)
        serviceIntent.putExtra("inputExtra", input)
        ContextCompat.startForegroundService(this, serviceIntent)
    }

    fun stopService(view: View) {
        val serviceIntent = Intent(this, ExampleService::class.java)
        stopService(serviceIntent)
    }
}