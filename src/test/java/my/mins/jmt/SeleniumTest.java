package my.mins.jmt;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
public class SeleniumTest {

	@Before
	public void before() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
	}
	@Test
	public void selenium_example() {
		WebDriver driver = new ChromeDriver(); // 브라우저 실행
		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin"); // 로그인 페이지로 이동 합니다.
		WebElement id = driver.findElement(By.id("id"));
		id.clear();
		id.sendKeys("msjeon529"); // 아이디 입력 필드에 '아이디'를 입력 합니다.
		WebElement pw = driver.findElement(By.id("pw"));
		pw.clear();
		pw.sendKeys("vlrmal1206!"); // 비빌번호 입력 필드에 '비밀번호'를 입력 합니다.
		WebElement button = driver.findElement(By.cssSelector("#login > form > fieldset > button"));
		button.submit(); // Form 전송.
		// Form 전송 후 로그인 완료 페이지로 이동하여 페이지가 완전히 랜더링 될 때 까지 대기 헙니다.
		new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("로그인 완료 URL"));
		new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>)d -> {
			assert d != null;
			return ((JavascriptExecutor) d).executeScript("return jQuery.active == 0").equals(Boolean.TRUE);
		});
		driver.get("Scraping 대상 URL"); // Scraping 할 페이지로 이동 합니다.
		System.out.println(driver.getPageSource()); // 페이지 소스를 Scraping 합니다.
		driver.quit(); // 브라우저 종료
	}
}
