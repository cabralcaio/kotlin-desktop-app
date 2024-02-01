import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Playwright
import kotlinx.coroutines.delay

class Automation {
    suspend fun start(){
        val browser = createBrowser()
        val page = browser.newPage()
        page.navigate("https://kotlinlang.org/")
        delay(1000)
        page.locator(".ktl-search-button-module_button_YHJPv").click()
        delay(2000)
        page.locator("._inner_1fowpgw_171").fill("Searching for Kotlin using automation")
        delay(5000)
        browser.close()
    }

    private fun createBrowser(): Browser{
        val playwright = Playwright.create()
        val launchOptions = BrowserType.LaunchOptions().apply {
            setHeadless(false)
        }
        val browser = playwright.chromium().launch(launchOptions)
        return browser
    }
}