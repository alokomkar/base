package com.alokomkar.base

import android.app.Application
import com.alokomkar.base.data.ServiceLocator
import com.alokomkar.base.data.repository.TaskRepository

class TaskApplication : Application() {

    private val appExecutors : AppExecutors by lazy { AppExecutors() }
    private val serviceLocator : ServiceLocator by lazy { ServiceLocator.getInstance(this, appExecutors) }

    fun getTaskRepository() = TaskRepository( serviceLocator, appExecutors )

}