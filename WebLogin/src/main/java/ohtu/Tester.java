package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String url = "http://localhost:4567";
        
        // epäonnistunut kirjautuminen: oikea käyttäjätunnus, väärä salasana
        
        driver.get(url);
        sleep(1);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        sleep(1);
                element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("kimmokala");
        element = driver.findElement(By.name("login"));
        
        sleep(1);
        element.submit();

        sleep(2);
 
        // epäonnistunut kirjautuminen: ei-olemassaoleva käyttäjätunnus
        
        driver.get(url);
        sleep(1);
        element = driver.findElement(By.linkText("login"));
        element.click();
        sleep(1);
        element = driver.findElement(By.name("username"));
        element.sendKeys("petteri");
        element = driver.findElement(By.name("password"));
        element.sendKeys("irettep");
        element = driver.findElement(By.name("login"));
        
        sleep(1);
        element.submit();

        sleep(2);
        
        // uuden käyttäjätunnuksen luominen
        Random r = new Random();
        
        driver.get(url);
        sleep(1);
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(1);
        element = driver.findElement(By.name("username"));
        element.sendKeys("petteri"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("09irettep");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("09irettep");
        element = driver.findElement(By.name("signup"));
        sleep(1);
        element.submit();
        sleep(2);
        
        // uuden käyttäjätunnuksen luomisen jälkeen tapahtuva ulkoskirjautuminen sovelluksesta
        driver.get(url);
        sleep(1);
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(1);
        element = driver.findElement(By.name("username"));
        element.sendKeys("petteri"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("09irettep");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("09irettep");
        element = driver.findElement(By.name("signup"));
        sleep(1);
        element.submit();
        sleep(2);
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(2);
        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(2);
        
        driver.quit();
        
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
