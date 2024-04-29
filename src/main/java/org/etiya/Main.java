package org.etiya;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // 1. #navigate ile bir siteyi ziyaret etme.

        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.saucedemo.com/v1/");


        // 2. #aşağıdaki ifade kullanılarak ekran büyütülür.

        webDriver.manage().window().maximize();


        // 3. #findElement belirtilen seçim aracını (bu örnekte By) kullanarak bir web elementi bulur.

        WebElement userNameInput = webDriver.findElement(By.id("user-name"));

        // 4. sendKeys bir web elemente metin girişi yapar.

        userNameInput.sendKeys("standard_user");
        Thread.sleep(1000);

        //  5. #clear input alanının içeriğini temizler.
        userNameInput.clear();
        Thread.sleep(1000);

        //burada input temizlendikten sonra giriş yapabilmek için verileri tekrar giriyorum.

        userNameInput.sendKeys("standard_user");
        Thread.sleep(1000);

        WebElement passwordinput = webDriver.findElement(By.id("password"));
        passwordinput.sendKeys("secret_sauce");
        Thread.sleep(1000);

        WebElement loginButton = webDriver.findElement(By.id("login-button"));


        // 6. #click tıklama işlemini gerçekleştirir.

        loginButton.click();
        Thread.sleep(3000);

        // 7. #getText seçilen elementin metnini alır.

        WebElement firstItemName = webDriver.findElement(By.className("inventory_item_name"));
        String text = firstItemName.getText();
        System.out.println("Ürün Adı: " + text);


        // Burada bir ürün başlığına tıklayıp detay sayfasına gidiyorum.

        WebElement firstItem = webDriver.findElement(By.id("item_4_title_link"));
        firstItem.click();
        Thread.sleep(2000);


        // 8. #navigate.back ile bir önceki sayfaya gidilir.

        webDriver.navigate().back();
        Thread.sleep(2000);


        // Burada xpath kullanarak find element ile sepete ürün ekliyorum. Sonrasında id kullanarak sepete gidiyorum.
        WebElement addToCartButton = webDriver.findElement(By.xpath("//*[@id='inventory_container']/div/div[1]/div[3]/button"));
        addToCartButton.click();
        Thread.sleep(2000);
        WebElement cartButton = webDriver.findElement(By.id("shopping_cart_container"));
        cartButton.click();
        Thread.sleep(2000);

        // 9. #isEnabled kullanarak checkout butonunun aktifliğini kontrol etme.

        WebElement checkoutEnable = webDriver.findElement(By.className("checkout_button"));
        if (checkoutEnable.isEnabled()) {
            System.out.println("Checkout Button is enabled.");
        } else {
            System.out.println("Checkout Button is disabled.");
        }

        // 10. #quit kullanarak sayfayı kapatma.

        webDriver.quit();}
}
