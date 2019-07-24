package com.alokomkar.base.data.remote

import androidx.lifecycle.LiveData
import com.alokomkar.base.data.DataSource
import com.alokomkar.base.data.model.Task

class RemoteDataSource : DataSource {

    override fun fetchAllTasks(): LiveData<List<Task>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fetchTaskById(taskId: String): LiveData<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createTask(task: Task) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateTask(task: Task) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteTask(task: Task) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}