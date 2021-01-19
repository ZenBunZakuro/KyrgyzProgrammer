package com.entezeer.kyrgyzprogrammer.ui.fragments.articles.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.entezeer.core.base.BaseViewHolder
import com.entezeer.kyrgyzprogrammer.data.models.Articles
import com.entezeer.kyrgyzprogrammer.ui.fragments.articles.ArticlesFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.lessons.adapter.AdapterLessons

class AdapterArticles(
    val list: ArrayList<Articles>,
    var context: Context,
    var listener: Listener
) :
    RecyclerView.Adapter<BaseViewHolder<Articles>>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Articles> {
        return ArticleViewHolder.create(parent, listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Articles>, position: Int) {
        holder.bind(list[position])
    }

    interface Listener {
        fun onItemSelectedAt(position: Int)
    }
}

