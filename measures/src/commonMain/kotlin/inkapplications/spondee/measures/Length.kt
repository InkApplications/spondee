package inkapplications.spondee.measures

/**
 * Unit of measurement for a length/distance.
 */
interface Length {
    val inHundredthsOfInches: Double
    val inInches: Double
    val inFeet: Double
    val inMiles: Double

    val inMillimeters: Double
    val inCentimeters: Double
    val inMeters: Double
    val inKilometers: Double
}

internal data class HundredthsOfInches(val value: Double): Length {
    override val inHundredthsOfInches: Double get() = value
    override val inInches: Double get() = value / 100
    override val inFeet: Double get() = value / 100 / 12
    override val inMiles: Double get() = value / 100 / 12 / 5280

    override val inMillimeters: Double get() = value * 0.254
    override val inCentimeters: Double get() = value * 0.0254
    override val inMeters: Double get() = value * 0.000254
    override val inKilometers: Double get() = value * 0.000000254
}

val Number.hundredthsOfInches: Length get() = HundredthsOfInches(toDouble())

internal data class Inches(val value: Double): Length {
    override val inHundredthsOfInches: Double get() = value * 100
    override val inInches: Double get() = value
    override val inFeet: Double get() = value / 12
    override val inMiles: Double get() = value / 12 / 5280

    override val inMillimeters: Double get() = value * 25.4
    override val inCentimeters: Double get() = value * 2.54
    override val inMeters: Double get() = value * 0.0254
    override val inKilometers: Double get() = value * 0.0000254
}

val Number.inches: Length get() = Inches(toDouble())

internal data class Feet(val value: Double): Length {
    override val inHundredthsOfInches: Double get() = value * 12 * 100
    override val inInches: Double get() = value * 12
    override val inFeet: Double get() = value
    override val inMiles: Double get() = value / 5280

    override val inMillimeters: Double get() = value * 304.8
    override val inCentimeters: Double get() = value * 30.48
    override val inMeters: Double get() = value * 0.3048
    override val inKilometers: Double get() = value * 0.0003048
}

val Number.feet: Length get() = Feet(toDouble())

internal data class Miles(val value: Double): Length {
    override val inHundredthsOfInches: Double get() = value * 5280 * 12 * 100
    override val inInches: Double get() = value * 5280 * 12
    override val inFeet: Double get() = value * 5280
    override val inMiles: Double get() = value

    override val inMillimeters: Double get() = value * 1609344
    override val inCentimeters: Double get() = value * 160934.4
    override val inMeters: Double get() = value * 1609.344
    override val inKilometers: Double get() = value * 1.609344
}

val Number.miles: Length get() = Miles(toDouble())

internal data class Millimeters(val value: Double): Length {
    override val inHundredthsOfInches: Double get() = value * 3.937008
    override val inInches: Double get() = value * 0.03937008
    override val inFeet: Double get() = value * 0.00328084
    override val inMiles: Double get() = value * 0.0000006213712

    override val inMillimeters: Double get() = value
    override val inCentimeters: Double get() = value / 10
    override val inMeters: Double get() = value / 1000
    override val inKilometers: Double get() = value / 1000000
}

val Number.millimeters: Length get() = Millimeters(toDouble())

internal data class Centimeters(val value: Double): Length {
    override val inHundredthsOfInches: Double get() = value * 39.37008
    override val inInches: Double get() = value * 0.3937008
    override val inFeet: Double get() = value * 0.0328084
    override val inMiles: Double get() = value * 0.000006213712

    override val inMillimeters: Double get() = value * 10
    override val inCentimeters: Double get() = value
    override val inMeters: Double get() = value / 100
    override val inKilometers: Double get() = value / 100000
}

val Number.centimeters: Length get() = Centimeters(toDouble())

internal data class Meters(val value: Double): Length {
    override val inHundredthsOfInches: Double get() = value * 3937.008
    override val inInches: Double get() = value * 39.37008
    override val inFeet: Double get() = value * 3.28084
    override val inMiles: Double get() = value * 0.0006213712

    override val inMillimeters: Double get() = value * 1000
    override val inCentimeters: Double get() = value * 100
    override val inMeters: Double get() = value
    override val inKilometers: Double get() = value / 100
}

val Number.meters: Length get() = Meters(toDouble())

internal data class Kilometers(val value: Double): Length {
    override val inHundredthsOfInches: Double get() = value * 3937008
    override val inInches: Double get() = value * 39370.08
    override val inFeet: Double get() = value * 3280.84
    override val inMiles: Double get() = value * 0.6213712

    override val inMillimeters: Double get() = value * 1000000
    override val inCentimeters: Double get() = value * 100000
    override val inMeters: Double get() = value * 1000
    override val inKilometers: Double get() = value
}

val Number.kilometers: Length get() = Kilometers(toDouble())
