package com.example.noteapp.ui.tasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentAddEditNoteBinding

class EditNoteFragment : Fragment(R.layout.fragment_add_edit_note) {

    private lateinit var noteViewModel: NoteViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentAddEditNoteBinding.bind(view)

        val editNote = binding.editNote.toString()

        binding.saveNote.setOnClickListener {

            // Add the note to the list
            noteViewModel.insertNote(editNote)

            // Go back to the NoteFragment
            view.findNavController().navigate(R.id.noteFragment)
        }
    }
}