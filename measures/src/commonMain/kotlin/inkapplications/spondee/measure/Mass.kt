package inkapplications.spondee.measure

import inkapplications.spondee.structure.DoubleMeasure
import inkapplications.spondee.structure.SiValue
import kotlin.jvm.JvmInline

/**
 * Base unit of matter
 */
interface Mass: DoubleMeasure<Mass> {
    /**
     * Express a mass as a value in grams
     */
    val inGrams: SiValue

    /**
     * Express a mass as a value in pounds
     */
    val inPounds: ImperialMass
}

@JvmInline
value class ImperialMass(val decimal: Double) {
    val poundsComponent: Long get() = decimal.toLong()
    val ouncesComponent: Double get() = ((decimal - poundsComponent) * 16)

    operator fun component1() = poundsComponent
    operator fun component2() = ouncesComponent
    override fun toString() = "${poundsComponent}lbs ${ouncesComponent}oz"
}

private const val GRAMS_PER_POUND = 453.59237

@JvmInline
internal value class Grams(override val inGrams: SiValue): Mass {
    override val inPounds: ImperialMass get() = ImperialMass(inGrams.baseValue / GRAMS_PER_POUND)
    override fun convert(value: Mass): Double = value.inGrams.baseValue
    override fun create(value: Double): Mass = value.grams
    override fun toString(): String = "${inGrams}g"
}

/**
 * Express a mass in grams
 */
val Number.grams: Mass get() = Grams(SiValue(toDouble()))

@JvmInline
internal value class Pounds(override val inPounds: ImperialMass): Mass {
    override val inGrams: SiValue get() = SiValue(inPounds.decimal * GRAMS_PER_POUND)
    override fun convert(value: Mass): Double = value.inPounds.decimal
    override fun create(value: Double): Mass = value.pounds
    override fun toString(): String = inPounds.toString()
}

/**
 * Express a mass in pounds
 */
val Number.pounds: Mass get() = Pounds(ImperialMass(toDouble()))
