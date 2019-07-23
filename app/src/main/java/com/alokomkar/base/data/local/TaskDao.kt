package com.alokomkar.base.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.alokomkar.base.data.model.Task

@Dao
abstract class TaskDao : BaseDao<Task> {

    @Transaction @Query("SELECT * FROM Task" )
    abstract fun fetchAll() : LiveData<List<Task>>

    @Query("SELECT * FROM TASK WHERE id = :taskId")
    abstract fun fetchTaskById( taskId : Long ) : LiveData<Task>

    @Query("SELECT * FROM Task WHERE isComplete = :isComplete" )
    abstract fun fetchAllComplete( isComplete : Int = Task.TASK_COMPLETE ) : LiveData<List<Task>>

    @Query("SELECT * FROM Task WHERE isComplete = :isComplete" )
    abstract fun fetchAllPending( isComplete : Int = Task.TASK_PENDING ) : LiveData<List<Task>>

    @Query("SELECT * FROM Task ORDER BY priority DESC")
    abstract fun fetchAllByHighPriority()

    @Query("SELECT * FROM Task ORDER BY priority ASC")
    abstract fun fetchAllByLowPriority()
}