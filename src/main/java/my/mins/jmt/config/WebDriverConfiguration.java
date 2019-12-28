package my.mins.jmt.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class WebDriverConfiguration implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
	}

	@Bean
	public WebDriver webDriver(){

		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/v1/login"); // 로그인 페이지로 이동 합니다.
		WebElement id = driver.findElement(By.name("username"));
		id.clear();
		id.sendKeys("minssogi"); // 아이디 입력 필드에 '아이디'를 입력 합니다.
		WebElement pw = driver.findElement(By.name("password"));
		pw.clear();
		pw.sendKeys("vlrmal1206!"); // 비빌번호 입력 필드에 '비밀번호'를 입력 합니다.
		WebElement button = driver.findElement(By.cssSelector(".btn.btn-default.submit"));
		button.submit(); // Form 전송.
		// Form 전송 후 로그인 완료 페이지로 이동하여 페이지가 완전히 랜더링 될 때 까지 대기 헙니다.
		//		new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("로그인 완료 URL"));
		//		new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>)d -> {
		//			assert d != null;
		//			return ((JavascriptExecutor) d).executeScript("return jQuery.active == 0").equals(Boolean.TRUE);
		//		});
		driver.get("https://gdtbgl93.tistory.com/"); // Scraping 할 페이지로 이동 합니다.
		System.out.println(driver.getPageSource()); // 페이지 소스를 Scraping 합니다.
		driver.quit(); // 브라우저 종료

		return driver;
	}
}
