package com.alokomkar.base.data.local

import androidx.room.*

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert( vararg item : T )

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update( vararg item : T )

    @Delete
    fun delete( vararg item : T )

}