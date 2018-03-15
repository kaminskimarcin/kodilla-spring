package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_SELECT_CLASS = "//div[@class=\"_5k_5\"]";
    public static final String XPATH_SELECT_DAY = "//span[@class=\"_5k_4\"]/span/select[1]";
    public static final String XPATH_SELECT_MONTH= "//span[@class=\"_5k_4\"]/span/select[2]";
    public static final String XPATH_SELECT_YEAR = "//span[@class=\"_5k_4\"]/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        while(!driver.findElement(By.xpath(XPATH_SELECT_CLASS)).isDisplayed());

        WebElement selectDay = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select daySelect = new Select(selectDay);
        daySelect.selectByValue("20");

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select monthSelect = new Select(selectMonth);
        monthSelect.selectByVisibleText("mar");

        WebElement selectYear = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select yearSelect = new Select(selectYear);
        yearSelect.selectByValue("2000");
    }
}