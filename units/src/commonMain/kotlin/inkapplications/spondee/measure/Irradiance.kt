package inkapplications.spondee.measure

import inkapplications.spondee.structure.Ratio
import inkapplications.spondee.structure.Square

/**
 * Unit of power density by area.
 */
typealias Irradiance = Ratio<out Power, out Square<out Length>>
