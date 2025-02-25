package org.wikipedia.homeworks.hw08.screens

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher
import org.wikipedia.R

class WikiLanguagesRecycler(
    matcher: Matcher<View>
) : KRecyclerItem<WikiLanguagesRecycler>(matcher) {
    val addLanguageButton = KButton(matcher) {
        withParent { }
        withId(R.id.wiki_language_title)
    }

    val languageList = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.wikipedia_languages_recycler)
        }, itemTypeBuilder = {
            itemType(::WikiLanguagesItemView)
        })
}