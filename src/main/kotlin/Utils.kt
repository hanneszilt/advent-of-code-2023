import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readLines

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/main/kotlin/$name.txt").readLines()

fun readInput(day: Int) = readInput("Day" + day.toString().padStart(2, '0'))
fun readTestInput(day: Int) = readInput("Day" + day.toString().padStart(2, '0') + "_test")

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
