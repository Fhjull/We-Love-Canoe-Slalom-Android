package ru.dillab.welovecanoeslalomandroid.ui.results

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.dillab.welovecanoeslalomandroid.databinding.FragmentResultsBinding
import ru.dillab.welovecanoeslalomandroid.ui.tests.TestViewModel


class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TestViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        Log.d("Test", "ResultsFragment created/re-created")
        return binding.root
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Test", "ResultsFragment detached")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}