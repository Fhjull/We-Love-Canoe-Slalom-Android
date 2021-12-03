package ru.dillab.welovecanoeslalomandroid.ui.tests.morningTest

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import ru.dillab.welovecanoeslalomandroid.R
import ru.dillab.welovecanoeslalomandroid.databinding.FragmentMorningTestBinding
import ru.dillab.welovecanoeslalomandroid.ui.tests.TestViewModel

const val MAX_PULSE = 220
const val MIN_PULSE = 55

class MorningTestFragment : Fragment() {

    private var _binding: FragmentMorningTestBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TestViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMorningTestBinding.inflate(inflater, container, false)
        Log.d("Test", "MorningTestFragment created/re-created")
        return binding.root
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Test", "MorningTestFragment detached")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.morningTestNightSleepRadioGroup.setOnCheckedChangeListener { _, id ->
            // when (id) {
            //     R.id.morning_test_night_sleep_0 -> nightSleepHours = NightSleepHours.ZERO
            //     R.id.morning_test_night_sleep_1 -> nightSleepHours = NightSleepHours.ONE
            //     R.id.morning_test_night_sleep_2 -> nightSleepHours = NightSleepHours.TWO
            //     R.id.morning_test_night_sleep_3 -> nightSleepHours = NightSleepHours.THREE
            //     R.id.morning_test_night_sleep_4 -> nightSleepHours = NightSleepHours.FOUR
            //     R.id.morning_test_night_sleep_5 -> nightSleepHours = NightSleepHours.FIVE
            //     R.id.morning_test_night_sleep_6 -> nightSleepHours = NightSleepHours.SIX
            //     R.id.morning_test_night_sleep_7 -> nightSleepHours = NightSleepHours.SEVEN
            //     R.id.morning_test_night_sleep_8 -> nightSleepHours = NightSleepHours.EIGHT
            //     R.id.morning_test_night_sleep_9 -> nightSleepHours = NightSleepHours.NINE
            //     R.id.morning_test_night_sleep_10 -> nightSleepHours = NightSleepHours.TEN
            // }
        }

        binding.morningTestNightQualityRadioGroup.setOnCheckedChangeListener { _, id ->
            // when (id) {
            //     R.id.morning_test_night_quality_good -> nightSleepQuality = NightSleepQuality.GOOD
            //     R.id.morning_test_night_quality_bad -> nightSleepQuality = NightSleepQuality.BAD
            //     R.id.morning_test_night_quality_none -> nightSleepQuality = NightSleepQuality.NONE
            // }
        }

        binding.morningTestPulseSittingEditText.doOnTextChanged { text, _, _, _ ->
            if (text != null && text.isNotEmpty()) {
                if (text.toString().toInt() > MAX_PULSE) {
                    binding.morningTestPulseSittingEditTextLayout.isErrorEnabled = true
                    binding.morningTestPulseSittingEditTextLayout.error =
                        getString(R.string.edit_text_max_error_message)
                } else {
                    binding.morningTestPulseSittingEditTextLayout.isErrorEnabled = false
                    binding.morningTestPulseSittingEditTextLayout.error = null
                }
            }
        }
        // implement onFocusChange -> check for minimum pulse and hide keyboard


        binding.morningTestPulseStandingEditText.doOnTextChanged { text, _, _, _ ->
            //     morningPulseStanding.value = text.toString().toInt()
        }

        binding.morningTestSubmitButton.setOnClickListener { showDialog() }
    }

    private fun navigateToResultsFragment() {
        val action = MorningTestFragmentDirections.actionMorningTestFragmentToResultsFragment()
        findNavController().navigate(action)
    }

    private fun showDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Результаты")
            .setMessage(
                "${viewModel.nightSleepHours}\n" +
                        "${viewModel.nightSleepQuality}\n" +
                        "${viewModel.morningPulseSitting}\n" +
                        "${viewModel.morningPulseStanding}"
            )
            .setNeutralButton("Выход") { _, _ ->
                navigateToResultsFragment()
            }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}