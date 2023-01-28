package com.example.saveapiinroom.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.saveapiinroom.data.local.room.dao.PhotoDao
import com.example.saveapiinroom.data.model.Photo

@Database(entities = [Photo::class], version = 1, exportSchema = false)
abstract class PhotoDatabase : RoomDatabase() {

    abstract fun photoDao(): PhotoDao
}