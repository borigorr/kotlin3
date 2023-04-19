fun main(args: Array<String>) {
    println(agoToText(3600u))
}

fun agoToText(seconds: UInt) = when {
    seconds <= 60u -> "был(а) только что"
    seconds in 61u .. 3600u -> {
        val minutes = seconds / 60u
        "был(а) $minutes ${minuteToString(minutes)} назад"
    }

    seconds in  3601u .. 86_400u -> {
        val hours = seconds / 3600U
        "был(а) $hours ${hoursToString(hours)} назад"
    }

    seconds in 86_401u..172_800u -> "был(а) вчера"
    seconds in 172_801u..259_200u -> "был(а) позавчера"
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