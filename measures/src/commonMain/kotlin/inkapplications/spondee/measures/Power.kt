package inkapplications.spondee.measures

import kotlin.jvm.JvmInline

/**
 * Unit of energy per unit time
 */
interface Power: DoubleMeasure<Power> {
    /**
     * Express the power in watts.
     */
    val inWatts: Double
}

/**
 * SI Unit of Power.
 */
@JvmInline
value class Watts(override val inWatts: Double): Power {
    override fun convert(value: Power): Double = value.inWatts
    override fun create(value: Double): Power = Watts(value)

    override fun toString(): String = "${inWatts}W"
}

/**
 * Express a number as unit of power in Watts.
 */
val Number.watts: Power get() = Watts(toDouble())
