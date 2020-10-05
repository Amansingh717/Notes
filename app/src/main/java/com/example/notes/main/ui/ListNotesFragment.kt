package com.example.notes.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notes.MainActivity
import com.example.notes.R
import com.example.notes.databinding.FragmentListNotesBinding
import com.example.notes.di.component.recycler.DaggerListNotesRecyclerComponent
import com.example.notes.extensions.navigateTo
import com.example.notes.main.adapter.NotesRecyclerAdapter
import com.example.notes.main.vm.NotesViewModel
import com.example.notes.room.entities.Note
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ListNotesFragment : DaggerFragment() {

    @Inject
    lateinit var notesRecyclerAdapter: NotesRecyclerAdapter

    private lateinit var mBinding: FragmentListNotesBinding
    private lateinit var mViewModel: NotesViewModel

    @Inject
    lateinit var mViewModelProvidersFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!::mBinding.isInitialized) mBinding =
            FragmentListNotesBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerListNotesRecyclerComponent.create().inject(this)

        mViewModel = ViewModelProvider(
            requireActivity() as MainActivity,
            mViewModelProvidersFactory
        ).get(NotesViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        initViews()
        mViewModel.getAllNotes()
        observerChanges()

    }

    private fun observerChanges() {
        mViewModel.notesListLiveData().observe(viewLifecycleOwner, { notesList ->
            if (notesList != null) {
                notesRecyclerAdapter.updateList(notesList)
            }
        })
    }

    private fun initViews() {
        mBinding.fabAddNote.setOnClickListener {
            navigateTo(R.id.action_listNotesFragment_to_addNotesFragment)
        }
    }

    private fun setupRecyclerView() {
        with(mBinding) {
            recyclerViewNotes.adapter = notesRecyclerAdapter
            notesRecyclerAdapter.setItemClickListener { view, item ->
                onRecyclerItemClicked(
                    view,
                    item
                )
            }
        }
    }

    private fun onRecyclerItemClicked(view: View?, item: Note?) {
        when (view?.id) {
            R.id.cv_notes_item_view -> {
                mViewModel.selectedNote = item
                navigateTo(R.id.action_listNotesFragment_to_viewNoteFragment)
            }
        }
    }
}