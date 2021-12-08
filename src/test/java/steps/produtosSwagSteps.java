package steps;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class produtosSwagSteps {

    WebDriver driver;
    String url = "https://www.saucedemo.com/";
    String usuario = "standard_user";
    String senha = "secret_sauce";
    String urlProduto = "https://www.saucedemo.com/inventory-item.html?id=4";
    String urlObtida;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Dado("o usuario esta na pagina de produtos do site")
      public void o_usuario_esta_na_pagina_de_produtos_do_site(){

        driver.get(url);
        driver.findElement(By.id("user-name")).sendKeys(usuario);
        driver.findElement(By.id("password")).sendKeys(senha);
        driver.findElement(By.id("login-button")).click();
    }
    @Quando("ele clica no produto escolhido")
      public void ele_clica_no_produto_escolhido() {
        driver.findElement(By.className("inventory_item_img")).click();
    }

    @Entao("a pagina do produto é exibida")
    public void a_pagina_do_produto_é_exibida() {
        urlObtida = driver.getCurrentUrl();
        Assert.assertEquals(urlObtida, urlProduto);
    }
    @After
    public void pare() {
        driver.close();
    }
}