package com.example.notes.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.databinding.NotesItemViewBinding
import com.example.notes.room.entities.Note
import javax.inject.Inject

class NotesRecyclerAdapter @Inject constructor() :
    RecyclerView.Adapter<NotesRecyclerAdapter.NoteViewHolder>() {
    private val notesList = arrayListOf<Note>()
    private var clickListener: ((View?, Note?) -> Unit)? = null

    class NoteViewHolder(private val mBinding: NotesItemViewBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        fun bind(note: Note, clickListener: ((v: View?, item: Note?) -> Unit)?) {
            with(mBinding) {
                this.note = note
                root.setOnClickListener { view ->
                    clickListener?.invoke(view, note)
                }
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding =
            NotesItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notesList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    fun updateList(notesList: List<Note>?) {
        if (notesList != null) {
            val diff = DiffUtil.calculateDiff(NotesDiffUtilCallback(notesList, this.notesList))
            this.notesList.clear()
            this.notesList.addAll(notesList)
            diff.dispatchUpdatesTo(this)
        }
    }

    fun setItemClickListener(clickListener: ((v: View?, item: Note?) -> Unit)?) {
        this.clickListener = clickListener
    }
}