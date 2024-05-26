Changes
=======

1.5.0
-----

### Changed

 - Update to Kotlin 2.0.0

1.4.0
-----

### Added

 - Full support for 3 tiers of multiplatform targets.
 - Update to Kotlin 1.9

1.3.0
-----

### Added

 - Add a scaling argument to numerical conversion operator on `Dimension` units.

### Fixed
 - Fix for JS IR support

1.2.0
-----

### Added

 - Expanded operators for math and number conversions on `Dimension` units.
 - Dedicated `Knots` unit for speed.

1.1.1
-----

### Fixed

 - Fix generic variance issue on `Ratio` and `Square` class definitions
   preventing inheritance.

1.1.0
-----


### Fixed

 - Fixed speed generic variance issue preventing speeds from being handled
   properly.

### Added

 - Calculated `value()` methods for `Ratio` classes with Number
   numerator/denominator values.
 - Methods to calculate various Speed values. eg. `toMilesPerHourValue()`.
 - Convenience methods for creating common irradiance values of `W/m^2` via
   `Number.wattsPerSquareMeter` and `Irradiance.toWattsPerSquareMeter`

### Modified

 - Non-braking change to Ratio value return types; expanded `Number` to `Double`
   specificity.


1.0.0
-----

### Added

 - Initial structures for Dimensions, Ratios, Squares and symbolized units.
 - Measurements for `ColorTemperature`, `Length`, `Mass`, `Power`,
   `Pressure`, `Speed` and `Temperature`
 - `DurationDimension` was added to wrap kotlin timestamps as a dimension.
 - `Irradiance` alias added as a shortcut for power/area density.
 - Scalar units for `Level` and `Percentage`.
 - Spacial units for `Angle`, `Cardinal`, `Coordinates`, `GeoCoordinates`
    and `GeoLine`.
