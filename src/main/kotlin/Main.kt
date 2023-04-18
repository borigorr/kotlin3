fun main(args: Array<String>) {
    println(agoToText(60000u))
}

fun agoToText(seconds: UInt) = when {
    seconds <= 60u -> "был(а) только что"
    seconds > 60u && seconds <= 60u * 60u -> {
        val minutes = seconds / 60U
        "был(а) $minutes ${minuteToString(minutes)} назад"
    }

    seconds > 60u * 60u + 1u && seconds <= 24u * 60u * 60u -> {
        val hours = seconds / 3600U
        "был(а) $hours ${hoursToString(hours)} назад"
    }

    seconds > 60u * 60u * 24u + 1u && seconds <= 60u * 60u * 24u * 2u -> "был(а) вчера"
    seconds > 60u * 60u * 24u * 2u + 1u && seconds <= 60u * 60u * 24u * 3u -> "был(а) позавчера"
    else -> "был(а) давно"
}

fun hoursToString(hours: UInt): String {
    if (hours in 10u..19u) {
        return "часов"
    }
    return when (hours.toString().last()) {
        '1' -> "час"
        '2', '3', '4' -> "часа"
        else -> "часов"
    }
}

fun minuteToString(minutes: UInt): String {
    if (minutes in 10u..19u) {
        return "минут"
    }
    return when (minutes.toString().last()) {
        '1' -> "минуту"
        '2', '3', '4' -> "минуты"
        else -> "минут"
    }
}