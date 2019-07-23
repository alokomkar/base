package com.alokomkar.base.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(viewGroup: ViewGroup, layoutId : Int)
    : RecyclerView.ViewHolder( LayoutInflater.from(viewGroup.context).inflate(layoutId, viewGroup)) {

    var onItemClickListener: ((View) -> Unit)? = null

    init {
        itemView.setOnClickListener { onItemClickListener?.invoke(it) }
    }

    abstract fun bindData( item : T )

}