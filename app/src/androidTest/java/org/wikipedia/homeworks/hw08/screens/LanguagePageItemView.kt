package org.wikipedia.homeworks.hw08.screens

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class LanguagePageItemView(
    matcher: Matcher<View>
) : KRecyclerItem<LanguagePageItemView>(matcher) {
    val title = KTextView(matcher) {
        withId(R.id.option_label)
    }

}
