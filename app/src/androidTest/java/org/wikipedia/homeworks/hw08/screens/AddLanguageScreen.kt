package org.wikipedia.homeworks.hw08.screens

import androidx.appcompat.widget.AppCompatImageButton
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object AddLanguageScreen : KScreen<AddLanguageScreen>() {

    val languageList = KRecyclerView(builder = {
        withId(R.id.languages_list_recycler)
    }, itemTypeBuilder = {
        itemType(::AddLanguageItemView)
    })
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val backButton = KButton {
        isInstanceOf(AppCompatImageButton::class.java)
        withParent {
            withId(androidx.appcompat.R.id.action_bar)
        }
    }
}