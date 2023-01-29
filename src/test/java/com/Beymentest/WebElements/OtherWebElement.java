package com.Beymentest.WebElements;

import org.openqa.selenium.By;
public class OtherWebElement {
    public static final By productBasketPrice = By.cssSelector("div.m-productPrice__content > span");
    public static final By productQuantity = By.cssSelector("div.m-basket__quantity");
    public static final By quantityOptionTwo = By.cssSelector("div.m-basket__quantity > div > select > option[value='2']");
    public static final By removeItem = By.cssSelector("div.m-basket__optionHeader > button");
}
