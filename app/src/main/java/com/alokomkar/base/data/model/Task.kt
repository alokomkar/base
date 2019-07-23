package com.alokomkar.base.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
data class Task(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var taskId : String = "",
    @NonNull
    @ColumnInfo(name = "title")
    var title : String = "",
    @NonNull
    @ColumnInfo(name = "description")
    var description : String = "",
    @NonNull
    @ColumnInfo(name = "priority")
    var priority : Int = 1,
    @NonNull
    @ColumnInfo(name = "isComplete")
    var isComplete : Int = TASK_PENDING ) {

    companion object {
        const val TASK_PENDING = 0
        const val TASK_COMPLETE = 1
    }
}