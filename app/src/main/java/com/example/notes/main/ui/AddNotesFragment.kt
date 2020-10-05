package com.example.notes.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import com.example.notes.databinding.FragmentAddNotesBinding
import com.example.notes.main.vm.NotesViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class AddNotesFragment : DaggerFragment() {

    private lateinit var mBinding: FragmentAddNotesBinding
    private lateinit var mViewModel: NotesViewModel

    @Inject
    lateinit var mViewModelProvidersFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            onBackPressedCallback
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!::mBinding.isInitialized) mBinding =
            FragmentAddNotesBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProvider(
            requireActivity(),
            mViewModelProvidersFactory
        ).get(NotesViewModel::class.java)
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val title = mBinding.editTextTitleFragmentAddNote.text.toString()
            val desc = mBinding.editTextDescFragmentAddNote.text.toString()
            mViewModel.addNote(title, desc)
            isEnabled = false
            activity?.onBackPressed()
        }
    }
}