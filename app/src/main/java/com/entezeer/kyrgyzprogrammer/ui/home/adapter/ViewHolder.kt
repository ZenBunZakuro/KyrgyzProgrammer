package com.entezeer.kyrgyzprogrammer.ui.home.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.data.models.Lessons

class ViewHolder(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView) {
    private var titleItem: TextView = itemView.findViewById(R.id.id_title)
    private var imgItem: ImageView = itemView.findViewById(R.id.id_img)

    fun bind(lesson: Lessons) {
        titleItem.text = lesson.title
        Glide.with(context).load(lesson.img).into(imgItem)
    }
}