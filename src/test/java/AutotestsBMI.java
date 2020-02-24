import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AutotestsBMI {
    @Test
    public void categoryNormal() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("54");
        browser.findElement(By.name("ht")).sendKeys("163");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Normal", "Категория верная");
        System.out.println(category);
        browser.quit();
    }
    @Test
    public void categoryOverweigth() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("100");
        browser.findElement(By.name("ht")).sendKeys("163");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Obese", "Категория верная");
        System.out.println(category);
        browser.quit();
    }
    @Test
    public void categoryStarvation() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("45");
        browser.findElement(By.name("ht")).sendKeys("185");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Starvation", "Категория верная");
        System.out.println(category);
        browser.quit();

    }
    @Test
    public void checkMinWeightAlert() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("10");
        browser.findElement(By.name("ht")).sendKeys("185");
        browser.findElement(By.name("cc")).click();
        // browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String alerttext = browser.switchTo().alert().getText();
        assertEquals(alerttext, "Weight should be greater than 10kgs", "Введено значение меньше допустимого");
        System.out.println(alerttext);
        browser.switchTo().alert().accept();
        browser.quit();
    }

    @Test
    public void minWeight() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("11");
        browser.findElement(By.name("ht")).sendKeys("185");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Starvation", "Введёно граничное значение - отрабатывает корректно ");
        System.out.println(category);
        browser.quit();
    }
    @Test
    // тест падает, т.к. минимальное значение вводимое в поле должно быть 34, в реальности это 33. При вводе 33 не отображается предупреждающее окно
    public void checkMinHeightAlert() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("50");
        browser.findElement(By.name("ht")).sendKeys("33");
        browser.findElement(By.name("cc")).click();
        // browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String alerttext = browser.switchTo().alert().getText();
        assertEquals(alerttext, "Height should be taller than 33cms", "Введено значение меньше допустимого");
        System.out.println(alerttext);
        browser.switchTo().alert().accept();
        browser.quit();
    }



}
