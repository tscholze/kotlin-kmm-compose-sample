package io.github.tscholze.cmpsample.model

/** LicensePlateLocation model
 *
 * @property id ID of a license plate like "A"
 * @property city City of given ID like "Augsburg"
 * @property state State of given ID like "Bayern"
 */
data class LicensePlateLocation(
    val id: String,
    val city: String,
    val state: String
    )