package br.com.rafael.androidmaterial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import br.com.rafael.androidmaterial.databinding.BottomSheetModalBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalBottomSheet : BottomSheetDialogFragment() {

    private val binding by lazy { BottomSheetModalBinding.inflate(LayoutInflater.from(requireContext())) }

    override fun onCreateView(
        inflater: LayoutInflater,
        group: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    companion object {
        private const val TAG = "ModalBottomSheet"

        fun start(manager: FragmentManager) {
            ModalBottomSheet().show(manager, TAG)
        }
    }
}