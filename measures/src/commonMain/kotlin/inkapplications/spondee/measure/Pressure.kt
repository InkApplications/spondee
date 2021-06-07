package inkapplications.spondee.measure

import inkapplications.spondee.structure.DoubleMeasure
import inkapplications.spondee.structure.SiValue
import kotlin.jvm.JvmInline

private const val PASCALS_PER_PSI = 6_894.757
private const val PASCALS_PER_BAR = 1e5

/**
 * Unit of force applied over an area.
 */
interface Pressure: DoubleMeasure<Pressure> {
    /**
     * Express a pressure as a value in pascals
     */
    val inPascals: SiValue

    /**
     * Express a pressure as a value in bar
     */
    val inBar: SiValue

    /**
     * Express a pressure as a value in pounds per square inch
     */
    val inPsi: Double
}

@JvmInline
internal value class Pascals(override val inPascals: SiValue): Pressure {
    override val inBar: SiValue get() = SiValue(inPascals.baseValue / PASCALS_PER_BAR)
    override val inPsi: Double get() = inPascals.baseValue / PASCALS_PER_PSI

    override fun convert(value: Pressure): Double = value.inPascals.baseValue
    override fun create(value: Double): Pressure = value.pascals
    override fun toString(): String = "${inPascals}Pa"
}

/**
 * express a number as pressure in pascals
 */
val Number.pascals: Pressure get() = Pascals(SiValue(toDouble()))

@JvmInline
internal value class Bar(override val inBar: SiValue): Pressure {
    override val inPascals: SiValue get() = SiValue(inBar.baseValue * PASCALS_PER_BAR)
    override val inPsi: Double get() = inPascals.baseValue / PASCALS_PER_PSI

    override fun convert(value: Pressure): Double = value.inBar.baseValue
    override fun create(value: Double): Pressure = value.bar
    override fun toString(): String = "${inBar}bar"
}

/**
 * express a number as pressure in bar
 */
val Number.bar: Pressure get() = Bar(SiValue(toDouble()))

@JvmInline
internal value class Psi(override val inPsi: Double): Pressure {
    override val inPascals: SiValue get() = SiValue(inPsi * PASCALS_PER_PSI)
    override val inBar: SiValue get() =  SiValue(inPsi * PASCALS_PER_PSI / PASCALS_PER_BAR)

    override fun convert(value: Pressure): Double = value.inPsi
    override fun create(value: Double): Pressure = Psi(value)
    override fun toString(): String = "${inPsi}psi"
}

/**
 * express a number as pressure in pounds per square inch
 */
val Number.psi: Pressure get() = Psi(toDouble())
