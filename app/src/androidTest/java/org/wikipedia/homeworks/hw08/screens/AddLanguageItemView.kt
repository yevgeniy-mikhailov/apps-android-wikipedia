package org.wikipedia.homeworks.hw08.screens

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class AddLanguageItemView(
    matcher: Matcher<View>
) : KRecyclerItem<AddLanguageItemView>(matcher) {
    val item = KTextView(matcher) {
        withId(R.id.option_label)
    }


}