package ru.dillab.welovecanoeslalomandroid.ui.results

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import ru.dillab.welovecanoeslalomandroid.databinding.FragmentResultsBinding
import java.text.SimpleDateFormat
import java.util.*


class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!

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

        // Getting today data
        // val formatter = SimpleDateFormat("E d M y", Locale.getDefault())
        // val calendar = Calendar.getInstance()
        // val date = formatter.format(calendar.time)
        // binding.text.text = date
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}