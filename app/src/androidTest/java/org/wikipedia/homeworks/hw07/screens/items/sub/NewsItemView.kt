package org.wikipedia.homeworks.hw07.screens.items.sub

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsItemView(
    matcher: Matcher<View>
) : KRecyclerItem<Nothing>(matcher) {

    val text = KTextView(matcher) {
        withId(R.id.horizontal_scroll_list_item_text)
    }

    val image = KImageView(matcher) {
        withId(R.id.horizontal_scroll_list_item_image)
    }
}
