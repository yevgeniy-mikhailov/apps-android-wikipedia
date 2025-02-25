package org.wikipedia.homeworks.hw08.screens

import android.view.View
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class LanguagePage(matcher: Matcher<View>) : KViewPagerItem<LanguagePage>(matcher) {

    val addLanguagesButton = KButton(matcher) {
        withId(R.id.addLanguageButton)
    }

    val primaryText = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }
    val secondaryText = KTextView(matcher) {
        withId(R.id.secondaryTextView)
    }

    val languageList = KRecyclerView(
        builder = {
            withId(R.id.languageList)
        }, itemTypeBuilder = {
            itemType(::LanguagePageItemView)
        })
}
