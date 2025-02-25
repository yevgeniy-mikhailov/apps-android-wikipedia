package org.wikipedia.homeworks.hw08

import androidx.compose.ui.test.hasText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.hw08.screens.AddLanguageItemView
import org.wikipedia.homeworks.hw08.screens.AddLanguageScreen
import org.wikipedia.homeworks.hw08.screens.LanguagePage
import org.wikipedia.homeworks.hw08.screens.LanguagePageItemView
import org.wikipedia.homeworks.hw08.screens.OnboardingScreen
import org.wikipedia.homeworks.hw08.screens.WikiLanguages
import org.wikipedia.homeworks.hw08.screens.WikiLanguagesRecycler
import org.wikipedia.main.MainActivity

class ExploreScreenTests : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkingLogoIsDisplayed() {
        run {
            step("Checking logo") {
                OnboardingScreen.logo.isDisplayed()
            }
        }
    }

    @Test
    fun continueButtonEnabledByDefault() {
        run {
            step("Checking that Continue button is enabled") {
                OnboardingScreen.continueButton.isDisplayed()
                OnboardingScreen.continueButton.isEnabled()
            }
        }
    }

    @Test
    fun checkingPrimaryText() {
        run {
            step("Referencing to the Language pager and checking primary text") {
                OnboardingScreen.pages.childAt<LanguagePage>(0) {
                    primaryText.hasText("The Free Encyclopedia")
                }
            }
        }
    }

    @Test
    fun checkingSecondaryText() {
        run {
            step("Referencing to the Language pager and checking secondary text") {
                OnboardingScreen.pages.childAt<LanguagePage>(0) {
                    secondaryText.hasText("We’ve found the following on your device:")
                }
            }
        }
    }

    @Test
    fun addRussianLanguage() {
        run {
            step("Open language list view") {
                OnboardingScreen.pages.childAt<LanguagePage>(0) {
                    addLanguagesButton.click()
                }
            }
            step("open wikipedia languages") {
                WikiLanguages.interactive.childAt<WikiLanguagesRecycler>(0) {
                    addLanguageButton.click()
                }
                step("Add new language to list") {
                    AddLanguageScreen.languageList.childAt<AddLanguageItemView>(2) {
                        click()
                    }
                    AddLanguageScreen.backButton.click()
                }
                WikiLanguages.backButton.click()
            }
            step("verify added new language") {
                OnboardingScreen.pages.childAt<LanguagePage>(0) {
                    languageList.childAt<LanguagePageItemView>(1) {
                        hasText("dfs")
                    }
                }
            }
        }
    }
}
