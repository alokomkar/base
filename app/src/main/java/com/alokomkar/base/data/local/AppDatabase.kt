package com.alokomkar.base.data.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alokomkar.base.R
import com.alokomkar.base.data.model.Task

@Database( entities = [Task::class], version = 1 )
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao() : TaskDao

    companion object {

        private var dbInstance : AppDatabase?= null

        fun getDbInstance( application: Application) : AppDatabase {
            if (dbInstance == null) {
                synchronized(AppDatabase::class.java) {
                    if (dbInstance == null) {
                        dbInstance = Room.databaseBuilder(application,
                            AppDatabase::class.java, application.getString(R.string.local_database_name))
                            .addCallback(object  : RoomDatabase.Callback() {
                                //val dbInstance = getDbInstance(application)
                            })
                            .build()

                    }
                }
            }
            return dbInstance!!
        }
    }
}