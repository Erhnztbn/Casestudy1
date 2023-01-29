package com.Beymentest.Tests;

import com.Beymentest.TestSteps.Steps;
import org.junit.Test;

import static com.Beymentest.WebElements.HomeWebElement.*;
import static com.Beymentest.WebElements.OtherWebElement.*;
import static com.Beymentest.WebElements.ProductListWebElement.*;
import static com.Beymentest.WebElements.ProductWebElement.*;

public class TestSenaryosu extends Steps {
    @Test
    public void addProductToBasket() throws Exception {
        checkUrl("https://www.beymen.com/");
        click(cookie);
        chooseRandomElement(genderButtons);
        sendKeys(searchBar, readExcelSheet(0, 1));
        waitBySeconds(2);
        enterKeyCheckbox(searchBar);
        chooseRandomElement(productList);
        getProductPagePrice(productPriceAtProductPage);
        writePriceToTxtFile(productNameAtProductPage, productPriceAtProductPage);
        clickIfExist(productSizeNotDisabled);
        click(addBasket);
        click(basketButton);
        getProductBasketPrice(productBasketPrice);
        priceEqualControl();
        click(productQuantity);
        clickIfExist(quantityOptionTwo);
        click(removeItem);
        waitBySeconds(5);
    }
}