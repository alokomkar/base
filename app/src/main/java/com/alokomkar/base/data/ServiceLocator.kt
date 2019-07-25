package com.alokomkar.base.data

import com.alokomkar.base.AppExecutors
import com.alokomkar.base.TaskApplication
import com.alokomkar.base.data.local.AppDatabase
import com.alokomkar.base.data.local.LocalDataSource
import com.alokomkar.base.data.remote.RemoteDataSource

//To be replaced with Dagger later
class ServiceLocator private constructor( private val application : TaskApplication, private val appExecutors: AppExecutors){

    private val appDatabase : AppDatabase by lazy { AppDatabase.getInstance(application, appExecutors) }
    val remoteDataSource : RemoteDataSource by lazy { RemoteDataSource() }
    val localDataSource : LocalDataSource by lazy { LocalDataSource(appDatabase) }

    //Boolean to track if network is connected
    val isNetworkConnected = true

    companion object {
        var instance : ServiceLocator ?= null
        fun getInstance( application: TaskApplication, appExecutors: AppExecutors ) = ServiceLocator(application, appExecutors).apply {
            instance = this
        }
    }
}