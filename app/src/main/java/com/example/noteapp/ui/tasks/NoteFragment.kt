package com.example.noteapp.ui.tasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.R
import com.example.noteapp.data.NoteListAdapter
import com.example.noteapp.databinding.NoteListBinding

class NoteFragment : Fragment(R.layout.note_list) {

    private val noteViewModel: NoteViewModel by viewModels()

    // Run this code when view is ready
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the noteList from the viewModel
        // noteList = noteViewModel.noteList

        // Bind noteFragment view for faster access
        val binding = NoteListBinding.bind(view)

        // Parse the noteList into the adapter
        val noteAdapter = NoteListAdapter()

        binding.apply {
            noteListView.apply {
                adapter = noteAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }
        }

        // Observe changes in database
        noteViewModel.noteList.observe(viewLifecycleOwner) {
            noteAdapter.submitList(it)
        }


        binding.fabAddTask.setOnClickListener {
            // Go to the EditNote fragment
            view.findNavController().navigate(R.id.editNoteFragment)
        }
    }
}