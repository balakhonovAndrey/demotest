import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuranceTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.rgs.ru");

        WebElement element = driver.findElement(By.className("hidden-xs"));
        element.click();

        element = driver.findElement(By.xpath("//form[contains(@class, 'dropdown')]//a[contains(text(), 'ДМС')]"));
        element.click();

        element = driver.findElement(By.xpath("//div[contains(@class, 'header')]")); //А что дальше?

        element = driver.findElement(By.xpath("//a[contains(text(), 'Отправить')]"));
        element.click();

        element = driver.findElement(By.xpath("//b[contains(text(), 'Заявка')]")); //А что дальше?

        //ожидание формы
        WebElement dynamicElement = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='form-control']")));

        element = driver.findElement(By.xpath("//input[@name='LastName']"));
        element.sendKeys("Иванов");

        element = driver.findElement(By.xpath("//input[@name='FirstName']"));
        element.sendKeys("Иван");

        element = driver.findElement(By.xpath("//input[@name='MiddleName']"));
        element.sendKeys("Иванович");
    }


}
