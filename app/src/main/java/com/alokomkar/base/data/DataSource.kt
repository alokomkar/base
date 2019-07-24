package com.alokomkar.base.data

import androidx.lifecycle.LiveData
import com.alokomkar.base.data.model.Task

interface DataSource {
    fun fetchAllTasks() : LiveData<List<Task>>
    fun fetchTaskById( taskId : String ) : LiveData<Task>
    fun createTask( task : Task )
    fun updateTask( task : Task )
    fun deleteTask( task: Task )
}