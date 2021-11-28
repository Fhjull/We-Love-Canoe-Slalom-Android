package ru.dillab.welovecanoeslalomandroid.ui.tests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.dillab.welovecanoeslalomandroid.databinding.FragmentTestsMenuBinding


class TestsMenuFragment : Fragment() {

    private var _binding: FragmentTestsMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTestsMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.testsMenuMorningTestCard.setOnClickListener {
            val action = TestsMenuFragmentDirections.actionTestsMenuFragmentToMorningTestFragment()
            findNavController().navigate(action)
        }

        binding.testsMenuEveningTestCard.setOnClickListener {
            val action = TestsMenuFragmentDirections.actionTestsMenuFragmentToEveningTestFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
