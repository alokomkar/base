package com.alokomkar.base.ui.task

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alokomkar.base.common.BaseRecyclerViewAdapter
import com.alokomkar.base.data.model.Task

class TasksRvAdapter : BaseRecyclerViewAdapter<Task, TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder
            = TaskViewHolder(parent)

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.apply {
            itemClickListener = {
                val itemPosition = adapterPosition
                if( itemPosition != RecyclerView.NO_POSITION )
                    this@TasksRvAdapter.onItemClickListener?.invoke(it, itemPosition, itemsList[itemPosition])
            }
            bindData(itemsList[position])
        }
    }
}