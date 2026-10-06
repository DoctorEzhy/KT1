fun main() {
    print("Имя: ")
    val rawName = readLine()

    print("Возраст: ")
    val rawAge = readLine()

    print("Город: ")
    val rawCity = readLine()

    val name = formatName(rawName)
    val age = parseAge(rawAge)
    val city = formatCity(rawCity)
    val status = getStatus(age)

    val report = """
        |Профиль пользователя:
        |Имя: $name
        |Возраст: ${age ?: "не указан"}
        |Город: $city
        |
        |Статус: $status
    """.trimMargin()

    println()
    println(report)
}

fun formatName(raw: String?): String {
    val trimmed = raw?.trim()
    return if (trimmed.isNullOrEmpty()) {
        "не указано"
    } else {
        trimmed.lowercase().replaceFirstChar { it.uppercase() }
    }
}

fun parseAge(raw: String?): Int? {
    val trimmed = raw?.trim()
    if (trimmed.isNullOrEmpty()) return null
    return trimmed.toIntOrNull()
}

fun formatCity(raw: String?): String {
    val trimmed = raw?.trim()
    return if (trimmed.isNullOrEmpty()) "не указан" else trimmed
}

fun getStatus(age: Int?): String = when {
    age == null -> "недостаточно данных"
    age < 18 -> "несовершеннолетний"
    age in 18..60 -> "взрослый пользователь"
    else -> "пожилой пользователь"
}