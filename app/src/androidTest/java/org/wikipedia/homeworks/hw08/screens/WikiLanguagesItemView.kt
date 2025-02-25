package org.wikipedia.homeworks.hw08.screens

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class WikiLanguagesItemView(
    matcher: Matcher<View>
) : KRecyclerItem<WikiLanguagesItemView>(matcher) {
    val title = KTextView(matcher) {
        withId(R.id.localized_language_name)
    }

    val subTitle = KTextView(matcher) {
        withId(R.id.language_subtitle)
    }
}
