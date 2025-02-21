package org.wikipedia.homeworks.hw07.screens.items

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class DayHeaderCardViewItem(
    matcher: Matcher<View>
) : KRecyclerItem<DayHeaderCardViewItem>(matcher) {

    val date = KTextView(matcher) {
        withId(R.id.day_header_text)
    }
}
