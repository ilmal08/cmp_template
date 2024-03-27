package com.ilmal08.kmptemplate.util

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.time.Duration

fun formatDateTime(dateTimeString: String): String {
    try {
        val now = Clock.System.now()
        val correctedDateTimeString = dateTimeString.replaceFirst(":(\\d{2})$", "$1")
        val instantInThePast: Instant = Instant.parse(correctedDateTimeString)
        val durationSinceThen: Duration = now - instantInThePast

        return when {
            durationSinceThen.inWholeDays > 365 -> "${durationSinceThen.inWholeDays / 365} years ago"
            durationSinceThen.inWholeDays > 30 -> "${durationSinceThen.inWholeDays / 30} months ago"
            durationSinceThen.inWholeDays > 0 -> "${durationSinceThen.inWholeDays} days ago"
            durationSinceThen.inWholeHours > 0 -> "${durationSinceThen.inWholeHours} hours ago"
            durationSinceThen.inWholeMinutes > 0 -> "${durationSinceThen.inWholeMinutes} minutes ago"
            else -> "Just now"
        }
    } catch (e: Exception) {
        // Handle parsing exception
        return "Invalid date-time format"
    }
}