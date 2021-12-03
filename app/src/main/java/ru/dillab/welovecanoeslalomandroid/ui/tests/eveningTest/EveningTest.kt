package ru.dillab.welovecanoeslalomandroid.ui.tests.eveningTest

data class EveningTest(
    val dayEfficiency: Boolean? = null,
    val todayEvents: String? = null,
    val strength: Boolean = false,
    val stamina: Boolean = false,
    val flexibility: Boolean = false,
    val coordination: Boolean = false,
    val agility: Boolean = false,
    val strengthEndurance: Boolean = false,
    val speedEndurance: Boolean = false,
    val technic: Boolean = false,
    val breakfast: Boolean? = null,
    val dinner: Boolean? = null,
    val supper: Boolean? = null,
    val snack: Boolean? = null,
    val carbohydrates: Boolean? = null,
    val dayHydration: Boolean? = null,
    val workoutHydration: Boolean? = null,
    val tvWatchingTime: TVWatchingTime? = null,
    val workoutTime: WorkoutTime? = null,
    val studyingTime: StudyingTime? = null,
    val onlineGamesTime: OnlineGamesTime? = null,
    val walkingTime: WalkingTime? = null,
    val daySleepTime: DaySleepTime? = null,
    val stretchingTime: StretchingTime? = null,
    val jugglingTime: JugglingTime? = null,
    val slalomVideoWatchingTime: SlalomVideoWatchingTime? = null,
    val creativityTime: CreativityTime? = null
) {
    enum class TVWatchingTime {
        NONE, MINUTES_15_30, MINUTES_30_60, HOURS_1_2, HOURS_2_3, HOURS_MORE
    }

    enum class WorkoutTime {
        NONE, MINUTES_15_30, MINUTES_30_60, HOURS_1_2, HOURS_2_3, HOURS_MORE
    }

    enum class StudyingTime {
        NONE, MINUTES_15_30, MINUTES_30_60, HOURS_1_2, HOURS_2_3, HOURS_MORE
    }

    enum class OnlineGamesTime {
        NONE, MINUTES_15_30, MINUTES_30_60, HOURS_1_2, HOURS_2_3, HOURS_MORE
    }

    enum class WalkingTime {
        NONE, MINUTES_15_30, MINUTES_30_60, HOURS_1_2, HOURS_2_3, HOURS_MORE
    }

    enum class DaySleepTime {
        NONE, MINUTES_15_30, MINUTES_30_60, HOURS_1_2, HOURS_2_3, HOURS_MORE
    }

    enum class StretchingTime {
        NONE, MINUTES_15_30, MINUTES_30_60, HOURS_1_2, HOURS_2_3, HOURS_MORE
    }

    enum class JugglingTime {
        NONE, MINUTES_15_30, MINUTES_30_60, HOURS_1_2, HOURS_2_3, HOURS_MORE
    }

    enum class SlalomVideoWatchingTime {
        NONE, MINUTES_15_30, MINUTES_30_60, HOURS_1_2, HOURS_2_3, HOURS_MORE
    }

    enum class CreativityTime {
        NONE, MINUTES_15_30, MINUTES_30_60, HOURS_1_2, HOURS_2_3, HOURS_MORE
    }
}