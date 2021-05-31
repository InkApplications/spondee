package inkapplications.spondee.measures

import kotlin.jvm.JvmInline

interface Pressure: DoubleMeasure<Pressure> {
    val inPascals: Double
    val inBar: Double
    val inPsi: Double
}

@JvmInline
internal value class Pascals(override val inPascals: Double): Pressure {
    override val inBar: Double get() = inPascals / 100000.0
    override val inPsi: Double get() = inPascals / 6894.75729

    override fun convert(value: Pressure): Double = value.inPascals
    override fun create(value: Double): Pressure = Pascals(value)
    override fun toString(): String = "${inPascals}Pa"
}

val Number.pascals: Pressure get() = Pascals(toDouble())
val pascal = 1.pascals

@JvmInline
internal value class Bar(override val inBar: Double): Pressure {
    override val inPascals: Double get() = inBar * 100000.0
    override val inPsi: Double get() = inBar * 14.50377

    override fun convert(value: Pressure): Double = value.inBar
    override fun create(value: Double): Pressure = Bar(value)
    override fun toString(): String = "${inBar}bar"
}

val Number.bar: Pressure get() = Bar(toDouble())
val bar = 1.bar

@JvmInline
internal value class Psi(override val inPsi: Double): Pressure {
    override val inPascals: Double get() = inPsi * 6894.75729
    override val inBar: Double get() =  inPsi * .0689475729

    override fun convert(value: Pressure): Double = value.inPsi
    override fun create(value: Double): Pressure = Psi(value)
    override fun toString(): String = "${inPsi}psi"
}
val Number.psi: Pressure get() = Psi(toDouble())
val psi = 1.psi
