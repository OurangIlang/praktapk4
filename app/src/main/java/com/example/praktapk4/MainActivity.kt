package com.example.praktapk4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.Nama)
        val etEmail = findViewById<EditText>(R.id.emaile)
        val etPhone = findViewById<EditText>(R.id.nohp)
        val etUrl = findViewById<EditText>(R.id.linkprto)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("EXTRA_NAME", etName.text.toString())
                putExtra("EXTRA_EMAIL", etEmail.text.toString())
                putExtra("EXTRA_PHONE", etPhone.text.toString())
                putExtra("EXTRA_URL", etUrl.text.toString())
            }
            startActivity(intent)
        }
    }
}