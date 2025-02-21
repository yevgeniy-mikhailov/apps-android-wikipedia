package org.wikipedia.homeworks.hw07.screens.items

import android.view.View
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class SearchCardViewItem(
    matcher: Matcher<View>
) : KRecyclerItem<SearchCardViewItem>(matcher) {

    val searchIcon = KImageView(matcher) {
        withDrawable(R.drawable.ic_search_white_24dp)
    }

    val searchInput = KTextView(matcher) {
        isInstanceOf(MaterialTextView::class.java)
    }

    val voiceButton = KImageView(matcher) {
        withId(R.id.voice_search_button)
    }
}
