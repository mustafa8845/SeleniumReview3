import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;

import java.util.concurrent.TimeUnit;

public class Day03_isDisplayed {

    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Ignore
    @Test
        public void isDisplayed(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
            WebElement baslik = driver.findElement(By.xpath("//*[.='Dynamic Controls']"));
            boolean gorunuyorMu = baslik.isDisplayed();
            System.out.println("Gorunuyor Mu?: "+ gorunuyorMu);
      }
      @Test
    public void isSelected(){
          driver.get("http://the-internet.herokuapp.com/dynamic_controls");

          WebElement secimElementi = driver.findElement(By.xpath("//input[@type='checkbox']\n" +
                "\n"));
          secimElementi.click();
          System.out.println("Secili mi?: "+ secimElementi.isSelected());
      }
      @Test
    public  void isEnabled(){

          driver.get("http://the-internet.herokuapp.com/dynamic_controls");
          WebElement inputKutusu = driver.findElement(By.xpath("//input[@type='text']"));
          System.out.println("Kullanilabiliyor mu?: "+ inputKutusu.isEnabled());

          WebElement button = driver.findElement(By.xpath("//*[.='Enable']"));
          button.click();

          try {
              Thread.sleep(4000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }

          System.out.println("Kullanilabiliyor mu?: "+ inputKutusu.isEnabled());


      }
}
