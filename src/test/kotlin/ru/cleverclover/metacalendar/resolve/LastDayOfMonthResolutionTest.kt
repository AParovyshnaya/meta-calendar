/*******************************************************************************
 * Copyright (c) 2019, 2020 CleverClover
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT which is available at
 * https://spdx.org/licenses/MIT.html#licenseText
 *
 * SPDX-License-Identifier: MIT
 *
 * Contributors:
 *     CleverClover - initial API and implementation
 *******************************************************************************
 */
package ru.cleverclover.metacalendar.resolve

import org.junit.jupiter.api.Test
import ru.cleverclover.metacalendar.meta.LastDayOfMonth
import java.time.LocalDate
import java.time.Month

class LastDayOfMonthResolutionTest : ResolutionTest() {

    @Test
    fun leapFebruary() {
        val mark = LastDayOfMonth(Month.FEBRUARY)
        val expectedDate = LocalDate.of(2020, Month.FEBRUARY, 29)
        testResolution(mark, expectedDate)
    }

    @Test
    fun shortFebruary() {
        val mark = LastDayOfMonth(Month.FEBRUARY)
        val expectedDate = LocalDate.of(2019, Month.FEBRUARY, 28)
        testResolution(mark, expectedDate)
    }

    @Test
    fun longMonth() {
        val mark = LastDayOfMonth(Month.JANUARY)
        val expectedDate = LocalDate.of(2019, Month.JANUARY, 31)
        testResolution(mark, expectedDate)
    }

    @Test
    fun shortMonth() {
        val mark = LastDayOfMonth(Month.APRIL)
        val expectedDate = LocalDate.of(2019, Month.APRIL, 30)
        testResolution(mark, expectedDate)
    }

}
