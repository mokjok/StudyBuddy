package com.example.studybuddy

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val prefs = getSharedPreferences("StudyPrefs", MODE_PRIVATE)
        val name = prefs.getString("name", "Student")
        val goal = prefs.getString("goal", "Not set")

        findViewById<TextView>(R.id.tvProfileName).text = "Name: $name"
        findViewById<TextView>(R.id.tvProfileGoal).text = "Study Goal: $goal"
    }
}
