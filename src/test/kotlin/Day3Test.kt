import Day03.isSymbol
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class Day3Test {

    @ParameterizedTest
    @ValueSource(
        chars = [
            '!',
            '@',
            '#',
            '$',
            '%',
            '^',
            '&',
            '*',
            '(',
            ')',
            '_',
            '+',
        ],
    )
    fun isSymbol(char: Char) {
        char.isSymbol() shouldBe true
    }

    @Test
    fun `is no symbol`() {
        "1234567890.".forEach { char ->
            println(char)
            char.isSymbol() shouldBe false
        }
    }

    @Test
    fun part1() {
        Day03.part1(readTestInput(3)) shouldBe 4361
    }

    @Test
    fun part2() {
        Day03.part2(readTestInput(3)) shouldBe 467835
    }
}
