package Tests;

import ShareData.ShareData;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.WebTablesPage;

public class WebTableTest extends ShareData {

    HomePage homePage;
    CommonPage commonPage;
    WebTablesPage webTablesPage;

    @Test
    public void automationMethod() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        webTablesPage = new WebTablesPage(getDriver());

        homePage.goToDesiredMenu("Elements");

        commonPage.goToDesiredSubMenu("Web Tables");

        int initialTableSize = webTablesPage.getCurrentTableSize();

        webTablesPage.addNewRecord();

        webTablesPage.completeForm("Jane", "Doe", "jane.doe@gmail.com", "25",
                "9800", "Testing");

        webTablesPage.submitForm();

        int finalTableSize = webTablesPage.getCurrentTableSize();
        int expectedTableSize = initialTableSize + 1;
        Assert.assertEquals(finalTableSize, expectedTableSize);

        String actualTableValue = webTablesPage.getRowContentAsString(finalTableSize - 1);

        Assert.assertTrue(actualTableValue.contains("Jane"));
        Assert.assertTrue(actualTableValue.contains("Doe"));
        Assert.assertTrue(actualTableValue.contains("jane.doe@gmail.com"));
        Assert.assertTrue(actualTableValue.contains("25"));
        Assert.assertTrue(actualTableValue.contains("9800"));
        Assert.assertTrue(actualTableValue.contains("Testing"));
    }
}
