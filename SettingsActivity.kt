package com.example.studybuddy

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etGoal: EditText
    private lateinit var switchNotifications: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        etName = findViewById(R.id.etName)
        etGoal = findViewById(R.id.etGoal)
        switchNotifications = findViewById(R.id.switchNotifications)
        val btnSave: Button = findViewById(R.id.btnSave)

        loadCurrentSettings()

        btnSave.setOnClickListener {
            saveSettings()
        }
    }

    private fun loadCurrentSettings() {
        val prefs = getSharedPreferences("StudyPrefs", MODE_PRIVATE)
        etName.setText(prefs.getString("name", ""))
        etGoal.setText(prefs.getString("goal", ""))
        switchNotifications.isChecked = prefs.getBoolean("notifications", true)
    }

    private fun saveSettings() {
        val prefs = getSharedPreferences("StudyPrefs", MODE_PRIVATE)
        val editor = prefs.edit()

        editor.putString("name", etName.text.toString())
        editor.putString("goal", etGoal.text.toString())
        editor.putBoolean("notifications", switchNotifications.isChecked)
        editor.apply()

        Toast.makeText(this, "Settings Saved Successfully!", Toast.LENGTH_SHORT).show()
        finish()
    }
}
