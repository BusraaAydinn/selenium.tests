package selenium.Workshop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.util.List;


public class SeleniumWorkshop1 {
    private static void waitForElementTextToBe(WebDriver webDriver, By completeCheckout, String thankYouForYourOrder, int i) {
    }
    private static String y;
    private static String x;

    public static void main(String[] args) throws InterruptedException {

        // 10 adet Selenium fonksiyonunu araştır ve yazı yaz.

        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.saucedemo.com/v1/");

        //maximize ---> tarayıcı penceresini tam ekran yapar.

        webDriver.manage().window().maximize();

        String title = webDriver.getTitle();
        System.out.println(title);

        WebElement usernameInput = webDriver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
        Thread.sleep(1000);

        WebElement passwordInput = webDriver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        Thread.sleep(1000);

        WebElement loginBtn = webDriver.findElement(By.id("login-button"));
        loginBtn.click();
        Thread.sleep(1000);


        // findElements ---> bir web sayfasında bulunan tüm elementleri göstermek için kullanılır.

        List<WebElement> products = webDriver.findElements(By.className("inventory_item"));
        for (WebElement product : products) {
            System.out.println(product.getText());
        }


        // scroll ---> bir web sayfasınnın belirli bir yönde ve belirli bir mesafe kadar jaydırmak için kullanılır.

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        Object o = js.executeScript("window.scrollBy(" + 0 + "," + 100 + ")");
        new JScrollBar();
        Thread.sleep(3000);


        // clickElement ---> belirli bir HTML öğesine (element) tıklamak için kullanılır.

        WebElement productLocator = webDriver.findElement(By.xpath("//*[@id=\"item_5_img_link\"]/img"));
        productLocator.click();
        Thread.sleep(3000);


        // navigate()back ---> bir önceki sayfaya dönmek için kullanılır.

        webDriver.navigate().back();
        Thread.sleep(2000);
        String currentUrl = webDriver.getCurrentUrl();
        System.out.println(currentUrl);

        JavascriptExecutor js1 = (JavascriptExecutor) webDriver;
        Object o1 = js.executeScript("window.scrollTo(" + 0 + "," + 0 + ")");
        new JScrollBar();
        Thread.sleep(3000);

        /*WebElement priceSortButton = webDriver.findElement(By.className("product_sort_container"));
        priceSortButton.click();
        List<WebElement> sortedProducts = webDriver.findElements(By.className("inventory_item_price"));
        System.out.println("Fiyat sıralaması yapıldı. İlk ürünün fiyatı: " + sortedProducts.get(0).getText());*/


        // isDisplayed ---> bir HTML öğesinin (elementin) görünür olup olmadığını kontrol etmek için kullanılır.

        WebElement addToChart = webDriver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[4]/div[3]/button"));
        addToChart.click();
        Thread.sleep(1000);

        WebElement goToChart = webDriver.findElement(By.id("shopping_cart_container"));
        if (goToChart.isDisplayed()){
            System.out.println("Button is visible");
            goToChart.click();
        }
        else {
            System.out.println("Button is not visible");
        }
        Thread.sleep(1000);


        WebElement clickCheckout = webDriver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]"));
        clickCheckout.click();
        Thread.sleep(1000);


        // sendKeys ---> belirli bir elemente değer göndermek için kullanılır.

        WebElement firstName = webDriver.findElement(By.id("first-name"));
        firstName.sendKeys("Büşra");
        Thread.sleep(1000);

        WebElement lastNameInput = webDriver.findElement(By.id("last-name"));
        lastNameInput.sendKeys("Aydın");
        Thread.sleep(1000);

        WebElement zipCodeInput = webDriver.findElement(By.id("postal-code"));
        zipCodeInput.sendKeys("12345");
        Thread.sleep(1000);

        WebElement continueButton = webDriver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input"));
        continueButton.click();
        Thread.sleep(1000);

        WebElement finishButton = webDriver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]"));
        finishButton.click();
        Thread.sleep(1000);


        //waitForElementTextToBe --->  belirli bir süre boyunca bir HTML elementinin metin içeriğini bekler. Metin içeriğini bulduktan sonra işlemlere devam eder.

        WebElement completeCheckout = webDriver.findElement(By.className("complete-header"));
        waitForElementTextToBe(webDriver, (By.className("complete-header")),"THANK YOU FOR YOUR ORDER", 10);
        System.out.println("Siparişiniz alındı");

        WebElement openMenu = webDriver.findElement(By.className("bm-burger-button"));
        openMenu.click();
        Thread.sleep(1000);

        WebElement logOut = webDriver.findElement(By.id("logout_sidebar_link"));
        logOut.click();
        Thread.sleep(1000);


        // refresh ---> ilgili sayfayı yeniler.

        webDriver.navigate().refresh();
        Thread.sleep(2000);


        // quit ---> ilgili tarayıcının kapanmasını sağlar.

        webDriver.quit(); // WebDriver'ı kapat
    }


}
