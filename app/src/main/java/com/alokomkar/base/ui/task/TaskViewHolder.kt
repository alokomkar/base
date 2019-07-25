package com.alokomkar.base.ui.task

import android.view.ViewGroup
import com.alokomkar.base.R
import com.alokomkar.base.common.BaseViewHolder
import com.alokomkar.base.data.model.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskViewHolder( viewGroup: ViewGroup ) : BaseViewHolder<Task>( viewGroup, R.layout.item_task ) {

    override fun bindData(item: Task) {
        itemView.tvTitle.text = item.title
        itemView.tvDescription.text = item.description
    }

}