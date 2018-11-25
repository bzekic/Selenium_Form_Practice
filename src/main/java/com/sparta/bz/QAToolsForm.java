package com.sparta.bz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QAToolsForm {

    private WebDriver driver;
    private String qaToolsFormUrl = "http://toolsqa.com/automation-practice-form/";
    private By firstNameFieldId = By.name("firstname");
    private By lastNameFieldId = By.name("lastname");
    private String sexSelectorId = "sex-";
    private String yearsOfExperienceSelectorId = "exp-";
    private By dateInputFieldId = By.id("datepicker");
    private String professionSelectorId = "profession-";
    private By profilePictureUploadId = By.id("photo");
    private String automationToolSelectorId = "tool-";
    private By continentDropDownListId = By.id("continents");
    private By continentDropDownListOptionsCssSelector = By.cssSelector("#continents option");

    public QAToolsForm(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void goToQaFormPage() {
        driver.navigate().to(qaToolsFormUrl);
    }

    public void inputFirstName(String firstName) {
        driver.findElement(firstNameFieldId).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        driver.findElement(lastNameFieldId).sendKeys(lastName);
    }

    public void selectSexButton(String sex){
        if (sex.equalsIgnoreCase("male")){
            driver.findElement(By.id(sexSelectorId + 0)).click();
        }else if (sex.equalsIgnoreCase("female")){
            driver.findElement(By.id(sexSelectorId + 1)).click();
        }else {
            System.out.println("please select either 'male' or 'female'");
        }
    }

    public void selectYearsOfExperience(Integer num) {
        if (num >= 1 && num <= 7){
            driver.findElement(By.id(yearsOfExperienceSelectorId + (num - 1))).click();
        }else {
            System.out.println("please select a number between 1-7");
        }
    }

    public void inputDate(String date) {
        driver.findElement(dateInputFieldId).sendKeys(date);
    }

    public void selectProfession(String profession) {
        if (profession.equalsIgnoreCase("manual tester")){
            driver.findElement(By.id(professionSelectorId + 0)).click();
        }else if (profession.equalsIgnoreCase("automation tester")){
            driver.findElement(By.id(professionSelectorId + 1)).click();
        }else {
            System.out.println("please select either 'manual tester' or 'automation tester'");
        }
    }

    public void uploadPicture(String photoPath) {
        driver.findElement(profilePictureUploadId).sendKeys(photoPath);
    }

    public void selectAutomationTool(String tool) {
        if (tool.equalsIgnoreCase("qtp")){
            driver.findElement(By.id(automationToolSelectorId + 0)).click();
        }else if (tool.equalsIgnoreCase("selenium ide")){
            driver.findElement(By.id(automationToolSelectorId + 1)).click();
        }else if (tool.equalsIgnoreCase("selenium webdriver")){
            driver.findElement(By.id(automationToolSelectorId + 2)).click();
        }else {
            System.out.println("please select a valid tool");
        }
    }

    public void selectContinent(String continentName) {
        //Create list of continents from getContinentElementsAsStringList
        List<String> continents = getContinentElementsAsStringList();

        if (continents.contains(continentName)) {
            // You need to create a Select object but call the individual element that contains
            // If you check the drop down
            Select continentOptions = new Select(driver.findElement(continentDropDownListId));
            continentOptions.selectByVisibleText(continentName);
        } else if (!continents.contains(continentName)) {
            System.out.println("Please select one of the below options");

            for (String continent : continents) {
                System.out.println(continent);
            }
        }
    }

    // Continent drop down list management
    // Managing Continents elements and returning string list for cleaner management of objects
    private List<String> getContinentElementsAsStringList() {
        List<WebElement> continentOptions = driver.findElements( continentDropDownListOptionsCssSelector);
        List<String> continentsAsStringList = new ArrayList<>();

        for (WebElement continent : continentOptions) {
            continentsAsStringList.add(continent.getText());
        }
        return continentsAsStringList;
    }


    //    Method validators
    public boolean checkFirstNameField(String firstName){
        boolean selectedCorrectly;
        String names = driver.findElement(firstNameFieldId).getAttribute("value").trim();
        selectedCorrectly = names.equals(firstName);
        return selectedCorrectly;
    }

    public boolean checkLastNameField(String lastName){
         boolean selectedCorrectly;
         String names = driver.findElement(lastNameFieldId).getAttribute("value").trim();
         selectedCorrectly = names.equals(lastName);
         return selectedCorrectly;
    }

    public boolean checkSexSelected(String sex){
        boolean selectedCorrectly = false;
        if (sex.equalsIgnoreCase("male")){
            selectedCorrectly = driver.findElement(By.id(sexSelectorId + 0)).isSelected();
        }else if (sex.equalsIgnoreCase("female")){
            selectedCorrectly = driver.findElement(By.id(sexSelectorId + 1)).isSelected();
        }
        return selectedCorrectly;
    }

    public boolean checkNumberOfYearsSelected(Integer num){
        boolean selectedCorrectly;
        selectedCorrectly = driver.findElement(By.id(yearsOfExperienceSelectorId + (num - 1))).isSelected();
        return selectedCorrectly;
    }

    public boolean checkDate(String date){
        boolean selectedCorrectly;
        String dates = driver.findElement(dateInputFieldId).getAttribute("value").trim();
        selectedCorrectly = dates.equals(date);
        return selectedCorrectly;
    }

    public boolean checkProfessionSelected(String profession){
        boolean selectedCorrectly = false;
        if (profession.equalsIgnoreCase("manual tester")){
            selectedCorrectly = driver.findElement(By.id(professionSelectorId + 0)).isSelected();
        }else if (profession.equalsIgnoreCase("automation tester")){
            selectedCorrectly = driver.findElement(By.id(professionSelectorId + 1)).isSelected();
        }
        return selectedCorrectly;
    }

    public boolean checkTestTool(String tool){
        boolean selectedCorrectly = false;
        if (tool.equalsIgnoreCase("qtp")){
            selectedCorrectly = driver.findElement(By.id(automationToolSelectorId + 0)).isSelected();
        }else if (tool.equalsIgnoreCase("selenium ide")){
            selectedCorrectly = driver.findElement(By.id(automationToolSelectorId + 1)).isSelected();
        }else if (tool.equalsIgnoreCase("selenium webdriver")){
            selectedCorrectly = driver.findElement(By.id(automationToolSelectorId + 2)).isSelected();
        }
        return selectedCorrectly;
    }

    public boolean checkContinentValueSelected(String continentName){
        boolean selectedCorrectly;
        Select continentOptions = new Select(driver.findElement(continentDropDownListId));
        selectedCorrectly = continentOptions.getFirstSelectedOption().getText().equals(continentName);
        return selectedCorrectly;
    }
}