package com.example.happybirthday.lunchtray.constants

/**
 * Object for items types. Applied to the MenuItem object.
 */
object ItemType {
    const val ENTREE = 1
    const val SIDE_DISH = 2
    const val ACCOMPANIMENT = 3
}

fun Double?.orDefaultDouble(): Double {
    return this ?: 0.0
}
