package com.alokomkar.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alokomkar.base.common.BaseViewModel
import com.alokomkar.base.data.model.Task

class TaskViewModel : BaseViewModel() {

    val allTasksLiveData : LiveData<List<Task>> = MutableLiveData()
    val currentTaskLiveData : LiveData<Task> = MutableLiveData()


    fun setCurrentTask( currentTask: Task ) {
        currentTaskLiveData as MutableLiveData
        currentTaskLiveData.value = currentTask
    }





}