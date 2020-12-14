package com.entezeer.kyrgyzprogrammer.ui.fragments.home.adapter.viewholders

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.entezeer.core.base.BaseViewHolder
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.data.models.Articles

class ArticleViewHolder(itemView: View) :
    BaseViewHolder<Articles>(itemView) {
    private var titleItem: TextView = itemView.findViewById(R.id.id_title)
    private var imgItem: ImageView = itemView.findViewById(R.id.id_img)

    override fun bind(article: Articles) {
        titleItem.text = article.title
        context?.let { Glide.with(it).load(article.img).into(imgItem) }
    }

    companion object {
        var context: Context? = null
        fun create(parent: ViewGroup): ArticleViewHolder {
            val holder =
                ArticleViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycle_item, parent, false)
                )
            context = parent.context
            return holder
        }
    }
}