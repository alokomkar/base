package com.alokomkar.base.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alokomkar.base.data.DataSource
import com.alokomkar.base.data.model.Task

class RemoteDataSource : DataSource {

    override fun fetchAllTasks(): LiveData<List<Task>> = MutableLiveData<List<Task>>().apply {
        value = ArrayList<Task>().apply {
            add(Task("1", "Title", "Description", 1, 0))
            add(Task("2", "Title", "Description", 1, 0))
            add(Task("3", "Title", "Description", 1, 0))
        }
    }

    override fun fetchTaskById(taskId: String): LiveData<Task>  = MutableLiveData<Task>().apply {
        value = null
    }

    override fun createTask(task: Task) {

    }

    override fun updateTask(task: Task) {

    }

    override fun deleteTask(task: Task) {

    }
}