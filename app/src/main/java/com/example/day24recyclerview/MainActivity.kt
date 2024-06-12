package com.example.day24recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var newsArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        myRecyclerView = findViewById(R.id.recyclerView)
        // Create an image array
        val newsImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
//            R.drawable.img10
        )
        // Create a news Heading array
        val newsHeadingArray = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
            "It has been a disappointing T20 World Cup 2024 campaign for the Pakistan cricket team till now as the Babar Azam-led side slumped to a 6-run loss against India.",
            "South Africa defeated Bangladesh by just four runs in another low-scoring game at the T20 World Cup on Monday",
            "T20 World Cup 2024: Matthew Wade Reprimanded For Showing Dissent Following Umpire's Decision",
            "Tried to develop PMO as catalytic agent’: PM Modi addresses officials on Day 1"
        )
        val newsContent = arrayOf(
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
        )
        // To set items inside recycler view
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()
        for (index in newsImageArray.indices) {
            val news = News(newsHeadingArray[index], newsImageArray[index], newsContent[index])
            newsArrayList.add(news)
        }
        val myAdapter = MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = myAdapter
        myAdapter.setItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                // On clicking each item , what action do you want to perform
                val intent = Intent(this@MainActivity, NewsDetailActivity::class.java)
                intent.putExtra("heading", newsArrayList[position].newsHeading)
                intent.putExtra("imageId", newsArrayList[position].newsImage)
                intent.putExtra("newsContent", newsArrayList[position].newsContent)
                startActivity(intent)
            }

        })
    }
}