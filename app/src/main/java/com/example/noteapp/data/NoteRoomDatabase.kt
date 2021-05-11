package com.example.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.noteapp.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

// Annotates class to be a Room Database with a table (entity) of the Note class
@Database(entities = [Note::class], version = 1)
abstract class NoteRoomDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    class Callback @Inject constructor(
        private val database: Provider<NoteRoomDatabase>,
        @ApplicationScope private val applicationScope: CouroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().noteDao()

            applicationScope.launch {
                dao.insert(Note("Groceries"))
                dao.insert(Note("Sport"))
                dao.insert(Note("Meeting"))
                dao.insert(Note("Games"))
            }
        }
    }
}

