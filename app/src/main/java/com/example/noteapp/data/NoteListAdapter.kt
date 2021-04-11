package com.example.noteapp.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R

class NoteListAdapter(private var noteList: ArrayList<String> = arrayListOf()) : RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val note: TextView = view.findViewById(R.id.note_text)
    }

    /**
     * Create new views (invoked by the layout manager)
     * Reference the the view of the viewlist
     * Create a new view, which defines the UI of the list item
    */
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) : ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.note_item, viewGroup, false)

        return ViewHolder(view)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     * Get element from your dataset at this position and replace the,
     * contents of the view with that element
     * */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.note.text = noteList[position]
    }

    // Return the size of your dataSet (invoked by the layout manager)
    override fun getItemCount() = noteList.size
}