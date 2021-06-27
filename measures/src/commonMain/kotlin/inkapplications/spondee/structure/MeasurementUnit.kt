package inkapplications.spondee.structure

interface MeasurementUnit<M: Measurement<M>> {
    fun convertValue(value: M): Double
    fun of(value: Number): M
}

fun <M: Measurement<M>> MeasurementUnit<M>.of(scale: SiScale, value: Number): M {
    return of(scale.factor * value.toDouble())
}
