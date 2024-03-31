package com.example.rrtvs

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.Button

open class MainActivity : ComponentActivity() {
    private lateinit var serviceButton: Button
    private lateinit var emergencyButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitymain)

        // Initialize buttons
        serviceButton = findViewById(R.id.service)
        emergencyButton = findViewById(R.id.emergency)

        // Set click listeners
        serviceButton.setOnClickListener {
            val intent = Intent(this, ServiceMain::class.java)
            startActivity(intent)
        }

        emergencyButton.setOnClickListener {
// Handle emergency button click
// Example: initiate emergency service
        }
    }
}
