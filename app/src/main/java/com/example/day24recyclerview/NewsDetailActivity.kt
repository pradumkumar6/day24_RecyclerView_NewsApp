package com.example.day24recyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val heading = intent.getStringExtra("heading")
        val newsContent = intent.getStringExtra("newsContent")
        val imageId = intent.getIntExtra("imageId", R.drawable.img9)

        val headingTextView = findViewById<TextView>(R.id.newsHeading)
        val headingImageView = findViewById<ImageView>(R.id.newsImage)
        val newsContentView = findViewById<TextView>(R.id.newsContent)

        headingTextView.text = heading
        newsContentView.text = newsContent
        headingImageView.setImageResource(imageId)

    }
}