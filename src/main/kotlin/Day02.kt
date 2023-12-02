object Day02 : Puzzle() {
    override fun part1(input: List<String>): Int {
        return input.mapNotNull { line ->
            // Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
            val splitLine = line.split(":")
            val gameIndex = "\\d+".toRegex().find(splitLine[0])!!.value.toInt()

            val reveals = splitLine[1].split(";").map { reveal ->
                // looks like: 6 red, 1 blue, 3 green
                val red = getCubeNumber(reveal, "red")
                val green = getCubeNumber(reveal, "green")
                val blue = getCubeNumber(reveal, "blue")

                // return if game is possible
                red <= 12 && green <= 13 && blue <= 14
            }
            // return game index if all reveals for a game where possible else null
            if (reveals.all { it }) gameIndex else null
        }
            .sum()
    }

    fun getCubeNumber(reveal: String, color: String) =
        "(\\d+) $color".toRegex().find(reveal)?.groupValues?.get(1)?.toInt() ?: 0

    override fun part2(input: List<String>): Int {
        return input.map { line ->
            // Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
            val splitLine = line.split(":")

            var requiredRed = 0
            var requiredGreen = 0
            var requiredBlue = 0

            splitLine[1].split(";").map { reveal ->
                // looks like: 6 red, 1 blue, 3 green
                val red = getCubeNumber(reveal, "red")
                val green = getCubeNumber(reveal, "green")
                val blue = getCubeNumber(reveal, "blue")

                red.takeIf { it > requiredRed }?.let { requiredRed = it }
                green.takeIf { it > requiredGreen }?.let { requiredGreen = it }
                blue.takeIf { it > requiredBlue }?.let { requiredBlue = it }
            }

            Triple(requiredRed, requiredGreen, requiredBlue)
        }.sumOf { (red, green, blue) ->
            red * green * blue
        }
    }
}

fun main() {
    val input = readInput(2)
    Day02.part1(input).println()
    Day02.part2(input).println()
}
