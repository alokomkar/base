package com.alokomkar.base.data.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alokomkar.base.AppExecutors
import com.alokomkar.base.R
import com.alokomkar.base.data.model.Task

@Database( entities = [Task::class], version = 1 )
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao() : TaskDao

    companion object {

        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(application: Application, appExecutors: AppExecutors ): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(application).also { INSTANCE = it }
            }

        private fun buildDatabase(application: Application) =
            Room.databaseBuilder(application,
                AppDatabase::class.java, application.getString(R.string.local_database_name))
                .build()

    }
}