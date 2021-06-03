package com.se7en.fearngreed.ui.index.utils

import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

fun getDateString(timestamp: Long, style: FormatStyle = FormatStyle.LONG): String =
    DateTimeFormatter
        .ofLocalizedDate(style)
        .withZone(ZoneId.from(ZoneOffset.UTC))
        .format(Instant.ofEpochSecond(timestamp))
