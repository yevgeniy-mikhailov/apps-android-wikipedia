package org.wikipedia.homeworks.hw03

import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import org.wikipedia.views.AppTextView

val skipButton = listOf(
    MaterialButton::class.java, "fragment_onboarding_skip_button", "onboarding_skip"
)

val continueButton = listOf(
    MaterialButton::class.java, "fragment_onboarding_forward_button", "onboarding_continue"
)
val addLanguagesButton = listOf(
    MaterialButton::class.java, "addLanguageButton", "onboarding_multilingual_add_language_text"
)

val primaryText = listOf(
    AppTextView::class.java, "primaryTextView", null
)

val secondaryText = listOf(
    AppTextView::class.java, "secondaryTextView", null
)

val imageView = listOf(
    AppCompatImageView::class.java, "imageViewCentered", null
)

val recyclerView = listOf(
    RecyclerView::class.java, "languagesList", null
)

val slidingTabIndicator = listOf(
    TabLayout::class.java, "view_onboarding_page_indicator", null
)
