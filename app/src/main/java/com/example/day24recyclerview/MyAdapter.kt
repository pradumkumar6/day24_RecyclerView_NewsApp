package com.example.day24recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsArrayList: ArrayList<News>, var context: Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    lateinit var myListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setItemClickListener(listener: onItemClickListener) {
        myListener = listener
    }

    // To create a new view instance
    //When layout manager fails to find the suitable view for each item
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    //Populates items with data
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.hTitle.text = currentItem.newsHeading
        holder.hImage.setImageResource(currentItem.newsImage)
    }

    // How many list items are present in your array
    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    // It holds the view so that views are not created everytime. So memory can be saved
    class MyViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val hTitle = itemView.findViewById<TextView>(R.id.headingTitle)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}