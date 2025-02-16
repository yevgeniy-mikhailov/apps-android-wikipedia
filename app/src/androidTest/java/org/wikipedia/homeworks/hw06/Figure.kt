package org.wikipedia.homeworks.hw06

data class Shape(
    val sideLength: Float, val sidesCount: Int, val color: Color
) {

    fun getAnglesCount(): Int {
        return when (sidesCount) {
            1, 2 -> 0
            in 3..Int.MAX_VALUE -> sidesCount

            else -> throw IllegalStateException("wrong number of angles")
        }
    }
}

enum class Color {
    RED, BLUE, GREEN, YELLOW, BLACK, WHITE
}

fun main() {
    val shapes = listOf(
        Shape(10f, 3, Color.RED),
        Shape(5f, 4, Color.BLUE),
        Shape(7f, 2, Color.GREEN),
        Shape(0.5f, 1, Color.YELLOW),
        Shape(-3f, 5, Color.BLACK),
        Shape(8f, -2, Color.WHITE),
        Shape(12f, 6, Color.RED),
        Shape(15f, 8, Color.BLUE),
        Shape(20f, 4, Color.GREEN),
        Shape(9f, 5, Color.YELLOW),
        Shape(2f, 3, Color.BLACK),
        Shape(11f, 7, Color.WHITE),
        Shape(6f, 10, Color.RED),
        Shape(3f, 2, Color.BLUE),
        Shape(4f, 1, Color.GREEN),
        Shape(25f, 12, Color.YELLOW),
        Shape(30f, 14, Color.BLACK),
        Shape(35f, 16, Color.WHITE),
        Shape(40f, 18, Color.RED),
        Shape(50f, 20, Color.BLUE)
    )

    val builder = MatcherBuilder()
    builder {
        sidesEven()
        negativeSides()
        inAllowedRange()
        negativeLength()
        hasColor(Color.RED)
        hasAngles(10)
    }

    val res = shapes.filter { builder.buildAllMatchers().matches(it) }
    println(res)
}
