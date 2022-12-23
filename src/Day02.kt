enum class Move {
    ROCK, PAPER, SCISSORS;

    val score = ordinal + 1

    infix fun beats(other: Move) = when (other) {
        ROCK -> this == PAPER
        PAPER -> this == SCISSORS
        SCISSORS -> this == ROCK
    }
}

fun main() {

    fun score(myMove: Move, otherMove: Move): Int = when {
        myMove == otherMove -> 3
        myMove beats otherMove -> 6
        else -> 0
    }

    fun Char.toMove() = when (this) {
        'A', 'X' -> Move.ROCK
        'B', 'Y' -> Move.PAPER
        'C', 'Z' -> Move.SCISSORS
        else -> throw IllegalArgumentException()
    }

    fun part1(input: List<String>): Int {
        return input.sumOf {
            val myMove = it[2].toMove()
            val otherMove = it[0].toMove()
            myMove.score + score(myMove, otherMove)
        }
    }

    fun part2(input: List<String>): Int {
        val allMoves = Move.values()
        return input.sumOf {
            val otherMove = it[0].toMove()
            val offset = it[2] - 'Y'
            val myMove = allMoves[(otherMove.ordinal + offset).mod(allMoves.size)]
            myMove.score + score(myMove, otherMove)
        }
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
