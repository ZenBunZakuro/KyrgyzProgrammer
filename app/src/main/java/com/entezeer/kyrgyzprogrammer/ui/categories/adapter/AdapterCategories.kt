package com.entezeer.kyrgyzprogrammer.ui.categories.adapter

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.entezeer.core.base.BaseViewHolder
import com.entezeer.kyrgyzprogrammer.data.models.Category

class AdapterCategories(val list: ArrayList<Category>, var listener: Listener) :
    RecyclerView.Adapter<BaseViewHolder<Category>>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Category> {
        return CategoriesViewHolder.create(parent, listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Category>, position: Int) {
        holder.bind(list[position])
    }

    interface Listener {
        fun onItemSelectedAt(position: Int, title: String, textView: TextView)
    }
}

