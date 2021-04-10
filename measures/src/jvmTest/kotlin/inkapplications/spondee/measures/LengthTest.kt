package inkapplications.spondee.measures

import kotlin.test.Test
import kotlin.test.assertTrue

class LengthTest {
    @Test
    fun conversions() {
        12.hundredthsOfInches.run {
            assertEquals(12.0, inHundredthsOfInches, 0.1)
            assertEquals(.12, inInches, 0.001)
            assertEquals(.01, inFeet, 0.001)
            assertEquals(0.000001893939, inMiles, .0000000000001)

            assertEquals(3.048, inMillimeters, 0.0001)
            assertEquals(0.3048, inCentimeters, 0.00001)
            assertEquals(0.003048, inMeters, 0.0000001)
            assertEquals(0.000003048, inKilometers, 0.0000000001)
        }

        12.inches.run {
            assertEquals(1200.0, inHundredthsOfInches, 0.1)
            assertEquals(12.0, inInches, 0.001)
            assertEquals(1.0, inFeet, 0.001)
            assertEquals(0.0001893939, inMiles, .0000000000001)

            assertEquals(304.8, inMillimeters, 0.01)
            assertEquals(30.48, inCentimeters, 0.001)
            assertEquals(0.3048, inMeters, 0.00001)
            assertEquals(0.0003048, inKilometers, 0.00000001)
        }

        12.feet.run {
            assertEquals(14400.0, inHundredthsOfInches, 0.1)
            assertEquals(144.0, inInches, 0.1)
            assertEquals(12.0, inFeet, 0.001)
            assertEquals(0.002272727, inMiles, .0000000001)

            assertEquals(3657.6, inMillimeters, 0.01)
            assertEquals(365.76, inCentimeters, 0.001)
            assertEquals(3.6576, inMeters, 0.00001)
            assertEquals(0.0036576, inKilometers, 0.00000001)
        }

        12.miles.run {
            assertEquals(76032000.0, inHundredthsOfInches, 0.1)
            assertEquals(760320.0, inInches, 0.1)
            assertEquals(63360.0, inFeet, 0.1)
            assertEquals(12.0, inMiles, .1)

            assertEquals(19312130.0, inMillimeters, 10.0)
            assertEquals(1931213.0, inCentimeters, 1.0)
            assertEquals(19312.13, inMeters, 0.01)
            assertEquals(19.31213, inKilometers, 0.00001)
        }

        12.millimeters.run {
            assertEquals(47.24409, inHundredthsOfInches, 0.000001)
            assertEquals(0.4724409, inInches, 0.00000001)
            assertEquals(0.03937007513, inFeet, 0.000000000001)
            assertEquals(0.000007456454, inMiles, .0000000000001)

            assertEquals(12.0, inMillimeters, .1)
            assertEquals(1.2, inCentimeters, 0.01)
            assertEquals(0.012, inMeters, 0.0001)
            assertEquals(0.000012, inKilometers, 0.0000001)
        }

        12.centimeters.run {
            assertEquals(47.24409, inHundredthsOfInches, 0.000001)
            assertEquals(0.4724409, inInches, 0.00000001)
            assertEquals(0.03937007513, inFeet, 0.000000000001)
            assertEquals(0.000007456454, inMiles, .0000000000001)

            assertEquals(120.0, inMillimeters, .1)
            assertEquals(12.0, inCentimeters, .1)
            assertEquals(0.12, inMeters, 0.001)
            assertEquals(0.00012, inKilometers, 0.000001)
        }

        12.meters.run {
            assertEquals(47244.09, inHundredthsOfInches, 0.001)
            assertEquals(472.4409, inInches, 0.00001)
            assertEquals(39.37008, inFeet, 0.000001)
            assertEquals(0.007456454, inMiles, 0.0000000001)

            assertEquals(120.0, inMillimeters, 0.1)
            assertEquals(12.0, inCentimeters, 0.1)
            assertEquals(12.0, inMeters, 0.1)
            assertEquals(0.00012, inKilometers, 0.000001)
        }

        12.kilometers.run {
            assertEquals(47244090.0, inHundredthsOfInches, 0.1)
            assertEquals(472440.9, inInches, 0.01)
            assertEquals(39370.08, inFeet, 0.001)
            assertEquals(7.456454, inMiles, 0.0000001)

            assertEquals(12000000.0, inMillimeters, 1.0)
            assertEquals(1200000.0, inCentimeters, 0.1)
            assertEquals(12000.0, inMeters, 0.1)
            assertEquals(12.0, inKilometers, 0.1)
        }
    }

    private fun assertEquals(expected: Double, actual: Double, delta: Double) {
        assertTrue(expected - actual < delta, "Expected <$expected> to be within <$delta> of <$actual>")
    }
}
