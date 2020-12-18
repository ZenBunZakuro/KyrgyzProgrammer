package com.entezeer.kyrgyzprogrammer.ui.fragments.lessons.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.entezeer.core.base.BaseViewHolder
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.data.models.Lessons

class LessonsViewHolder(itemView: View) :
    BaseViewHolder<Lessons>(itemView) {
    private var titleItem: TextView = itemView.findViewById(R.id.id_title)
    private var imgItem: ImageView = itemView.findViewById(R.id.id_img)

    override fun bind(lesson: Lessons) {
        titleItem.text = lesson.title
        context?.let { Glide.with(it).load(lesson.img).diskCacheStrategy(DiskCacheStrategy.ALL).into(imgItem) }
    }

    companion object {
        var context: Context? = null
        fun create(parent: ViewGroup): LessonsViewHolder {
            val holder =
                LessonsViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycle_item, parent, false)
                )
            context = parent.context
            return holder
        }
    }
}