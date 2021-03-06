import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InsuranceTest {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        //Перейти по ссылке http://www.rgs.ru
        driver.navigate().to("http://www.rgs.ru");

        //Выбрать пункт меню
        WebElement element = driver.findElement(By.className("hidden-xs"));
        element.click();

        //Выбрать категорию - ДМС
        element = driver.findElement(By.xpath("//form[contains(@class, 'dropdown')]//a[contains(text(), 'ДМС')]"));
        element.click();

//      Проверить наличие заголовка - Добровольное медицинское страхование
        element = driver.findElement(By.xpath("//h1[@class= 'content-document-header']"));
        if (element.getText().equals("Добровольное медицинское страхование")) {
            System.out.println("Проверка текста заголовка (Добровольное медицинское страхование)");
            System.out.println("Заголовок: " + element.getText());
        } else {
            System.out.println("У заголовка другой текст: " + element.getText());
        }

        //Нажать на кнопку - Отправить заявку
        element = driver.findElement(By.xpath("//a[contains(text(), 'Отправить')]"));
        element.click();

        //ожидание формы
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modals-container']")));

        //Проверить, что открылась страница , на которой присутствует текст
        // - Заявка на добровольное медицинское страхование
        element = driver.findElement(By.xpath("//b[@data-bind= 'text: options.title']"));
        if (element.getText().equals("Заявка на добровольное медицинское страхование")) {
            System.out.println("Проверка текста заголовка (Заявка на добровольное медицинское страхование)");
            System.out.println("Текст: " + element.getText());
        } else {
        System.out.println("У заголовка другой текст: " + element.getText());
    }


        //Заполнить поля
        element = driver.findElement(By.xpath("//input[@name='LastName']"));
        element.sendKeys("Иванов");

        element = driver.findElement(By.xpath("//input[@name='FirstName']"));
        element.sendKeys("Иван");

        element = driver.findElement(By.xpath("//input[@name='MiddleName']"));
        element.sendKeys("Иванович");

        element = driver.findElement(By.xpath("//select[@name='Region']"));
        element = driver.findElement(By.xpath("//option[@value='78']"));
        element.click();

        element = driver.findElement(By.xpath("//input[@type='text' and @class='form-control']"));
        element.sendKeys("+7(999)123-45-67");

        element = driver.findElement(By.xpath("//input[@name='Email']"));
        element.sendKeys("qwertyqwerty");

        element = driver.findElement(By.xpath("//input[@name='ContactDate']"));
        element.click();
        element = driver.findElement(By.xpath("//span[contains(text(), 'Октябрь')]"));
        element.click();
        element = driver.findElement(By.xpath("//td[@data-datepicker-timestamp='1572480000000']"));
        element.click();

        element = driver.findElement(By.xpath("//input[@class='checkbox']"));
        element.click();

        element = driver.findElement(By.xpath("//textarea[@name='Comment']"));
        element.sendKeys("Тестирование...");
//======================================================================================================================
        //Проверить, что все поля заполнены введенными значениями
        element = driver.findElement(By.xpath("//input[@name='LastName']"));
        if (element.getText().equals("Иванов")) {
            System.out.println("Фамилия: " + element.getText());
        } else {
            System.out.println("В поле фамилия находится другой текст");
        }

        element = driver.findElement(By.xpath("//input[@name='FirstName']"));
        if (element.getText().equals("Иван")) {
            System.out.println("Имя: " + element.getText());
        } else {
            System.out.println("В поле имя находится другой текст");
        }

        element = driver.findElement(By.xpath("//input[@name='MiddleName']"));
        if (element.getText().equals("Иванович")) {
            System.out.println("Отчество: " + element.getText());
        } else {
            System.out.println("В поле отчество находится другой текст");
        }

        element = driver.findElement(By.xpath("//input[@type='text' and @class='form-control validation-control-has-success']"));
        if (element.getText().equals("+7(999)123-45-67")) {
            System.out.println("Телефон: " + element.getText());
        } else {
            System.out.println("В поле телефон находится другой текст");
        }

        element = driver.findElement(By.xpath("//input[@name='Email']"));
        if (element.getText().equals("qwertyqwerty")) {
            System.out.println("Email: " + element.getText());
        } else {
            System.out.println("В поле email находится другой текст");
        }

        element = driver.findElement(By.xpath("//textarea[@name='Comment']"));
        if (element.getText().equals("Тестирование...")) {
            System.out.println("Комментарий: " + element.getText());
        } else {
            System.out.println("В поле комментарий находится другой текст");
        }

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//======================================================================================================================
        //Нажать Отправить
        element = driver.findElement(By.xpath("//button[contains(text(), 'Отправить')]"));
        element.click();

        //Проверить, что у Поля - Эл. почта присутствует сообщение об ошибке - Введите корректный email
        element = driver.findElement(By.xpath("//span[@class='validation-error-text']"));
        if (element.isDisplayed()) {
            System.out.println("Выведенно сообщение об ошибке -> " + element.getText());
        }

        driver.quit();
    }


}