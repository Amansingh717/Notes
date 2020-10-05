package com.example.notes.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.notes.room.entities.Note

class NotesDiffUtilCallback(private val newList: List<Note>, private val oldList: List<Note>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.noteId == newItem.noteId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.noteTitle == newItem.noteTitle && oldItem.noteDesc == newItem.noteDesc
    }
}