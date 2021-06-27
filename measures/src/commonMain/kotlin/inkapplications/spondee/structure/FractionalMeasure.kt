package inkapplications.spondee.structure

import kotlin.math.pow

abstract class FractionalMeasure<T: Measurement<T>>(val ratio: Number, val measure: MeasurementUnit<T>): MeasurementUnit<T> {
    final override fun convertValue(value: T): Double = measure.convertValue(value) * ratio.toDouble()
    final override fun of(value: Number): T = measure.of(value.toDouble() / ratio.toDouble())
}

operator fun <T: Measurement<T>> MeasurementUnit<T>.div(divisor: Number): MeasurementUnit<T> {
    return object: MeasurementUnit<T> {
        override fun convertValue(value: T): Double {
            return this@div.convertValue(value) / divisor.toDouble()
        }

        override fun of(value: Number): T {
            return this@div.of(value.toDouble() * divisor.toDouble())
        }
    }
}

operator fun <T: Measurement<T>> MeasurementUnit<T>.times(other: Number): MeasurementUnit<T> {
    return object: MeasurementUnit<T> {
        override fun convertValue(value: T): Double {
            return this@times.convertValue(value) * other.toDouble()
        }

        override fun of(value: Number): T {
            return this@times.of(value.toDouble() / other.toDouble())
        }
    }
}

operator fun <T: Measurement<T>> MeasurementUnit<T>.plus(other: Number): MeasurementUnit<T> {
    return object: MeasurementUnit<T> {
        override fun convertValue(value: T): Double {
            return this@plus.convertValue(value) + other.toDouble()
        }

        override fun of(value: Number): T {
            return this@plus.of(value.toDouble() - other.toDouble())
        }
    }
}

operator fun <T: Measurement<T>> MeasurementUnit<T>.minus(other: Number): MeasurementUnit<T> {
    return object: MeasurementUnit<T> {
        override fun convertValue(value: T): Double {
            return this@minus.convertValue(value) - other.toDouble()
        }

        override fun of(value: Number): T {
            return this@minus.of(value.toDouble() + other.toDouble())
        }
    }
}

fun <T: Measurement<T>> MeasurementUnit<T>.pow(power: Number): MeasurementUnit<T> {
    return object: MeasurementUnit<T> {
        override fun convertValue(value: T): Double {
            return this@pow.convertValue(value).pow(power.toDouble())
        }

        override fun of(value: Number): T {
            return this@pow.of(value.toDouble().pow(power.toDouble()))
        }
    }
}
