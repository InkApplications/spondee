package inkapplications.spondee.measures

import kotlin.jvm.JvmInline

/**
 * Unit of energy per unit time
 */
interface Power {
    /**
     * Express the power in watts.
     */
    val inWatts: Double

    operator fun compareTo(other: Power): Int
    operator fun plus(other: Power): Power
    operator fun minus(other: Power): Power
    operator fun div(other: Number): Power
    operator fun times(other: Number): Power
    operator fun unaryPlus(): Power = this
    operator fun unaryMinus(): Power
}

/**
 * SI Unit of Power.
 */
@JvmInline
internal value class Watts(override val inWatts: Double): Power {
    override fun compareTo(other: Power) = inWatts.compareTo(other.inWatts)
    override fun plus(other: Power): Power = Watts(inWatts + other.inWatts)
    override fun minus(other: Power): Power = Watts(inWatts - other.inWatts)
    override fun div(other: Number): Power = Watts(inWatts / other.toDouble())
    override fun times(other: Number): Power = Watts(inWatts * other.toDouble())
    override fun unaryMinus(): Power = Watts(-inWatts)

    override fun toString(): String = "${inWatts}W"
}

/**
 * Express a number as unit of power in Watts.
 */
val Number.watts: Power get() = Watts(toDouble())
