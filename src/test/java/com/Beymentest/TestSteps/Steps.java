package com.Beymentest.TestSteps;

import com.Beymentest.Home.HomeTest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Steps extends HomeTest {

    String productPagePrice;
    String productBasketPrice;

    List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.
                until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public void enterKeyCheckbox(By by) {
        click(by);
        findElement(by).sendKeys(Keys.ENTER);
        System.out.println("ENTER tuşuna tıklandı.");
    }

    public void checkUrl(String text){
        String actualUrl;
        actualUrl = driver.getCurrentUrl();
        if(actualUrl != null && actualUrl.contains(text)){
            System.out.println("Bulunduğumuz link " + text + " değerini içermektedir.");
        }else{
            System.out.println("Bulunduğumuz link " + text + " değerini içermiyor.");
        }
    }

    public void chooseRandomElement(By by) {
        findElement(by);
        List<WebElement> elements = findElements(by);
        Random random = new Random();
        int index = random.nextInt(elements.size());
        elements.get(index).click();
    }

    public void getProductPagePrice(By by) {
        productPagePrice = findElement(by).getText();
        System.out.println("Ürün sayfasındaki fiyat: " + productPagePrice);
    }

    public void getProductBasketPrice(By by) {
        productBasketPrice = findElement(by).getText();
        System.out.println("Sepetteki fiyat: " + productBasketPrice);
    }

    public void priceEqualControl() {
        Assert.assertNotEquals(productBasketPrice, productPagePrice, "Ürün detay ile ürün sepet fiyatı farklı.");
        System.out.println("Ürün sayfasındaki fiyat ile sepetteki fiyat eşittir.");
    }

    public String readExcelSheet(Integer i, Integer j) throws IOException, InvalidFormatException {
        OPCPackage fis = OPCPackage.open(new File("BeymenSearch.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(i);
        Cell cell = row.getCell(j);
        return cell.getStringCellValue();
    }

    public void waitBySeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void writePriceToTxtFile(By productName, By productPrice) throws IOException {
        List<String> lines = Arrays.asList(getText(productName), getText(productPrice));
        Path file = Paths.get("BeymenPrice.txt");
        Files.write(file, lines, StandardCharsets.UTF_8);
    }

    public void clickIfExist(By by){
        try {
            if (findElements(by).size() > 0) {
                click(by);
            }
        }catch (Exception e){
            System.out.println("Beden seçimi yapılmadan devam edildi.");
        }
    }

}
