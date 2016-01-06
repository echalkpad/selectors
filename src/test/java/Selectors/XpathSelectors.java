package Selectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Julia on 26.12.2015
 */
public class XpathSelectors {

	public XpathSelectors(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='New...']")
	public WebElement linkCreateNewComment;

	@FindBy(xpath = "//input[@value='Duplicate...']")
	public WebElement buttonDuplicateExistingComment;

	@FindBy(xpath = "//input[@value='Edit...']")
	public WebElement buttonEditExistingComment;

	@FindBy(xpath = "//input[@value='Delete']")
	public WebElement buttonDeleteExistingComment;

	@FindBy(xpath = "//input[@id='Text']")
	public WebElement fieldCommentText;

	@FindBy(xpath = "//*[@id='msgText']")
	public WebElement textDialogWindow;

	@FindBy(xpath = "//*[@id='dialog']/following-sibling::div//span")
	public List<WebElement> buttonsOnDialogWindow;

	@FindBy(xpath = "//*[@id='infoField']")
	public WebElement textInfo;

	@FindBy(xpath = "//*[@href='/']")
	public WebElement linkRefreshPage;

	@FindBy(xpath = "//*[@id='title']")
	public WebElement titlePage;

	@FindBy(xpath = "//*[@value='Save']")
	public WebElement buttonSaveComment;

	@FindBy(xpath = "//*[@id='Categories']")
	public List<WebElement> checkBoxAvailableCategories;

	@FindBy(xpath = "//*[@name='CurSelect']")
	public WebElement moveChosenCategoryInSelect;

	@FindBy(xpath = "//*[@class='textcolumn']")
	public List<WebElement> allTDInCommentsText;

	@FindBy(xpath = "//*[@class='categorycolumn']")
	public List<WebElement> allCategoriesInCommentsText;

	@FindBy(xpath = "//*[@class='checkedcolumn']//input[@name='SelectedId']")
	public List<WebElement> allCheckBoxesCommentsText;

	@FindBy(xpath = "//*[@id='Number']")
	public WebElement fieldNumber;
	/**********************************************************new*******************************************/

	@FindBy(xpath = "//*[@class='numbercolumn']")
	public List<WebElement> infoNumberComment;

	@FindBy(xpath = "//a[contains(text(), '>')]")
	public WebElement linkToNextPage;


}
