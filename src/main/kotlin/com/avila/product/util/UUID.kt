package com.avila.product.util

import java.util.UUID

fun String?.toUUIDOrNull(): UUID? {
    return try {
        this?.let { UUID.fromString(it) }
    } catch (e: IllegalArgumentException) {
        null
    }
}
