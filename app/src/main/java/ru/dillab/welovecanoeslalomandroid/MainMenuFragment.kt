package ru.dillab.welovecanoeslalomandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.dillab.welovecanoeslalomandroid.databinding.FragmentMainMenuBinding
import ru.dillab.welovecanoeslalomandroid.databinding.FragmentMorningTestBinding


class MainMenuFragment : Fragment() {

    private var _binding: FragmentMainMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainMenuTestsCard.setOnClickListener {
            val action = MainMenuFragmentDirections.actionMainMenuFragmentToTestsMenuFragment()
            findNavController().navigate(action)
        }

        binding.mainMenuResultsCard.setOnClickListener {
            val action = MainMenuFragmentDirections.actionMainMenuFragmentToResultsFragment()
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}