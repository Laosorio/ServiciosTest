package org.example;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ServiciosMovilTest
{
    private static ChromeDriver driver;

    By linkMenu = By.cssSelector("div[class='mobmenul-container']");
    By linkServicios = By.linkText("Servicios");
    By divContainer = By.cssSelector("div[class='container content-wrapper']");
    private static utilSelenium util;

    @BeforeClass
    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Pixel 2 XL");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.choucairtesting.com/");
        util = new utilSelenium(driver);
    }

    @Test
    public void CP_008() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Controlar el tamaño del portal Para dispositivos móviles ");
        System.out.println("Pasos para Replicar");
        System.out.println("Paso 1.\t Abrir el portal en el dispositivo móvil");
        System.out.println("Paso 2.\t Click en el ícono del menú.");
        assertTrue(util.elementExists(linkMenu));
        util.doCLick(util.searchElement(linkMenu));
        Thread.sleep(2000);

        System.out.println("Paso 3.\t Damos clic en la opción “Servicios”");
        assertTrue(util.elementExists(linkServicios));
        util.doCLick(util.searchElement(linkServicios));
        Thread.sleep(2000);

        System.out.println("Paso 4.\t Verificar que el portal ocupe el 100% del ancho y alto de la pantalla móvil.");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        assertEquals( String.valueOf((long) executor.executeScript("return document.body.clientWidth;"))+"px", util.searchElement(divContainer).getCssValue("width"));
    }

    @Test
    public void CP_009() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Visualizar el contenido del portal de manera vertical para dispositivos móviles");
        System.out.println("Pasos para Replicar");
        System.out.println("Paso 1.\t Abrir el portal en el dispositivo móvil");
        System.out.println("Paso 2.\t Click en el ícono del menú.");
        assertTrue(util.elementExists(linkMenu));
        util.doCLick(util.searchElement(linkMenu));
        Thread.sleep(2000);

        System.out.println("Paso 3.\t Damos clic en la opción “Servicios”");
        assertTrue(util.elementExists(linkServicios));
        util.doCLick(util.searchElement(linkServicios));
        Thread.sleep(2000);

        System.out.println("Paso 4.\t Verificar la adaptabilidad del contenido en el dispositivo visualizando el contenido de manera verical");

        assertEquals( "block", util.searchElement(divContainer).getCssValue("display"));
    }
}
