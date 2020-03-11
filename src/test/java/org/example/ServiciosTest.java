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

public class ServiciosTest
{
    private static ChromeDriver driver;
    By linkServicios = By.linkText("Servicios");
    By imgServicios = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/2018/11/Banner-pag-interna.jpg.webp']");
    By divFooter = By.id("sidebar-footer");
    By aGoTop = By.cssSelector("a[class='go-top show']");
    By imgCapacidades = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/2018/10/investigacion.png']");
    By imgPortafolio = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/2018/10/presentacion.png']");
    By imgCursos = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/2018/09/Cursos.png']");
    By btnLeerMas = By.xpath("//a[@href='http://paginaweb.choucairtesting.com/?page_id=270'][@role='button']");
    By hNoDisponible = By.xpath("//h1[contains(text(),'No disponible')]");
    By btnCookies = By.xpath("//a[@class='medium cli-plugin-button cli-plugin-main-button cookie_action_close_header cli_action_button'][@role='button']");

    private static utilSelenium util;

    @BeforeClass
    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.choucairtesting.com/");
        util = new utilSelenium(driver);
    }

    @Test
    public void CP_001() throws InterruptedException {

        //Ofrecer en el menú principal del portal el módulo “Servicios"
        //"Pasos para Replicar"
        //"Paso 1.\t Verificamos la existencia del botón “Servicios”"
        assertTrue(util.elementExists(linkServicios));

        //"Paso 2.\t Damos clic en el botón “Servicios”"
        util.doCLick(util.searchElement(linkServicios));

        //"Paso 3.\t La plataforma nos lleva a la vista del menú “Servicios”"
        Thread.sleep(3000);
        assertTrue(util.isDisplayedElement(util.searchElement(imgServicios)));
        System.out.println("PRUEBA CP_001: Ha pasado con éxito.");
    }

    @Test
    public void CP_002() throws InterruptedException {
        //"Indicar la navegación en el menú “Servicios” por medio de un cambio visual."
        //"Pasos para Replicar"
        //"Paso 1.\t Verificamos la existencia del botón “Servicios”"
        assertTrue(util.elementExists(linkServicios));

        //"Paso 2.\t Pasamos el puntero por el link “Servicios"
        Actions action = new Actions(driver);
        WebElement we = util.searchElement(linkServicios);
        action.moveToElement(we).perform();
        //"Paso 3.\t La plataforma nos permite visualizar la transición de blanco a azul del botón."
        Thread.sleep(3000);
        assertEquals("rgba(43, 125, 225, 1)", we.getCssValue("color"));
        System.out.println("PRUEBA CP_002: Ha pasado con éxito.");
    }

    @Test
    public void CP_003() throws InterruptedException {
        util.doCLick(util.searchElement(linkServicios));
        Thread.sleep(3000);

        if(util.elementExists(btnCookies)) util.doCLick(util.searchElement(btnCookies));


        //"Ir al encabezado de la página por medio de una acción directa."
        //"Pasos para Replicar"
        //"Paso 1.\t Movemos el scroll como mínimo hasta el servicio Choucair “Capacidades”"
        WebElement we = util.searchElement(divFooter);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", we);
        Thread.sleep(2000);

        //"Paso 2.\t El portal activa el icono de la parte inferior derecha."
        assertTrue(util.elementExists(aGoTop));
        util.doCLick(util.searchElement(aGoTop));
        Thread.sleep(1000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        //"Paso 3.\t Damos clic al icono y la plataforma permite al usuario regresar al encabezado directamente"
        assertEquals(0, (long) executor.executeScript("return window.pageYOffset;"));
        System.out.println("PRUEBA CP_003: Ha pasado con éxito.");
    }

    @Test
    public void CP_004() throws InterruptedException {
        util.doCLick(util.searchElement(linkServicios));
        Thread.sleep(3000);

        //"Indicar la navegación en el menú “Servicios” por medio de un cambio visual."
        //"Pasos para Replicar"
        //"Paso 1.\t Verificamos la existencia de los accesos directos de los servicios como: “Capacidades”"
        assertTrue(util.elementExists(imgCapacidades));

        //"Paso 2.\t Pasamos el puntero por el icono 'Capacidades'"
        WebElement we = util.searchElement(imgCapacidades);
        Actions action = new Actions(driver);
        action.moveToElement(we).perform();
        //"Paso 3.\t El icono capacidades realiza una transición de Zoom."
        Thread.sleep(3000);
        assertEquals("matrix(1.1, 0, 0, 1.1, 0, 0)", we.getCssValue("transform"));
        System.out.println("PRUEBA CP_004: Ha pasado con éxito.");
    }

    @Test
    public void CP_006() throws InterruptedException {
        util.doCLick(util.searchElement(linkServicios));
        Thread.sleep(3000);

        //"Navegar en el portal por medio de los iconos de acceso directo"
        //"Pasos para Replicar"
        //"Paso 1.\t Damos clic en el icono “Capacidades”"
        assertTrue(util.elementExists(imgCapacidades));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        long scrollActual=  (long) executor.executeScript("return window.pageYOffset;");
        util.doCLick(util.searchElement(imgCapacidades));
        //"Paso 2.\t Nos direcciona en la misma página al contenido del servicio “Capacidades”"
        Thread.sleep(2000);

        assertNotEquals(scrollActual, (long) executor.executeScript("return window.pageYOffset;"));
        System.out.println("PRUEBA CP_006: Ha pasado con éxito.");
    }

    @Test
    public void CP_007() throws InterruptedException {
        util.doCLick(util.searchElement(linkServicios));
        Thread.sleep(3000);

        //"Verificar el contenido de “Cursos y Certificaciones” del portafolio de servicios ofrecido"
        //"Pasos para Replicar"
        //"Paso 1.\t Ubicarnos en el “portafolio de servicios”"
        assertTrue(util.elementExists(imgPortafolio));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        long scrollActual = (long) executor.executeScript("return window.pageYOffset;");
        util.doCLick(util.searchElement(imgPortafolio));
        Thread.sleep(2000);
        assertNotEquals(scrollActual, (long) executor.executeScript("return window.pageYOffset;"));

        //"Paso 2.\t Vamos al último ítem “Cursos y Certificaciones”"
        assertTrue(util.elementExists(imgCursos));
        scrollActual = (long) executor.executeScript("return window.pageYOffset;");
        util.doCLick(util.searchElement(imgCursos));
        Thread.sleep(2000);
        //"Paso 4.\t El portal nos direcciona en la misma página al contenido de “Cursos y Certificaciones”"
        assertNotEquals(scrollActual, (long) executor.executeScript("return window.pageYOffset;"));

        //"Paso 5.\t Al final de la información del ítem “Cursos y Certificaciones” se encuentra habilitado el botón “LEER MÁS”"
        assertTrue(util.elementExists(btnLeerMas));
        Thread.sleep(3000);
        //"Paso 6.\t Damos clic en el botón “LEER MÁS”"
        util.doCLick(util.searchElement(btnLeerMas));

        //"Paso 7.\t El sistema nos redirecciona a otra página con el contenido de “Cursos y Certificaciones”."
        assertFalse(util.elementExists(hNoDisponible));
        System.out.println("PRUEBA CP_007: Ha pasado con éxito.");
    }

}