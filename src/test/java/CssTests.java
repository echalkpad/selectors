import Selectors.CssSelectors;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by juliay on 23-Dec-15
 */
public class CssTests extends CustomMethods
{
    static WebDriver driver;
    static CssSelectors selector;
    String startURL = "http://comments.azurewebsites.net/";

    @BeforeClass
    public static void setUp() {
		driver = new FirefoxDriver();
		selector = new CssSelectors(driver);
	}

    @Before
    public void beforeMethod()
    {
        driver.get(startURL);
    }

    @Test
    public void createComment()
    {
        //click on link New comment
        selector.linkCreateNewComment.click();
        waitForElementPresent(selector.fieldCommentText, driver, 5);

        //input something in field Comment Text
        selector.fieldCommentText.sendKeys("asdtest111");

        //mark first category
        selector.checkBoxAvailableCategories.get(0).click();

        //move chosen category in selected
        selector.moveChosenCategoryInSelect.click();

        //Click on save button
        selector.buttonSaveComment.click();
        waitForJQuery(driver);

        //open start page filtered Comments Text by increase
        driver.get(startURL + "?sort=Text&Text=ASC");

        //check that created comment appeared
        waitForElementPresent(selector.linkCreateNewComment, driver, 5);
        Assert.assertEquals("asdtest111", selector.allTDInCommentsText.get(0).getText());
    }

    @Test
    public void duplicateComment()
    {
        //selector = new CssSelectors(driver);
        //click on link New comment

        //save text first "text comment"
        String expName = selector.allTDInCommentsText.get(0).getText();

        //save category first "text comment"
        String expCategory = selector.allCategoriesInCommentsText.get(0).getText();

        //mark first "text comment"
        selector.allCheckBoxesCommentsText.get(0).click();

        //click on button duplicate
        selector.buttonDuplicateExistingComment.click();

        waitForElementPresent(selector.fieldCommentText, driver, 5);

        selector.fieldNumber.clear();

        //Click on save button
        selector.buttonSaveComment.click();
        waitForJQuery(driver);

        //open start page filtered Comments Text by increase
        driver.get(startURL + "?sort=Text&Text=DESC");

        //check that duplicated comment created with corresponding values
        waitForElementPresent(selector.linkCreateNewComment, driver, 5);
        Assert.assertEquals("Copy of" + expName, selector.allTDInCommentsText.get(0).getText());
        Assert.assertEquals(expCategory, selector.allCategoriesInCommentsText.get(0).getText());
    }

	@Test
	public void deleteComment()
	{
		//selector = new CssSelectors(driver);

		//save text first "text comment"
		String expName = selector.allTDInCommentsText.get(0).getText();

		//mark first "text comment"
		selector.allCheckBoxesCommentsText.get(0).click();

		//click on button delete
		selector.buttonDeleteExistingComment.click();

		waitForElementPresent(selector.textDialogWindow, driver, 5);
		Assert.assertEquals(
				"Are you sure you want to delete the selected item(s)?",
				selector.textDialogWindow.getText());

		//click on button confirm deleting
		selector.buttonsOnDialogWindow.get(0).click();
		waitForElementPresent(selector.textInfo, driver, 5);

		//check that deleted comment isn't shown
		Assert.assertEquals("Selected comments deleted successfull", selector.textInfo.getText());
		Assert.assertNotEquals(expName, selector.allTDInCommentsText.get(0).getText());
	}


	@Test
	public void editComment()
	{
		//mark first "text comment"
		selector.allCheckBoxesCommentsText.get(0).click();

		//click on button edit
		selector.buttonEditExistingComment.click();

		waitForElementPresent(selector.fieldCommentText, driver, 5);

		selector.fieldNumber.clear();

		selector.fieldCommentText.clear();
		selector.fieldCommentText.sendKeys("comment11111");

		//Click on save button
		selector.buttonSaveComment.click();
		waitForJQuery(driver);

		//open start page filtered Comments Text by increase
		driver.get(startURL + "?sort=Text&Text=DESC");

		//check that edited comment is displayed with corresponding values
		waitForElementPresent(selector.linkCreateNewComment, driver, 5);
		Assert.assertEquals("comment11111", selector.allTDInCommentsText.get(0).getText());
	}

	@Test
	public void refreshPage()
	{
		//click on link refresh
		waitForElementPresent(selector.linkRefreshPage, driver, 5);
		selector.linkRefreshPage.click();
		waitForJQuery(driver);

		waitForElementPresent(selector.linkCreateNewComment, driver, 5);
		Assert.assertTrue(selector.linkCreateNewComment.isDisplayed());

		//refresh page using driver
		driver.navigate().refresh();

		waitForElementPresent(selector.linkCreateNewComment, driver, 5);
		Assert.assertTrue(selector.linkCreateNewComment.isDisplayed());
	}

	@Test
	public void checkColorTitle()
	{
		//selector = new CssSelectors(driver);
		waitForElementPresent(selector.titlePage, driver, 5);
		String color = selector.titlePage.getCssValue("color");

		//check color title
		Assert.assertEquals("rgba(0, 0, 0, 1)", color);

	}







    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }



}
