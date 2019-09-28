package ru.cleverclover.metacalendar.parse

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ru.cleverclover.metacalendar.MetaCalendarParseException
import ru.cleverclover.metacalendar.ParsedDayMark
import ru.cleverclover.metacalendar.WeekdayInMonth
import java.time.DayOfWeek
import java.time.Month

class WeekdayInMonthMarlParseTest {
    @Test
    fun parsed() =
            assert(ParsedDayMark("третий вторник ноября").mark() ==
                    WeekdayInMonth(Month.NOVEMBER, 3, DayOfWeek.TUESDAY))

    @Test
    fun failsOnDaNo() {
        assertThrows<MetaCalendarParseException> { ParsedDayMark("пятый вторник ноября").mark() }
    }

    @Test
    fun failsOnDayName() {
        assertThrows<MetaCalendarParseException> { ParsedDayMark("второй ворник ноября").mark() }
    }

    @Test
    fun failsOnMonth() {
        assertThrows<MetaCalendarParseException> { ParsedDayMark("второй вторник нбр").mark() }
    }
}