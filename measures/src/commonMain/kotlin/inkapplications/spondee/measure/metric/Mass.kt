package inkapplications.spondee.measure.metric

import inkapplications.spondee.measure.Mass
import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

/**
 * Metric unit of mass.
 */
@JvmInline
value class Grams(override val value: Number): Dimension<Grams>, Mass {
    override val symbol: String get() = "g"
    override fun toGrams(): Grams = this
    override fun withValue(value: Number): Grams = Grams(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a unit in grams
 */
val Number.grams get() = Grams(this)

/**
 * Convenience getter for expressing a unit in scaled kilo grams.
 */
val Number.kilograms get() = scale(Kilo).grams

/**
 * Convenience reference dimension for a single gram.
 */
val Gram = 1.grams

/**
 * Convenience reference dimension for a single kilogram.
 */
val Kilogram = 1.scale(Kilo).grams

/**
 * Alternate unit for a megagram
 */
@JvmInline
value class MetricTons(override val value: Number): Dimension<MetricTons>, Mass {
    override val symbol: String get() = "t"
    override fun toGrams(): Grams = convert { grams * 1e6 }
    override fun withValue(value: Number): MetricTons = MetricTons(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a unit in metric tons
 */
val Number.metricTons get() = MetricTons(this)

/**
 * Convert a unit of mass to metric tons
 */
fun Mass.toMetricTons() = toGrams().convert { this / 1e6 }.metricTons

/**
 * Convenience unit for a single metric ton
 */
val MetricTon = 1.metricTons
