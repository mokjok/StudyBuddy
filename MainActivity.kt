package com.example.studybuddy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvWelcome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvWelcome = findViewById(R.id.tvWelcome)
        val btnSettings: Button = findViewById(R.id.btnSettings)
        val btnProfile: Button = findViewById(R.id.btnProfile)

        loadPreferences()

        btnSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }

    private fun loadPreferences() {
        val prefs = getSharedPreferences("StudyPrefs", MODE_PRIVATE)
        val name = prefs.getString("name", "Student")
        tvWelcome.text = "Welcome back, $name!"
    }
}
