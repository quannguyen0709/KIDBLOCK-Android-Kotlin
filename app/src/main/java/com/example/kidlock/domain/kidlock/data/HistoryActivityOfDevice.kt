package com.example.kidlock.domain.kidlock.data

import java.time.format.DateTimeFormatter

data class HistoryActivityOfDevice(
    val timeActivityOfDevice: Map<String, DateTimeFormatter>,
)