fun main() {

    fun Char.priority() = code - if (isLowerCase()) 96 else 38

    fun part1(input: List<String>): Int = input.sumOf {
        val first = it.slice(0 until it.length / 2)
        val second = it.slice(it.length / 2 until it.length)
        (first.toSet() intersect second.toSet()).single().priority()
    }

    fun part2(input: List<String>): Int = input.chunked(3) {
        it.map(String::toSet)
    }.sumOf {
        it.reduce(Set<Char>::intersect).single().priority()
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
