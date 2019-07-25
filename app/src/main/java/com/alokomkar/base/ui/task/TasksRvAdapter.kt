package com.alokomkar.base.ui.task

import android.view.ViewGroup
import com.alokomkar.base.common.BaseRecyclerViewAdapter
import com.alokomkar.base.data.model.Task

class TasksRvAdapter : BaseRecyclerViewAdapter<Task, TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder
            = TaskViewHolder(parent)

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bindData(itemsList[position])
    }
}