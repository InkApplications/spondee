package inkapplications.spondee.measure.us

import inkapplications.spondee.measure.Mass
import inkapplications.spondee.measure.metric.Grams
import inkapplications.spondee.measure.metric.grams
import inkapplications.spondee.structure.*
import kotlin.jvm.JvmInline

private const val OUNCES_PER_GRAM = 28.349_523_125

/**
 * US customary avoirdupois unit of mass and weight
 */
@JvmInline
value class Ounces(override val value: Number): Dimension<Ounces>, Mass {
    override val symbol: String get() = "oz"
    override fun toGrams(): Grams = convert { this * OUNCES_PER_GRAM }.grams
    override fun withValue(value: Number): Ounces = Ounces(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a unit of mass/weight in ounces.
 */
val Number.ounces get() = Ounces(this)

/**
 * Convert a mass to a unit of ounces.
 */
fun Mass.toOunces() = toGrams().convert { this / OUNCES_PER_GRAM }.ounces

/**
 * Convenience reference unit for a single ounce.
 */
val Ounce = 1.ounces

/**
 * US Customary unit of mass and weight in pounds
 */
@JvmInline
value class Pounds(override val value: Number): Dimension<Pounds>, Mass {
    override val symbol: String get() = "lbs"
    override fun toGrams(): Grams = convert { ounces * 16 }.toGrams()
    override fun withValue(value: Number): Pounds = Pounds(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a unit of mass/weight in poinds
 */
val Number.pounds get() = Pounds(this)

/**
 * Convert a unit of mass to Pounds
 */
fun Mass.toPounds() = toOunces().convert { this / 16 }.pounds

/**
 * Convenience reference unit for a single pound
 */
val Pound = 1.pounds

/**
 * US Customary unit of mass and weight in short tons.
 */
@JvmInline
value class ShortTons(override val value: Number): Dimension<ShortTons>, Mass {
    override val symbol: String get() = "ST"
    override fun toGrams(): Grams = convert { pounds * 2000 }.toGrams()
    override fun withValue(value: Number): ShortTons = ShortTons(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a unit in short-tons
 */
val Number.shortTons get() = ShortTons(this)

/**
 * Convert a mass unit to short-tons
 */
fun Mass.toShortTons() = toPounds().convert { this / 2000 }.shortTons

/**
 * Convenience reference unit for a single short ton
 */
val ShortTon = 1.shortTons

/**
 * US Customary unit of mass and weight in Long Tons
 */
@JvmInline
value class LongTons(override val value: Number): Dimension<LongTons>, Mass {
    override val symbol: String get() = "LT"
    override fun toGrams(): Grams = convert { pounds * 2240 }.toGrams()
    override fun withValue(value: Number): LongTons = LongTons(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a unit of long-tons
 */
val Number.longTons get() = LongTons(this)

/**
 * Convert a unit of mass to long-tons
 */
fun Mass.toLongTons() = toPounds().convert { this / 2240 }.longTons

/**
 * Convenience unit for a single long-ton
 */
val LongTon = 1.longTons

/**
 * US Customary unit of mass and weight in grains
 */
@JvmInline
value class Grains(override val value: Number): Dimension<Grains>, Mass {
    override val symbol: String get() = "gr"
    override fun toGrams(): Grams = convert { pounds / 7000 }.toGrams()
    override fun withValue(value: Number): Grains = Grains(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a unit of mass/weight in grains
 */
val Number.grains get() = Grains(this)

/**
 * Convert a unit of mass to grains
 */
fun Mass.toGrains() = toPounds().convert { this * 7000 }.grains

/**
 * Convenience reference unit for a single grain
 */
val Grain = 1.grains

/**
 * US Customary unit of drams
 */
@JvmInline
value class Drams(override val value: Number): Dimension<Drams>, Mass {
    override val symbol: String get() = "dr"
    override fun toGrams(): Grams = convert { pounds / 256 }.toGrams()
    override fun withValue(value: Number): Drams = Drams(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a unit of mass/weight in drams
 */
val Number.drams get() = Drams(this)

/**
 * Convert a unit of mass to drams
 */
fun Mass.toDrams() = toPounds().convert { this * 256 }.drams

/**
 * Convenience unit for a single Dram
 */
val Dram = 1.drams

/**
 * US Customary unit of short hundredweights
 */
@JvmInline
value class ShortHundredweights(override val value: Number): Dimension<ShortHundredweights>, Mass {
    override val symbol: String get() = "cwt"
    override fun toGrams(): Grams = convert { pounds * 100 }.toGrams()
    override fun withValue(value: Number): ShortHundredweights = ShortHundredweights(value)
    override fun toString(): String = format()
}

/**
 * Express this number as a unit of mass/weight in short hundredweights
 */
val Number.shortHundredweights get() = ShortHundredweights(this)

/**
 * Convert a unit of mass to short hundredweights
 */
fun Mass.toShortHundredweights() = toPounds().convert { this / 100 }.shortHundredweights

/**
 * Convenience unit for a single short-hundredweight.
 */
val ShortHundredweight = 1.shortHundredweights
