package com.entezeer.kyrgyzprogrammer.ui.fragments.categories.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.entezeer.core.base.BaseViewHolder
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.data.models.Category
import com.entezeer.kyrgyzprogrammer.ui.fragments.categories.adapter.AdapterCategories.Listener

class CategoriesViewHolder(itemView: View) :
    BaseViewHolder<Category>(itemView) {
    private var titleItem: TextView = itemView.findViewById(R.id.id_title)
    private var imgItem: ImageView = itemView.findViewById(R.id.id_img)

    override fun bind(category: Category) {
        titleItem.text = category.name
        context?.let {
            Glide.with(it).load(category.img).diskCacheStrategy(DiskCacheStrategy.ALL).into(imgItem)
        }

        ViewCompat.setTransitionName(titleItem, category.name)

        itemView.setOnClickListener {
            listener?.onItemSelectedAt(position, category.name, titleItem)
        }
    }

    companion object {
        var context: Context? = null
        var listener: Listener? = null
        fun create(parent: ViewGroup, listener: Listener): CategoriesViewHolder {
            val holder =
                CategoriesViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycle_item, parent, false)
                )
            context = parent.context
            this.listener = listener
            return holder
        }
    }
}