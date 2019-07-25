package com.alokomkar.base.ui.task

import android.app.Application
import com.alokomkar.base.TaskApplication
import com.alokomkar.base.common.BaseViewModel
import com.alokomkar.base.data.repository.TaskRepository

class TaskViewModel( application: Application ) : BaseViewModel(application) {

    private val repository: TaskRepository = taskApplication.getTaskRepository()

    fun getAllTasks() = repository.fetchAllTasksResource()

    fun getTaskById( taskId : String ) = repository.getTaskById( taskId )

}