import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day02Test {
    @Test
    fun `part1 test`() {
        Day02.part1(readTestInput(2)) shouldBe 8
    }

    @Test
    fun `part2 test`() {
        Day02.part2(readTestInput(2)) shouldBe 2286
    }

    @Test
    fun name() {
        Day02.getCubeNumber("5 red", "red") shouldBe 5
        Day02.getCubeNumber("", "red") shouldBe 0
    }
}
