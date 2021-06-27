package inkapplications.spondee.structure

interface Measurement<T: Measurement<T>> {
    val baseValue: Double
    val baseUnit: MeasurementUnit<T>
}

fun <T: Measurement<T>> T.value(unit: MeasurementUnit<T>): Double = unit.convertValue(this)
fun <T: Measurement<T>> T.value(scale: SiScale, unit: MeasurementUnit<T>): Double = unit.convertValue(this) / scale.factor


operator fun <T: Measurement<T>> T.rem(other: T): T {
    return baseUnit.of(baseValue % other.baseValue)
}

operator fun <T: Measurement<T>> T.compareTo(other: T): Int {
    return baseValue.compareTo(other.baseValue)
}

operator fun <T: Measurement<T>> T.plus(other: T): T {
    return baseUnit.of(baseValue + other.baseValue)
}
