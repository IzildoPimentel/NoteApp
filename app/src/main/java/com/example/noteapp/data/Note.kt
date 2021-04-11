package com.example.noteapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "note_table")
@Parcelize
data class Note(
    val note: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
) : Parcelable
