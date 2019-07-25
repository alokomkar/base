package com.alokomkar.base.data.local

import androidx.lifecycle.LiveData
import com.alokomkar.base.data.DataSource
import com.alokomkar.base.data.model.Task

class LocalDataSource( private val appDatabase: AppDatabase ) : DataSource {

    override fun fetchAllTasks(): LiveData<List<Task>>
            = appDatabase.taskDao().fetchAll()

    override fun fetchTaskById(taskId: String): LiveData<Task>
            = appDatabase.taskDao().fetchTaskById(taskId)


    override fun createTask(task: Task)
            = appDatabase.taskDao().insert(task)

    override fun updateTask(task: Task)
            = appDatabase.taskDao().update(task)

    override fun deleteTask(task: Task)
            = appDatabase.taskDao().delete(task)

    fun insertAllTasks(item: List<Task>) {
        appDatabase.runInTransaction {
            item.forEach { task ->  appDatabase.taskDao().insert(task) }
        }
    }

}