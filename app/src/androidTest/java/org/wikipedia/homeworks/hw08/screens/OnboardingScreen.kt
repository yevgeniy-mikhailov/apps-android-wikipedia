package org.wikipedia.homeworks.hw08.screens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object OnboardingScreen : KScreen<OnboardingScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val logo = KImageView {
        withId(R.id.imageViewCentered)
    }

    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }

    val continueButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }

    val pages = KViewPager2(builder = {
        withId(R.id.fragment_pager)
    }, itemTypeBuilder = {
        itemType(::LanguagePage)
    })
}
