import kotlin.math.max
import kotlin.math.min

object Day03 : Puzzle() {

    private val symbols = "[^\\d.]".toRegex()

    fun Char.isSymbol(): Boolean = symbols.matches(this.toString())
    override fun part1(input: List<String>): Int {
        input.joinToString("\n")

        return input.flatMapIndexed { lineNumber, line ->
            val matches = "\\d+".toRegex().findAll(line)
            matches.mapNotNull { match ->
                val isPartNumber = getIndicesToCheck(lineNumber, match.range).any { pair ->
                    val charAtIndex = input.getOrNull(pair.first)?.getOrNull(pair.second)
                    charAtIndex?.isSymbol() ?: false
                }
                if (isPartNumber) match.value.toInt() else null
            }
        }.sum()
    }

    fun getIndicesToCheck(lineNumber: Int, range: IntRange): List<Pair<Int, Int>> {
        val toCheck = mutableListOf<Pair<Int, Int>>()
        (lineNumber - 1..lineNumber + 1).forEach { lineToCheck ->
            (range.first - 1..range.last + 1).forEach { index ->
                toCheck.add(lineToCheck to index)
            }
        }
        return toCheck
    }

    override fun part2(input: List<String>): Int {
        val partsPerLine = input.map { line ->
            "\\d+".toRegex().findAll(line)
        }

        return input.flatMapIndexed { lineIndex, line ->
            "\\*".toRegex().findAll(line).mapNotNull { gearMatch ->
                require(gearMatch.range.first == gearMatch.range.last)
                val gearCharIndex = gearMatch.range.first
                val linesToCheckForGearParts =
                    partsPerLine.subList(max(lineIndex - 1, 0), min(lineIndex + 2, input.size))
                val gearParts = linesToCheckForGearParts.flatMap { it }
                    .mapNotNull { match ->
                        if (gearCharIndex in match.range || gearCharIndex + 1 in match.range || gearCharIndex - 1 in match.range) {
                            match.value.toInt()
                        } else {
                            null
                        }
                    }
                if (gearParts.size == 2) {
                    "gear found in line $lineIndex at char $gearCharIndex with parts ${gearParts[0]} * ${gearParts[1]} = ${gearParts[0] * gearParts[1]}".println()
                    gearParts[0] * gearParts[1]
                } else {
                    null
                }
            }
        }.sum()
    }
}

fun main() {
    val input = readInput(3)
    Day03.part1(input).println()
    Day03.part2(input).println()
}
