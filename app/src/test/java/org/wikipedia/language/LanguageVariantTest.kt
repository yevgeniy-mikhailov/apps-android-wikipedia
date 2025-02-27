package org.wikipedia.language

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.wikipedia.WikipediaApp
import org.wikipedia.dataclient.WikiSite
import java.util.Locale

@RunWith(RobolectricTestRunner::class)
class LanguageVariantTest {

    /** Ensure that the more specific dialect is first in the list.  */
    @Test
    fun testDefaultLocaleAndAcceptLanguageAgree() {
        val defaultLocale = Locale.getDefault()
        val appLanguage = WikipediaApp.instance.languageState.appLanguageCode

        testDefaultLocaleAndAcceptLanguageAgree("zh,zh-Hant-TW;q=0.8", "zh", Locale.TRADITIONAL_CHINESE)
        testDefaultLocaleAndAcceptLanguageAgree("zh,zh-Hans-CN;q=0.8", "zh", Locale.SIMPLIFIED_CHINESE)
        testDefaultLocaleAndAcceptLanguageAgree("zh,en;q=0.8", "zh", Locale.US)
        testDefaultLocaleAndAcceptLanguageAgree("zh,en;q=0.8", "zh", Locale.ENGLISH)
        testDefaultLocaleAndAcceptLanguageAgree("en,zh-Hans-CN;q=0.8", "en", Locale.SIMPLIFIED_CHINESE)
        testDefaultLocaleAndAcceptLanguageAgree("test,zh-Hans-CN;q=0.8", "test", Locale.SIMPLIFIED_CHINESE)
        testDefaultLocaleAndAcceptLanguageAgree("es,zh-Hans;q=0.9,zh-Hant-TW;q=0.8", AppLanguageLookUpTable.SIMPLIFIED_CHINESE_LANGUAGE_CODE, Locale.TRADITIONAL_CHINESE, WikiSite.forLanguageCode("es"))
        testDefaultLocaleAndAcceptLanguageAgree("zh-Hant,zh-Hant-TW;q=0.8", AppLanguageLookUpTable.TRADITIONAL_CHINESE_LANGUAGE_CODE, Locale.TRADITIONAL_CHINESE)
        testDefaultLocaleAndAcceptLanguageAgree("zh-tw,zh-Hant-TW;q=0.9,en;q=0.7", AppLanguageLookUpTable.TRADITIONAL_CHINESE_LANGUAGE_CODE, Locale.US, WikiSite.forLanguageCode("zh-tw"))

        WikipediaApp.instance.languageState.setAppLanguageCodes(listOf(appLanguage))
        Locale.setDefault(defaultLocale)
    }

    private fun testDefaultLocaleAndAcceptLanguageAgree(expected: String, appLanguage: String, systemLocale: Locale, wiki: WikiSite? = null) {
        WikipediaApp.instance.languageState.setAppLanguageCodes(listOf(appLanguage))
        Locale.setDefault(systemLocale)
        MatcherAssert.assertThat(expected, Matchers.`is`(WikipediaApp.instance.getAcceptLanguage(wiki)))
    }
}
