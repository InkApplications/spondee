package inkapplications.spondee.measures

/**
 * Unit of energy per unit time
 */
interface Power {
    /**
     * Express the power in watts.
     */
    val inWatts: Double
}

/**
 * SI Unit of Power.
 */
internal data class Watts(override val inWatts: Double): Power {
    override fun toString(): String = "${inWatts}W"
}

/**
 * Express a number as unit of power in Watts.
 */
val Number.watts: Power get() = Watts(toDouble())
