package com.example.saveapiinroom.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "photo")
data class Photo(
    @SerializedName("albumId")
    val albumId: Int,
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String?
)