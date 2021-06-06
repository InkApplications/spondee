package inkapplications.spondee.measure

import inkapplications.spondee.structure.DoubleMeasure
import kotlin.jvm.JvmInline

/**
 * Base unit of matter
 */
interface Mass: DoubleMeasure<Mass> {
    /**
     * Express a mass as a value in grams
     */
    val inGrams: Double

    /**
     * Express a mass as a value in pounds
     */
    val inPounds: Double
}

private const val RATIO = 453.59237

@JvmInline
internal value class Grams(override val inGrams: Double): Mass {
    override val inPounds: Double get() = inGrams / RATIO
    override fun convert(value: Mass): Double = value.inGrams
    override fun create(value: Double): Mass = Grams(value)
    override fun toString(): String = "${inGrams}g"
}

/**
 * Express a mass in grams
 */
val Number.grams: Mass get() = Grams(toDouble())
val gram = 1.grams

@JvmInline
internal value class Pounds(override val inPounds: Double): Mass {
    override val inGrams: Double get() = inPounds * RATIO
    override fun convert(value: Mass): Double = value.inPounds
    override fun create(value: Double): Mass = Pounds(value)
    override fun toString(): String = "${inPounds}lbs"
}

/**
 * Express a mass in pounds
 */
val Number.pounds: Mass get() = Pounds(toDouble())
val pound = 1.pounds
