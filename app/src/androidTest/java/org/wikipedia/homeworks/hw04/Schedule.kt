package org.wikipedia.homeworks.hw04

import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class ScheduleEntity(val lesson: String, val startTime: LocalTime, val endTime: LocalTime)

enum class Days {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

class Schedule {
    private val scheduleOfWeek = mutableMapOf<Days, MutableList<ScheduleEntity>>()
    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")
    private var tempDay: Days? = null

    private fun addSchedule(day: Days, scheduleEntity: ScheduleEntity) {
        scheduleOfWeek.getOrPut(day) { mutableListOf() }.add(scheduleEntity)
    }

    override fun toString(): String {
        return scheduleOfWeek.toSortedMap().map { (day, list) ->
            list.sortedBy { it.startTime }.joinToString("\n") {
                "%-15s${it.startTime.format(timeFormatter)} - ${
                    it.endTime.format(
                        timeFormatter
                    )
                }".format("\t${it.lesson}:")
            }.let {
                "${day.name.lowercase().replaceFirstChar { day.name[0].uppercase() }}:\n$it"
            }
        }.joinToString("\n\n")
    }

    operator fun invoke(fn: Schedule.() -> Unit) {
        fn()
    }

    operator fun String.rangeTo(endTime: String): Pair<String, String> {
        return this to endTime
    }

    infix fun Pair<String, String>.schedule(lesson: String) {
        val from = LocalTime.parse(this.first)
        val to = LocalTime.parse(this.second)
        return addSchedule(tempDay!!, ScheduleEntity(lesson, from, to))
    }

    infix fun monday(fn: Schedule.() -> Unit) {
        this.tempDay = Days.MONDAY
        fn()
    }

    infix fun tuesday(fn: Schedule.() -> Unit) {
        this.tempDay = Days.TUESDAY
        fn()
    }

    infix fun wednesday(fn: Schedule.() -> Unit) {
        this.tempDay = Days.WEDNESDAY
        fn()
    }

    infix fun thursday(fn: Schedule.() -> Unit) {
        this.tempDay = Days.THURSDAY
        fn()
    }

    infix fun friday(fn: Schedule.() -> Unit) {
        this.tempDay = Days.FRIDAY
        fn()
    }

    infix fun saturday(fn: Schedule.() -> Unit) {
        this.tempDay = Days.SATURDAY
        fn()
    }

    infix fun sunday(fn: Schedule.() -> Unit) {
        this.tempDay = Days.SUNDAY
        fn()
    }
}

fun main() {
    val schedule = Schedule()
    schedule {

        monday {
            "10:30".."11:10" schedule "Biology"
            "11:15".."11:55" schedule "Chemistry"
            "09:00".."09:40" schedule "Mathematics"
            "09:45".."10:25" schedule "History"
        }

        tuesday {
            "09:00".."09:40" schedule "English"
            "09:45".."10:25" schedule "Geography"
            "11:15".."11:55" schedule "Art"
            "10:30".."11:10" schedule "Physics"
        }

        wednesday {
            "11:15".."11:55" schedule "Biology"
            "09:00".."09:40" schedule "Literature"
            "10:30".."11:10" schedule "History"
            "09:45".."10:25" schedule "Mathematics"
        }

        thursday {
            "11:15".."11:55" schedule "Physics"
            "10:30".."11:10" schedule "Geography"
            "09:00".."09:40" schedule "Chemistry"
            "09:45".."10:25" schedule "English"
        }

        friday {
            "09:45".."10:25" schedule "Literature"
            "11:15".."11:55" schedule "History"
            "09:00".."09:40" schedule "Art"
            "10:30".."11:10" schedule "Mathematics"
        }
    }

    println(schedule.toString())
}
