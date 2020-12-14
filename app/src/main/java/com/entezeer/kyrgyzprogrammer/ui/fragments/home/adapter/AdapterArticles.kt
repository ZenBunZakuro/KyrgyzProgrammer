package com.entezeer.kyrgyzprogrammer.ui.fragments.home.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.entezeer.core.base.BaseViewHolder
import com.entezeer.kyrgyzprogrammer.data.models.Articles
import com.entezeer.kyrgyzprogrammer.data.models.Lessons
import com.entezeer.kyrgyzprogrammer.ui.fragments.home.adapter.viewholders.ArticleViewHolder
import com.entezeer.kyrgyzprogrammer.ui.fragments.home.adapter.viewholders.LessonsViewHolder

class AdapterArticles(val list: ArrayList<Articles>, var context: Context) :
    RecyclerView.Adapter<BaseViewHolder<Articles>>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Articles> {
        return ArticleViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Articles>, position: Int) {
        holder.bind(list[position])
    }
}
