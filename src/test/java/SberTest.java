import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SberTest {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebElement element = null, dynamicElement = null;

        //1. Перейти на страницу http://www.sberbank.ru/ru/person
        driver.navigate().to("http://www.sberbank.ru/ru/person");

        //2. Нажать на кнопку выбора региона
        dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .className("hd-ft-region__title")));

        dynamicElement.click();

        //3. В появившемся «окне» при помощи поиска найти и выбрать Нижегородская область
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='kit-grid-modal__window']")));


        element = driver.findElement(By.xpath("//input[@class='kit-input__control' and @type='search']"));
        element.sendKeys("Нижегородская область");

        dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//a[@class='kit-link kit-link_m hd-ft-region__city']")));
        dynamicElement.click();

        //4. Проверить, что на главной странице отображается выбранная область
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .className("hd-ft-region__title")));

        if (driver.findElement(By.xpath("//div[@class='hd-ft-region__title']/span")).getText().equals("Нижегородская область")) {
            System.out.println("на главной странице отображается выбранная область");
        } else {
            System.out.println("выбранная область не отображается");
        }

        //5. Сделать скролл до footer объекта на главной странице.
        element = driver.findElement(By.xpath("//div[@class='footer']"));
        //6. Проверить, что footer содержит значки социальных сетей
        if (driver.findElement(By.xpath("//ul[@class='footer__social']")).isDisplayed()) {
            System.out.println("значки социальных сетей видны");
        }

        driver.quit();
    }
}
