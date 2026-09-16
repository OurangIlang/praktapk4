package com.example.praktapk4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // impor dari Mainactivity
        val name = intent.getStringExtra("EXTRA_NAME") ?: ""
        val email = intent.getStringExtra("EXTRA_EMAIL") ?: ""
        val phone = intent.getStringExtra("EXTRA_PHONE") ?: ""
        val url = intent.getStringExtra("EXTRA_URL") ?: ""

        //Hubungkan dengan ID dari activityprofile
        val tvProfileName = findViewById<TextView>(R.id.tvProfileName)
        val tvProfileEmail = findViewById<TextView>(R.id.tvProfileEmail)
        val tvProfilePhone = findViewById<TextView>(R.id.tvProfilePhone)
        val tvProfileUrl = findViewById<TextView>(R.id.tvProfileUrl)

        //Tampilkan ke UI
        tvProfileName.text = name
        tvProfileEmail.text = email
        tvProfilePhone.text = phone
        tvProfileUrl.text = url

        val btnWebsite = findViewById<Button>(R.id.btnWebsite)
        val btnDial = findViewById<Button>(R.id.btnDial)
        val btnShare = findViewById<Button>(R.id.btnShare)

        // Eksekusi Implicit intent
        // Browser
        btnWebsite.setOnClickListener {
            var formattedUrl = url
            if (!formattedUrl.startsWith("http://") && !formattedUrl.startsWith("https://")) {
                formattedUrl = "https://$formattedUrl"
            }
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(formattedUrl))
            startActivity(webIntent)
        }

        //Dialer
        btnDial.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
            startActivity(dialIntent)
        }

        // Share
        btnShare.setOnClickListener {
            val shareText = "Nama: $name\nEmail: $email\nNo HP: $phone\nPortofolio: $url"
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }
            startActivity(Intent.createChooser(shareIntent, "Bagikan Profil"))
        }
    }
}