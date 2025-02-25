package org.wikipedia.homeworks.hw08.screens

import androidx.appcompat.widget.AppCompatImageButton
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object WikiLanguages : KScreen<WikiLanguages>() {

    val backButton = KButton {
        isInstanceOf(AppCompatImageButton::class.java)
        withParent {
            withId(R.id.toolbar)
        }
    }

    val interactive = KRecyclerView(
        builder = {
            withId(R.id.wikipedia_languages_recycler)
        }, itemTypeBuilder = {
            itemType(::WikiLanguagesRecycler)
        })
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null
}