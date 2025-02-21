package org.wikipedia.homeworks.hw07.screens.items

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.feed.news.NewsCardView
import org.wikipedia.homeworks.hw07.screens.items.sub.NewsItemView

class NewsCardViewItem(
    matcher: Matcher<View>
) : KRecyclerItem<NewsCardViewItem>(matcher) {

    val headerTitle = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val moreTopRead = KTextView(matcher) {
        withId(R.id.footerActionButton)
    }

    val items = KRecyclerView(
        parent = matcher,
        builder = {
            isInstanceOf(NewsCardView::class.java)
        },
        itemTypeBuilder = {
            itemType(::NewsItemView)
        }
    )
}
