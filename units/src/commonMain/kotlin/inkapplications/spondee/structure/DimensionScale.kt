package inkapplications.spondee.structure

/**
 * A predefined scalar unit that can be used to adjust a dimension.
 *
 * @param factor value to multiply with when scaling a dimension in this scale.
 * @param symbol A symbol to represent this scale.
 * @param prefixPadding Whether the prefix symbol requires padding between itself an the unit symbol
 */
data class DimensionScale(
    val factor: Number,
    val symbol: String,
    val prefixPadding: Boolean = false,
) {
    /**
     * A prefix string to add in front of a unit when using this scale.
     */
    val prefix = "$symbol${if (prefixPadding) " " else ""}"
}

/**
 * Apply a scale to a number.
 *
 * This is a convenience method for [DimensionScale.times] to chain with
 * measurement creation. eg.
 *
 *     123.scale(Kilo).meters // returns Meters(123_000)
 */
fun Number.scale(scale: DimensionScale): Number = toDouble().times(scale.factor.toDouble())

val Yotta = DimensionScale(1e24, "Y")
val Zetta = DimensionScale(1e21, "Z")
val Exa = DimensionScale(1e18, "E")
val Peta = DimensionScale(1e15, "P")
val Tera = DimensionScale(1e12, "T")
val Giga = DimensionScale(1e9, "G")
val Mega = DimensionScale(1e6, "M")
val Kilo = DimensionScale(1e3, "k")
val Hecto = DimensionScale(1e2, "h")
val Deka = DimensionScale(1e1, "da")
val Deci = DimensionScale(1e-1, "d")
val Centi = DimensionScale(1e-2, "c")
val Milli = DimensionScale(1e-3, "m")
val Micro = DimensionScale(1e-6, "mu")
val Nano = DimensionScale(1e-9, "n")
val Pico = DimensionScale(1e-12, "p")
val Femto = DimensionScale(1e-15, "f")
val Atto = DimensionScale(1e-18, "a")
val Zepto = DimensionScale(1e-21, "z")
val Yocto = DimensionScale(1e-24, "y")
val Nominal = DimensionScale(1.0, "")

val Hundreths = DimensionScale(1e-2, "1/100", prefixPadding = true)
val Thou = DimensionScale(1e-3, "thou", prefixPadding = true)
