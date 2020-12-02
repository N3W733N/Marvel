package com.newteenho.marvel.util

import java.util.*

const val PUBLIC_KEY = "942971488434875d789eba1c095b42ba"
const val PRIVATE_KEY = "ada999205c6290bc2f2f16c33f6c044547f1342d"
val TS = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
val HASH = "$TS$PRIVATE_KEY$PUBLIC_KEY"