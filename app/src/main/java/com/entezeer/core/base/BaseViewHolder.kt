package com.entezeer.core.base

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

object ViewTypes {
    const val ArticleViewType = 0
    const val LessonViewType = 1
    const val CategoryViewType = 2
}

abstract class BaseViewHolder<in T>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}