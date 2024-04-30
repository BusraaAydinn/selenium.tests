package org.etiya;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.awt.SystemColor.text;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Bir kullanıcı olarak ben adım adım nasıl yapıyorum?
        //Görüntü => HTML

        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.saucedemo.com/v1/");

        //maximize ---> tarayıcı penceresini tam ekran yapar.

        webDriver.manage().window().maximize();

        String title = webDriver.getTitle();
        System.out.println(title);

        // Locator => HTML deki bir elemente ulaşmak için gereklidir.
        // //*[@id="login_button_container"]/div/form --- ilgili alanın adresini verir.(Xpath)
        // /html/body/div[2]/div[1]/div/div/form --- bu alana gelene kadar üm xml sırasını verir.(Full Xpath)

        WebElement usernameInput = webDriver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
        Thread.sleep(1000);

        WebElement passwordInput = webDriver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        Thread.sleep(1000);

        WebElement loginBtn = webDriver.findElement(By.id("login-button"));
        loginBtn.click();
        Thread.sleep(1000);

        //--------------------------------------------------------------------------------------------------------//
    }
}