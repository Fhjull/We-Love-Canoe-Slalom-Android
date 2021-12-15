package ru.dillab.welovecanoeslalomandroid.ui.tests.morningTest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.dillab.welovecanoeslalomandroid.R

class MorningTestViewModel : ViewModel() {

    // Test whether LiveData can be avoided
    private val _nightSleepHours = MutableLiveData<Int?>()
    val nightSleepHours: LiveData<Int?> = _nightSleepHours

    private val _nightSleepQuality = MutableLiveData<String?>()
    val nightSleepQuality: LiveData<String?> = _nightSleepQuality

    private val _morningPulseSitting = MutableLiveData<Int?>()
    // Maybe implement liveData transformation from String to Int in the future
    val morningPulseSitting: LiveData<Int?> = _morningPulseSitting

    private val _morningPulseStanding = MutableLiveData<Int?>()
    // Maybe implement liveData transformation from String to Int in the future
    val morningPulseStanding: LiveData<Int?> = _morningPulseStanding

    init {
        Log.d("Test", "MorningTestViewModel initialized")
        // _nightSleepHours.value = 5
        // _nightSleepQuality.value = "Отлично спала \uD83D\uDC4D"
        // _morningPulseSitting.value = null
        // _morningPulseStanding.value = null
    }

    fun setNightSleepHours(hours: Int) {
        _nightSleepHours.value = hours
    }

    fun setNightSleepQuality(quality: String) {
        _nightSleepQuality.value = quality
    }

    fun setMorningPulseSitting(value: Int?) {
        _morningPulseSitting.value = value
    }

    fun setMorningPulseStanding(value: Int?) {
        _morningPulseStanding.value = value
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("Test", "MorningTestViewModel destroyed")
    }
}