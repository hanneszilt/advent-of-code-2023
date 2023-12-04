import kotlin.math.min
import kotlin.math.pow

object Day04 : Puzzle() {

    private fun parseNumbers(input: String): List<Int> = input.trim()
        .split(" ")
        .filter { it.isNotBlank() }
        .map { it.toInt() }

    override fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            val lineSplit = line.substringAfter(":").split("|")
            val winningNumbers = parseNumbers(lineSplit[0])
            val numbersYouHave = parseNumbers(lineSplit[1])
            val haveWinningNumbers = numbersYouHave.count { it in winningNumbers }
            2.0.pow(haveWinningNumbers - 1).toInt()
        }
    }

    override fun part2(input: List<String>): Int {
        val duplicatedCards = mutableMapOf<Int, Int>()

        val wins = input.mapIndexed { index, line ->
            val lineSplit = line.substringAfter(":").split("|")
            val winningNumbers = parseNumbers(lineSplit[0])
            val numbersYouHave = parseNumbers(lineSplit[1])
            val noOfWinningNumbers = numbersYouHave.count { it in winningNumbers }
            val cardsToDuplicate = min(index + 1, input.size)..min(index + noOfWinningNumbers, input.size)
            val currentCardInstances = duplicatedCards.getOrDefault(index, 1)
            cardsToDuplicate.forEach { cardIndex ->
                duplicatedCards[cardIndex] = duplicatedCards.getOrDefault(cardIndex, 1) + currentCardInstances
            }
            index + 1 to currentCardInstances
        }

        return wins.sumOf { it.second }
    }
}

fun main() {
    val input = readInput(4)
    Day04.part1(input).println()
    Day04.part2(input).println()
}
