package ru.dillab.welovecanoeslalomandroid.ui.tests.morningTest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout
import ru.dillab.welovecanoeslalomandroid.R
import ru.dillab.welovecanoeslalomandroid.databinding.FragmentMorningTestBinding


private const val MAX_PULSE = 220
private const val MIN_PULSE = 55

class MorningTestFragment : Fragment() {

    private var binding: FragmentMorningTestBinding? = null

    private val morningViewModel: MorningTestViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentMorningTestBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        Log.d("Test", "MorningTestFragment created/re-created")
        return fragmentBinding.root
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Test", "MorningTestFragment detached")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Binding with layout variables
        binding?.apply {
            // if there is no observable data in fragment layout, maybe it will be wise to
            // delete lifecycleOwner declaration
            lifecycleOwner = viewLifecycleOwner
            viewModel = morningViewModel
            morningTestFragment = this@MorningTestFragment
        }

        binding?.morningTestPulseSittingEditTextLayout?.editText?.doOnTextChanged { inputText, _, _, _ ->
            checkInputTextErrors(inputText, binding!!.morningTestPulseSittingEditTextLayout)
        }
        // binding?.morningTestPulseSittingEditText?.setOnFocusChangeListener { view, b ->
        //     if (b) {
        //         MaterialAlertDialogBuilder(requireContext()).setTitle("HasFocus").show()
        //     }
        //     if (!b) {
        //         MaterialAlertDialogBuilder(requireContext()).setTitle("Not Focus").show()
        //     }
        // }

        /*
         Implement check in edittext for minimum value when edittext view looses focus
         And also hide soft keyboard
         */

        binding?.morningTestPulseStandingEditTextLayout?.editText?.doOnTextChanged { inputText, _, _, _ ->
            checkInputTextErrors(inputText, binding!!.morningTestPulseStandingEditTextLayout)
        }

    }

    /*
    Shows alert dialog with results of test and EXIT button, that leads to results_fragment
    */
    fun onClickSubmitButton() {
        getMorningPulseSitting()
        getMorningPulseStanding()
        showDialog()
    }

    /*
    Getting value from morningPulseSittingEditText and assigning it to viewModel field
     */
    private fun getMorningPulseSitting() {
        val pulseText = binding?.morningTestPulseSittingEditTextLayout?.editText?.text.toString()
        val pulse = if (pulseText.isNotEmpty()) {
            pulseText.toInt()
        } else {
            null
        }
        morningViewModel.setMorningPulseSitting(pulse)
    }

    /*
    Getting value from morningPulseStandingEditText and assigning it to viewModel field
    */
    private fun getMorningPulseStanding() {
        val pulseText = binding?.morningTestPulseStandingEditTextLayout?.editText?.text.toString()
        val pulse = if (pulseText.isNotEmpty()) {
            pulseText.toInt()
        } else {
            null
        }
        morningViewModel.setMorningPulseStanding(pulse)
    }

    private fun navigateToResultsFragment() {
        val action = MorningTestFragmentDirections.actionMorningTestFragmentToResultsFragment()
        findNavController().navigate(action)
    }

    private fun showDialog() {
        /*
        https://medium.com/over-engineering/hands-on-with-material-components-for-android-dialogs-75c6d726f83a
        https://material.io/components/dialogs
         */
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Результаты")
            .setMessage(
                "${morningViewModel.nightSleepHours.value}\n" +
                        "${morningViewModel.nightSleepQuality.value}\n" +
                        "${morningViewModel.morningPulseSitting.value}\n" +
                        "${morningViewModel.morningPulseStanding.value}"
            )
            .setNeutralButton("Выход") { _, _ ->
                navigateToResultsFragment()
            }
            .show()
    }

    /*
    Checking EditText input for maximum value, that is set in MAX_PULSE value
    We need to check a value for non null and "", because in that case .toInt() call
    will cause exception
    */
    private fun checkInputTextErrors(
        inputText: CharSequence?,
        editTextLayout: TextInputLayout
    ) {
        if (inputText == null || inputText.isEmpty()) {
            editTextLayout.isErrorEnabled = false
            editTextLayout.error = null
            return
        } else if (!inputText.isDigitsOnly()) {
            editTextLayout.isErrorEnabled = true
            editTextLayout.error = getString(R.string.edit_text_not_digits_error_message)
        } else if (inputText.toString().toInt() > MAX_PULSE) {
            editTextLayout.isErrorEnabled = true
            editTextLayout.error = getString(R.string.edit_text_max_error_message)
        } else {
            editTextLayout.isErrorEnabled = false
            editTextLayout.error = null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}