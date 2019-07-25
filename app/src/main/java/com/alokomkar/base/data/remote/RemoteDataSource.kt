package com.alokomkar.base.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alokomkar.base.data.DataSource
import com.alokomkar.base.data.model.Task

class RemoteDataSource : DataSource {

    private val mockTaskList = ArrayList<Task>().apply {
        add(Task("1", "Title 123", "Description 1", 1, 0))
        add(Task("2", "Title 234", "Description 2", 2, 0))
        add(Task("3", "Title 345", "Description 3", 3, 0))
    }

    override fun fetchAllTasks(): LiveData<List<Task>> = MutableLiveData<List<Task>>().apply {
        value = mockTaskList
    }

    override fun fetchTaskById(taskId: String): LiveData<Task>  = MutableLiveData<Task>().apply {
        value = mockTaskList.firstOrNull { it.taskId == taskId }
    }

    override fun createTask(task: Task) {
        mockTaskList.add(task)
    }

    override fun updateTask(task: Task) {
        val index = mockTaskList.indexOf(task)
        if( index != -1 ) {
            mockTaskList[index] = task
        }
    }

    override fun deleteTask(task: Task) {
        mockTaskList.remove(task)
    }
}