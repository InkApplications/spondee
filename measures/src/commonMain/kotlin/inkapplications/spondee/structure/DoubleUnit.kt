package inkapplications.spondee.structure

import kotlin.math.pow

interface DoubleUnit<M: DoubleMeasurement<M>> {
    fun convertValue(value: M): Double
    fun of(value: Number): M
}

fun <M: DoubleMeasurement<M>> DoubleUnit<M>.of(scale: SiScale, value: Number): M {
    return of(scale.factor * value.toDouble())
}

operator fun <T: DoubleMeasurement<T>> DoubleUnit<T>.div(divisor: Number): DoubleUnit<T> {
    return object: DoubleUnit<T> {
        override fun convertValue(value: T): Double {
            return this@div.convertValue(value) / divisor.toDouble()
        }

        override fun of(value: Number): T {
            return this@div.of(value.toDouble() * divisor.toDouble())
        }
    }
}

operator fun <T: DoubleMeasurement<T>> DoubleUnit<T>.times(other: Number): DoubleUnit<T> {
    return object: DoubleUnit<T> {
        override fun convertValue(value: T): Double {
            return this@times.convertValue(value) * other.toDouble()
        }

        override fun of(value: Number): T {
            return this@times.of(value.toDouble() / other.toDouble())
        }
    }
}

operator fun <T: DoubleMeasurement<T>> DoubleUnit<T>.plus(other: Number): DoubleUnit<T> {
    return object: DoubleUnit<T> {
        override fun convertValue(value: T): Double {
            return this@plus.convertValue(value) + other.toDouble()
        }

        override fun of(value: Number): T {
            return this@plus.of(value.toDouble() - other.toDouble())
        }
    }
}

operator fun <T: DoubleMeasurement<T>> DoubleUnit<T>.minus(other: Number): DoubleUnit<T> {
    return object: DoubleUnit<T> {
        override fun convertValue(value: T): Double {
            return this@minus.convertValue(value) - other.toDouble()
        }

        override fun of(value: Number): T {
            return this@minus.of(value.toDouble() + other.toDouble())
        }
    }
}

fun <T: DoubleMeasurement<T>> DoubleUnit<T>.pow(power: Number): DoubleUnit<T> {
    return object: DoubleUnit<T> {
        override fun convertValue(value: T): Double {
            return this@pow.convertValue(value).pow(power.toDouble())
        }

        override fun of(value: Number): T {
            return this@pow.of(value.toDouble().pow(power.toDouble()))
        }
    }
}
