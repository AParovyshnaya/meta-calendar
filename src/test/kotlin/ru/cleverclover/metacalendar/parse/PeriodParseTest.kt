package ru.cleverclover.metacalendar.parse

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ru.cleverclover.metacalendar.DayOfMonth
import ru.cleverclover.metacalendar.MetaCalendarParseException
import ru.cleverclover.metacalendar.ParsedPeriod
import java.time.Month

class PeriodParseTest {

    @Test
    fun parsed() {
        val origin = "с 1 января по 8 января"
        val period = ParsedPeriod(origin).period()
        assert(period.start == DayOfMonth(Month.JANUARY, 1)) {
            "Period originated in [$origin] must not start with ${period.start}"
        }
        assert(period.end == DayOfMonth(Month.JANUARY, 8)) {
            "Period originated in [$origin] must not end with ${period.end}"
        }
    }

    @Test
    fun incorrectFormatFails() {
        val origin = "от 1 января до 8 января"
        assertThrows<MetaCalendarParseException> {
            ParsedPeriod(origin).period()
        }
    }

    @Test
    fun incorrectDayMarkFails() {
        val origin = "с 32 января по 8 февраля"
        assertThrows<MetaCalendarParseException> {
            ParsedPeriod(origin).period()
        }
    }
}
