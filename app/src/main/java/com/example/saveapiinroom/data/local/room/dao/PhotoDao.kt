package com.example.saveapiinroom.data.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.saveapiinroom.data.model.Photo

@Dao
interface PhotoDao {

    @Query("SELECT * FROM photo")
    fun getAllPhoto(): LiveData<List<Photo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhotos(photo: List<Photo>)
}