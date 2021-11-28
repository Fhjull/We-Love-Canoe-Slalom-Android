package ru.dillab.welovecanoeslalomandroid.ui.tests.eveningTest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.dillab.welovecanoeslalomandroid.databinding.FragmentEveningTestBinding
import ru.dillab.welovecanoeslalomandroid.databinding.FragmentMorningTestBinding
import ru.dillab.welovecanoeslalomandroid.ui.tests.morningTest.MorningTestFragmentDirections


class EveningTestFragment : Fragment() {

    private var _binding: FragmentEveningTestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEveningTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.eveningTestSubmitButton.setOnClickListener {
            val action = EveningTestFragmentDirections.actionEveningTestFragmentToResultsFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}