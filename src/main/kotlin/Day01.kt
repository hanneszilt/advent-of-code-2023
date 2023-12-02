object Day01 : Puzzle() {
    override fun part1(input: List<String>): Int {
        return input.sumOf { calibrationLine ->
            val first = calibrationLine.first { it.digitToIntOrNull() != null }
            val last = calibrationLine.last { it.digitToIntOrNull() != null }
            "$first$last".toInt()
        }
    }

    fun Regex.findBackwards(input: String): MatchResult? {
        for (i in input.length downTo 0) {
            val match = find(input, i)
            if (match != null) {
                return match
            }
        }
        return null // no match found
    }

    override fun part2(input: List<String>): Int {
        return input.sumOf { calibrationLine ->
            val regex = Regex("(one|two|three|four|five|six|seven|eight|nine|\\d)")
            val first = regex.find(calibrationLine)!!.value.matchToInt()
            val last = regex.findBackwards(calibrationLine)!!.value.matchToInt()
            val s = "$first$last"
            s.toInt()
        }
    }

    private fun String.matchToInt(): Int {
        if (toIntOrNull() != null) return toInt()
        return when (this) {
            "one" -> 1
            "two" -> 2
            "three" -> 3
            "four" -> 4
            "five" -> 5
            "six" -> 6
            "seven" -> 7
            "eight" -> 8
            "nine" -> 9
            else -> error("No number $this")
        }
    }
}

fun main() {
    val testInput = readTestInput(1)
    check(Day01.part1(testInput) == 142)

    val testInput2 = """
        two1nine
        eightwothree
        abcone2threexyz
        xtwone3four
        4nineeightseven2
        zoneight234
        7pqrstsixteen
    """.trimIndent()

    val part2 = Day01.part2(testInput2.lines())
    part2.println()
    check(part2 == 281)

    val input = readInput(1)
    Day01.part1(input).println()
    Day01.part2(input).println()
}
