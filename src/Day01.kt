import kotlin.math.max

fun main() {
    fun part1(input: List<String>): Int {
        var maxTotal = Int.MIN_VALUE
        var sum = 0
        (input + "").forEach {
            if (it.isNotEmpty()) {
                sum += it.toInt()
            } else {
                maxTotal = max(maxTotal, sum)
                sum = 0
            }
        }
        return maxTotal
    }

    fun part2(input: List<String>): Int {
        val totals = mutableListOf<Int>()
        var sum = 0
        (input + "").forEach {
            if (it.isNotEmpty()) {
                sum += it.toInt()
            } else {
                totals += sum
                sum = 0
            }
        }
        return totals.sorted().takeLast(3).sum()
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
