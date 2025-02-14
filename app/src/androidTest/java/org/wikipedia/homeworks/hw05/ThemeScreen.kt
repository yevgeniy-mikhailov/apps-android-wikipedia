package org.wikipedia.homeworks.hw05

import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object TextZoom {
    val label = KTextView {
        withId(R.id.text_size_percent)
    }

    val switcher = KSeekBar {
        withId(R.id.text_size_seek_bar)
    }
}

object ReadingFocusMode {
    val toggle = KSwitch {
        withId(R.id.theme_chooser_reading_focus_mode_switch)
    }

    val description = KTextView {
        withId(R.id.theme_chooser_reading_focus_mode_description)
    }
}

val matchSystemThemeToggle = KSwitch {
    withId(R.id.theme_chooser_match_system_theme_switch)
}

val imageDimmingToggle = KSwitch {
    withId(R.id.theme_chooser_dark_mode_dim_images_switch)
}

object Themes {
    val light = KButton {
        withId(R.id.button_theme_light)
    }

    val sepia = KButton {
        withId(R.id.button_theme_sepia)
    }

    val dark = KButton {
        withId(R.id.button_theme_dark)
    }
    val black = KButton {
        withId(R.id.button_theme_black)
    }
}

object Fonts {
    val fontSensSerif = KButton {
        withId(R.id.button_font_family_sans_serif)
    }

    val fontSerif = KButton {
        withId(R.id.button_font_family_serif)
    }
}
