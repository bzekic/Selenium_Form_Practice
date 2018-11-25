package com.sparta.bz;

import org.openqa.selenium.chrome.ChromeDriver;

public class App
{
    public static void main( String[] args )
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\TECH-W91\\Downloads\\chromedriver_win32\\chromedriver.exe");

        ChromeDriver chromeDriver = new ChromeDriver();
        QAToolsForm qaToolsForm = new QAToolsForm(chromeDriver);

        qaToolsForm.goToQaFormPage();
        qaToolsForm.inputFirstName("boris");
        qaToolsForm.inputLastName("zekic");
        qaToolsForm.selectSexButton("male");
        qaToolsForm.selectYearsOfExperience(2);
        qaToolsForm.inputDate("12/11/18");
        qaToolsForm.selectProfession("automation tester");
        qaToolsForm.uploadPicture("C:\\Users\\TECH-W91\\Downloads\\20180927_102648.jpg");
        qaToolsForm.selectAutomationTool("selenium webdriver");
        qaToolsForm.selectContinent("Europe");

        System.out.println(qaToolsForm.checkFirstNameField("boris"));
        System.out.println(qaToolsForm.checkLastNameField("zekic"));
        System.out.println(qaToolsForm.checkSexSelected("male"));
        System.out.println(qaToolsForm.checkNumberOfYearsSelected(2));
        System.out.println(qaToolsForm.checkDate("12/11/18"));
        System.out.println(qaToolsForm.checkProfessionSelected("automation tester"));
        System.out.println(qaToolsForm.checkTestTool("selenium webdriver"));
        System.out.println(qaToolsForm.checkContinentValueSelected("Europe"));
    }
}
