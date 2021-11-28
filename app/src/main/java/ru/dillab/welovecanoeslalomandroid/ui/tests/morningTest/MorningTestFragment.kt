package ru.dillab.welovecanoeslalomandroid.ui.tests.morningTest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.dillab.welovecanoeslalomandroid.databinding.FragmentMorningTestBinding


class MorningTestFragment : Fragment() {

    private var _binding: FragmentMorningTestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMorningTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.morningTestSubmitButton.setOnClickListener {
            val action = MorningTestFragmentDirections.actionMorningTestFragmentToResultsFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}