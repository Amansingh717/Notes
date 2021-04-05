package com.example.notes.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.notes.databinding.FragmentAddNotesBinding
import com.example.notes.main.vm.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNotesFragment : Fragment() {

    private lateinit var mBinding: FragmentAddNotesBinding
    private val mViewModel: NotesViewModel by activityViewModels()

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