package TestCases;

import Utils.ExcelUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.util.List;

public class LoginTestWithXls {
    WebDriver driver;
    ExcelUtils excelUtils;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        excelUtils = new ExcelUtils("path/to/your/test-data.xlsx");
    }

    @Test
    public void testLogin() throws IOException {
        List<String[]> testData = excelUtils.readExcelData("Sheet1");
        for (String[] data : testData) {
            driver.get("https://example.com/login");
            driver.findElement(By.id("username")).sendKeys(data[0]);
            driver.findElement(By.id("password")).sendKeys(data[1]);
            driver.findElement(By.id("loginButton")).click();
            // Add assertions to verify login
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
