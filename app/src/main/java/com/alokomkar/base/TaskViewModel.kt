package com.alokomkar.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alokomkar.base.common.BaseViewModel
import com.alokomkar.base.data.ServiceLocator
import com.alokomkar.base.data.model.Task
import com.alokomkar.base.data.repository.TaskRepository

class TaskViewModel( private val repository: TaskRepository ) : BaseViewModel() {

    val allTasksLiveData : LiveData<List<Task>> = MutableLiveData()
    val currentTaskLiveData : LiveData<Task> = MutableLiveData()


    fun setCurrentTask( currentTask: Task ) {
        currentTaskLiveData as MutableLiveData
        currentTaskLiveData.value = currentTask
    }

    fun fetchAllTasks() = repository.fetchAllTasks()





}