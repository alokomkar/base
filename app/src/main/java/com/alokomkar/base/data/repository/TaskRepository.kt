package com.alokomkar.base.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alokomkar.base.AppExecutors
import com.alokomkar.base.data.Resource
import com.alokomkar.base.data.ServiceLocator
import com.alokomkar.base.data.model.Task
import com.alokomkar.base.data.remote.ApiResponse
import com.alokomkar.base.data.remote.Response

class TaskRepository( private val serviceLocator: ServiceLocator, private val appExecutors: AppExecutors ) {

    fun getTaskById( taskId : String ) : LiveData<Resource<Task>> {
        return object : NetworkBoundResource<Task, Task>( appExecutors ) {
            override fun saveCallResultToLocalDb(item: Task) {
                serviceLocator.localDataSource.updateTask(item)
            }

            override fun createNetworkCall(): LiveData<ApiResponse<Task>> {
                val responseLiveData : MutableLiveData<ApiResponse<Task>> = MutableLiveData()
                responseLiveData.value = null

                serviceLocator.remoteDataSource.fetchTaskById(taskId).observeForever {
                        task -> responseLiveData.value = ApiResponse.create(Response(null, task))
                }
                return responseLiveData
            }

            override fun loadFromLocalDatabase(): LiveData<Task>
                    = serviceLocator.localDataSource.fetchTaskById(taskId)


            override fun shouldFetch(data: Task?): Boolean {
                return data == null
            }

        }.asLiveData()
    }

    fun fetchAllTasksResource() : LiveData<Resource<List<Task>>> {
        return object : NetworkBoundResource<List<Task>, List<Task>>( appExecutors ) {

            override fun saveCallResultToLocalDb(item: List<Task>) {
                serviceLocator.localDataSource.insertAllTasks(item)
            }

            override fun createNetworkCall(): LiveData<ApiResponse<List<Task>>> {
                val responseLiveData : MutableLiveData<ApiResponse<List<Task>>> = MutableLiveData()
                responseLiveData.value = null

                serviceLocator.remoteDataSource.fetchAllTasks().observeForever {
                    tasksList -> responseLiveData.value = ApiResponse.create(Response(null, tasksList))
                }
                return responseLiveData
            }

            override fun loadFromLocalDatabase(): LiveData<List<Task>>
                    = serviceLocator.localDataSource.fetchAllTasks()


            override fun shouldFetch(data: List<Task>?): Boolean {
                return data == null || data.isEmpty() //|| some other criteria
            }


        }.asLiveData()
    }

}