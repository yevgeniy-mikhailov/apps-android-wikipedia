package org.wikipedia.homeworks.hw07.screens.items

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class AnnouncementCardViewItem(
    matcher: Matcher<View>
) : KRecyclerItem<AnnouncementCardViewItem>(matcher) {

    val image = KImageView(matcher) {
        withId(R.id.view_announcement_header_image)
    }

    val customizeButton = KButton(matcher) {
        withId(R.id.view_announcement_text)
    }

    val gotItButton = KButton(matcher) {
        withId(R.id.view_announcement_action_negative)
    }

    val text = KTextView(matcher) {
        withId(R.id.view_announcement_text)
    }
}
