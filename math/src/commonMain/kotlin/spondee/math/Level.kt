package spondee.math

import kotlin.math.pow

/**
 * Unit of a ratio. Most commonly decibels.
 */
data class Level(val bels: Double): Number() {
    val decibels get() = bels * 10

    override fun toByte(): Byte = bels.toInt().toByte()
    override fun toChar(): Char = bels.toChar()
    override fun toDouble(): Double = bels
    override fun toFloat(): Float = bels.toFloat()
    override fun toInt(): Int = bels.toInt()
    override fun toLong(): Long = bels.toLong()
    override fun toShort(): Short = bels.toInt().toShort()

    operator fun times(other: Number): Double = 10.0.pow(bels).times(other.toDouble())
    operator fun plus(other: Level): Level = Level(bels + other.bels)
    override fun toString(): String = "${decibels}dB"
}

/**
 * Express a level in bels.
 */
val Number.bels get() = Level(toDouble())

/**
 * Express a level in decibels.
 */
val Number.decibels get() = (toDouble() / 10).bels
