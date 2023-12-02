import Day01.findBackwards
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day01Test {
    @Test
    fun test() {
        Day01.part1(readTestInput(1)) shouldBe 142
    }

    @Test
    fun part1() {
        Day01.part1(readInput(1)) shouldBe 55123
    }

    @Test
    fun part2() {
        Day01.part2(readInput(1)) shouldBe 55260
    }

    @Test
    fun name() {
        val input = "eightwo"
        val regex = Regex("(one|two|three|four|five|six|seven|eight|nine|\\d)")

        regex.findBackwards(input)!!.value shouldBe "two"
    }
}
