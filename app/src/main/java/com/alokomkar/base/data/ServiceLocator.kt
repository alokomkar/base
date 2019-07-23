package com.alokomkar.base.data

import com.alokomkar.base.data.local.LocalDataSource
import com.alokomkar.base.data.remote.RemoteDataSource

//To be replaced with Dagger later
class ServiceLocator private constructor(){

    val remoteDataSource : RemoteDataSource by lazy { RemoteDataSource() }
    val localDataSource : LocalDataSource by lazy { LocalDataSource() }

    companion object {
        val instance : ServiceLocator by lazy { ServiceLocator() }
    }
}