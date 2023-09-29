package br.com.rafael.navigationcomponent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.rafael.navigationcomponent.databinding.FragmentAddressBinding
import br.com.rafael.navigationcomponent.databinding.FragmentPersonalDataBinding
import br.com.rafael.navigationcomponent.extensions.text
import br.com.rafael.navigationcomponent.model.PersonModel

class AndressFragment : Fragment() {

    private var _binding: FragmentAddressBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentAddressBinding.inflate(inflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            val model = PersonModel(
                street = binding.tilStreet.text,
                number = binding.tilNumber.text.toInt()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}