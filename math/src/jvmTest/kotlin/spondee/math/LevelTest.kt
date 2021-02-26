package spondee.math

import kotlin.test.Test
import kotlin.test.assertEquals

class LevelTest {
    @Test
    fun conversions() {
        assertEquals(1.bels, 10.decibels)
        assertEquals(10.0, 1.bels.decibels)
        assertEquals(1.0, 10.decibels.toDouble())
    }

    @Test
    fun math() {
        assertEquals(10.0, 1.bels * 1)
        assertEquals(100.0, 2.bels * 1)
        assertEquals(10_000_000_000.0, 10.bels * 1)
        assertEquals(0.1, (-1).bels * 1)
        assertEquals(0.01, (-2).bels * 1)
        assertEquals(0.0000000001, (-10).bels * 1)
        assertEquals(1.5.bels, 1.bels + 5.decibels)
    }

    @Test
    fun string() {
        assertEquals("12.0dB", 1.2.bels.toString())
    }
}
