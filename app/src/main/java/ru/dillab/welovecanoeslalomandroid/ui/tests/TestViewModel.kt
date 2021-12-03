package ru.dillab.welovecanoeslalomandroid.ui.tests

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.dillab.welovecanoeslalomandroid.ui.tests.morningTest.NightSleepHours
import ru.dillab.welovecanoeslalomandroid.ui.tests.morningTest.NightSleepQuality

abstract class TestViewModel : ViewModel() {

    private var _nightSleepHours: NightSleepHours? = NightSleepHours.ZERO
    val nightSleepHours: NightSleepHours?
        get() = _nightSleepHours

    private var _nightSleepQuality: NightSleepQuality? = NightSleepQuality.GOOD
    val nightSleepQuality: NightSleepQuality?
        get() = _nightSleepQuality

    private val _morningPulseSitting: Int? = 0
    val morningPulseSitting: Int?
        get() = _morningPulseSitting

    private val _morningPulseStanding: Int? = 0
    val morningPulseStanding: Int?
        get() = _morningPulseStanding

    init {
        Log.d("Test", "TestViewModel initialized")
        // _nightSleepHours = null
        // _nightSleepQuality = null
        // _morningPulseSitting = null
        // _morningPulseStanding = null
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("Test", "TestViewModel destroyed")
    }
}