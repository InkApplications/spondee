package inkapplications.spondee.spatial

/**
 * Geographic Direction
 */
enum class Cardinal(val symbol: Char, internal val decimalSign: Int) {
    North('N', 1),
    East('E', 1),
    South('S', -1),
    West('W', -1);

    override fun toString(): String = "$symbol"
}

/**
 * Convert a cardinal direction to an angle in degrees clockwise from 0º North.
 */
fun Cardinal.toAngle(): Angle = when (this) {
    Cardinal.North -> 0.degrees
    Cardinal.East -> 90.degrees
    Cardinal.South -> 180.degrees
    Cardinal.West -> 270.degrees
}

/**
 * Convert a single character to a cardinal direction.
 */
fun Char.toCardinal(): Cardinal = Cardinal.values().first { it.symbol == uppercaseChar() }
