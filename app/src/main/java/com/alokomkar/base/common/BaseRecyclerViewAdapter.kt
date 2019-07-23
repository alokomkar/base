package com.alokomkar.base.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T, VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>() {
    var onItemClickListener : ((view : View, position : Int, item : T) -> Unit)? = null
}