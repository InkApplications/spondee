package inkapplications.spondee.measures

import kotlin.jvm.JvmInline

/**
 * Unit of measurement for a length/distance.
 */
interface Length: DoubleMeasure<Length> {
    val inHundredthsOfInches: Double
    val inInches: Double
    val inFeet: Double
    val inMiles: Double

    val inMillimeters: Double
    val inCentimeters: Double
    val inMeters: Double
    val inKilometers: Double
}

@JvmInline
internal value class HundredthsOfInches(override val inHundredthsOfInches: Double): Length {
    override val inInches: Double get() = inHundredthsOfInches / 100
    override val inFeet: Double get() = inHundredthsOfInches / 100 / 12
    override val inMiles: Double get() = inHundredthsOfInches / 100 / 12 / 5280

    override val inMillimeters: Double get() = inHundredthsOfInches * 0.254
    override val inCentimeters: Double get() = inHundredthsOfInches * 0.0254
    override val inMeters: Double get() = inHundredthsOfInches * 0.000254
    override val inKilometers: Double get() = inHundredthsOfInches * 0.000000254

    override fun convert(value: Length): Double = value.inHundredthsOfInches
    override fun create(value: Double): Length = HundredthsOfInches(value)

    override fun toString(): String = "${inHundredthsOfInches}(1/100)in"
}

val Number.hundredthsOfInches: Length get() = HundredthsOfInches(toDouble())

@JvmInline
internal value class Inches(override val inInches: Double): Length {
    override val inHundredthsOfInches: Double get() = inInches * 100
    override val inFeet: Double get() = inInches / 12
    override val inMiles: Double get() = inInches / 12 / 5280

    override val inMillimeters: Double get() = inInches * 25.4
    override val inCentimeters: Double get() = inInches * 2.54
    override val inMeters: Double get() = inInches * 0.0254
    override val inKilometers: Double get() = inInches * 0.0000254

    override fun convert(value: Length): Double = value.inInches
    override fun create(value: Double): Length = Inches(value)

    override fun toString(): String = "${inInches}in"
}

val Number.inches: Length get() = Inches(toDouble())
val inch = 1.inches

@JvmInline
internal value class Feet(override val inFeet: Double): Length {
    override val inHundredthsOfInches: Double get() = inFeet * 12 * 100
    override val inInches: Double get() = inFeet * 12
    override val inMiles: Double get() = inFeet / 5280

    override val inMillimeters: Double get() = inFeet * 304.8
    override val inCentimeters: Double get() = inFeet * 30.48
    override val inMeters: Double get() = inFeet * 0.3048
    override val inKilometers: Double get() = inFeet * 0.0003048

    override fun convert(value: Length): Double = value.inFeet
    override fun create(value: Double): Length = Feet(value)

    override fun toString(): String = "${inFeet}ft"
}

val Number.feet: Length get() = Feet(toDouble())
val foot = 1.feet

@JvmInline
internal value class Miles(override val inMiles: Double): Length {
    override val inHundredthsOfInches: Double get() = inMiles * 5280 * 12 * 100
    override val inInches: Double get() = inMiles * 5280 * 12
    override val inFeet: Double get() = inMiles * 5280

    override val inMillimeters: Double get() = inMiles * 1609344
    override val inCentimeters: Double get() = inMiles * 160934.4
    override val inMeters: Double get() = inMiles * 1609.344
    override val inKilometers: Double get() = inMiles * 1.609344

    override fun convert(value: Length): Double = value.inMiles
    override fun create(value: Double): Length = Miles(value)

    override fun toString(): String = "${inMiles}mi"
}

val Number.miles: Length get() = Miles(toDouble())
val mile = 1.miles

@JvmInline
internal value class Millimeters(override val inMillimeters: Double): Length {
    override val inHundredthsOfInches: Double get() = inMillimeters * 3.937008
    override val inInches: Double get() = inMillimeters * 0.03937008
    override val inFeet: Double get() = inMillimeters * 0.00328084
    override val inMiles: Double get() = inMillimeters * 0.0000006213712

    override val inCentimeters: Double get() = inMillimeters / 10
    override val inMeters: Double get() = inMillimeters / 1000
    override val inKilometers: Double get() = inMillimeters / 1000000

    override fun convert(value: Length): Double = value.inMillimeters
    override fun create(value: Double): Length = Millimeters(value)

    override fun toString(): String = "${inMillimeters}mm"
}

val Number.millimeters: Length get() = Millimeters(toDouble())
val millimeter = 1.millimeters

@JvmInline
internal value class Centimeters(override val inCentimeters: Double): Length {
    override val inHundredthsOfInches: Double get() = inCentimeters * 39.37008
    override val inInches: Double get() = inCentimeters * 0.3937008
    override val inFeet: Double get() = inCentimeters * 0.0328084
    override val inMiles: Double get() = inCentimeters * 0.000006213712

    override val inMillimeters: Double get() = inCentimeters * 10
    override val inMeters: Double get() = inCentimeters / 100
    override val inKilometers: Double get() = inCentimeters / 100000

    override fun convert(value: Length): Double = value.inCentimeters
    override fun create(value: Double): Length = Centimeters(value)

    override fun toString(): String = "${inCentimeters}cm"
}

val Number.centimeters: Length get() = Centimeters(toDouble())
val centimeter = 1.centimeters

@JvmInline
internal value class Meters(override val inMeters: Double): Length {
    override val inHundredthsOfInches: Double get() = inMeters * 3937.008
    override val inInches: Double get() = inMeters * 39.37008
    override val inFeet: Double get() = inMeters * 3.28084
    override val inMiles: Double get() = inMeters * 0.0006213712

    override val inMillimeters: Double get() = inMeters * 1000
    override val inCentimeters: Double get() = inMeters * 100
    override val inKilometers: Double get() = inMeters / 1000

    override fun convert(value: Length): Double = value.inMeters
    override fun create(value: Double): Length = Meters(value)

    override fun toString(): String = "${inMeters}m"
}

val Number.meters: Length get() = Meters(toDouble())
val meter = 1.meters

@JvmInline
internal value class Kilometers(override val inKilometers: Double): Length {
    override val inHundredthsOfInches: Double get() = inKilometers * 3937008
    override val inInches: Double get() = inKilometers * 39370.08
    override val inFeet: Double get() = inKilometers * 3280.84
    override val inMiles: Double get() = inKilometers * 0.6213712

    override val inMillimeters: Double get() = inKilometers * 1000000
    override val inCentimeters: Double get() = inKilometers * 100000
    override val inMeters: Double get() = inKilometers * 1000

    override fun convert(value: Length): Double = value.inKilometers
    override fun create(value: Double): Length = Kilometers(value)

    override fun toString(): String = "${inKilometers}km"
}

val Number.kilometers: Length get() = Kilometers(toDouble())
val kilometer = 1.kilometers
