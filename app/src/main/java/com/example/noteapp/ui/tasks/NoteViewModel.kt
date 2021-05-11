package com.example.noteapp.ui.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.Note
import com.example.noteapp.data.NoteDao
import kotlinx.coroutines.launch

class NoteViewModel @ViewModelInject constructor(
    private val noteDao: NoteDao
    ) : ViewModel() {

    // Get access to the dao
    var noteList = noteDao.getNoteList().asLiveData()

    // Insert note to the dao
    fun insertNote(note: String)
    {
        viewModelScope.launch {
            noteDao.insert(Note(note))
        }
    }
}