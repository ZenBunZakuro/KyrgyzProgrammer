package com.entezeer.kyrgyzprogrammer.ui.fragments.lessons.adapter

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.entezeer.core.base.BaseViewHolder
import com.entezeer.kyrgyzprogrammer.data.models.Lessons

class AdapterLessons(val list: ArrayList<Lessons>, var listener: Listener) :
    RecyclerView.Adapter<BaseViewHolder<Lessons>>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Lessons> {
        return LessonsViewHolder.create(parent, listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Lessons>, position: Int) {
        holder.bind(list[position])
    }

    interface Listener {
        fun onItemSelectedAt(position: Int)
    }
}

