package org.wikipedia.makefun.fun01

import android.widget.LinearLayout
import androidx.test.espresso.assertion.PositionAssertions
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.views.AppTextView

val mainLogo = KImageView {
    withId(R.id.imageViewCentered)
}

val mainText = KTextView {
    withText(R.string.onboarding_welcome_title_v2)
    withId(R.id.primaryTextView)
    isInstanceOf(AppTextView::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val languageDescription = KTextView {
    withText(R.string.onboarding_multilingual_secondary_text)
}

fun main() {
}