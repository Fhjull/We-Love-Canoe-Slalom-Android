package ru.dillab.welovecanoeslalomandroid.ui.tests.morningTest


enum class NightSleepHours {
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN
}

enum class NightSleepQuality {
    GOOD, BAD, NONE
}

data class MorningPulseSitting(
    var value: Int? = null
)

data class MorningPulseStanding(
    var value: Int? = null
)

enum class MusclePain {
    NONE, WEAK, MODERATE,STRONG, INSANE
}

/*
data class MorningTest(
    // val nightSleepHours: NightSleepHours? = null,
    // val nightSleepQuality: NightSleepQuality? = null,
    val morningPulseSitting: Int? = null,
    val morningPulseStanding: Int? = null,
    val musclePain: MusclePain? = null,
    val moodHappiness: Int? = null,
    val moodVivacity: Int? = null,
    val moodAmbition: Int? = null,
    val moodCheerfulness: Int? = null,
    val moodTrepidation: Int? = null,
    val moodAnger: Int? = null,
    val moodSadness: Int? = null
) {
}
 */






