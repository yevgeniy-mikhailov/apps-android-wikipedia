package org.wikipedia.homeworks.hw06

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.hamcrest.TypeSafeMatcher


class IsInAllowedRange() : TypeSafeMatcher<Shape>() {
    private val allowedRange = 0.1f..100.0f
    override fun describeTo(description: Description) {
        description.appendText("allowedRange is $allowedRange")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideLength in allowedRange
    }
}

class HasColor(private val color: Color) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("color is $color")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.color == color
    }
}

class HasAnglesCount(private val angles: Int) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("angles count is $angles")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.getAnglesCount() == angles
    }
}

class SidesCountIsEven() : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sidesCount % 2 == 0
    }
}

class LengthIsNegative() : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("length is negative")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideLength > 0
    }
}

class SideCountIsNegative() : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("sidesCount is negative")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sidesCount > 0
    }
}

class MatcherBuilder() {
    private val listOfMatchers = mutableListOf<Matcher<Shape>>()
    operator fun invoke(function: MatcherBuilder.() -> Unit) {
        function()
    }

    fun negativeSides() {
        val detectedMatcher = SideCountIsNegative()
        listOfMatchers.add(detectedMatcher)
    }

    fun negativeLength() {
        listOfMatchers.add(LengthIsNegative())
    }

    fun sidesEven() {
        listOfMatchers.add(SidesCountIsEven())
    }

    fun hasAngles(angles: Int) {
        listOfMatchers.add(HasAnglesCount(angles))
    }

    fun hasColor(color: Color) {
        listOfMatchers.add(HasColor(color))
    }

    fun inAllowedRange() {
        listOfMatchers.add(IsInAllowedRange())
    }

    fun buildAllMatchers() = allOf(listOfMatchers)
    fun buildAnyOfMatchers() = anyOf(listOfMatchers)

}
