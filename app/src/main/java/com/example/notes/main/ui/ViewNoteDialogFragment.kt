package com.example.notes.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.notes.databinding.FragmentViewNoteDialogBinding
import com.example.notes.main.vm.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewNoteDialogFragment : DialogFragment() {

    private lateinit var mBinding: FragmentViewNoteDialogBinding
    private val mViewModel: NotesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!::mBinding.isInitialized) mBinding =
            FragmentViewNoteDialogBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    override fun onResume() {
        super.onResume()
        val displayMetrics = requireActivity().resources.displayMetrics
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels
        dialog?.window?.setLayout(width, height)
    }

    private fun initView() {
        mBinding.note = mViewModel.selectedNote
        mBinding.buttonDeleteNote.setOnClickListener {
            mViewModel.deleteNote()
            dismiss()
        }
    }
}