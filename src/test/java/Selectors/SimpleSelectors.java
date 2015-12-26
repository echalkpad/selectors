package Selectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Julia on 26.12.2015
 */
public class SimpleSelectors {

	public SimpleSelectors(WebDriver driver)
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

	@FindBy(id = "Text")
	public WebElement fieldCommentText;

	@FindBy(id = "msgText")
	public WebElement textDialogWindow;

	@FindBy(xpath = "//*[@id='dialog']/following-sibling::div//span")
	public List<WebElement> buttonsOnDialogWindow;

	@FindBy(id = "infoField")
	public WebElement textInfo;

	@FindBy(css = "[href='/']")
	public WebElement linkRefreshPage;

	@FindBy(id = "title")
	public WebElement titlePage;

	@FindBy(css = "[value='Save']")
	public WebElement buttonSaveComment;

	@FindBy(id = "Categories")
	public List<WebElement> checkBoxAvailableCategories;

	@FindBy(name = "CurSelect")
	public WebElement moveChosenCategoryInSelect;

	@FindBy(className = "textcolumn")
	public List<WebElement> allTDInCommentsText;

	@FindBy(className = "categorycolumn")
	public List<WebElement> allCategoriesInCommentsText;

	@FindBy(css = ".checkedcolumn>input[name='SelectedId']")
	public List<WebElement> allCheckBoxesCommentsText;

	@FindBy(id = "Number")
	public WebElement fieldNumber;

}
