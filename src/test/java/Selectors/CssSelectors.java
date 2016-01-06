package Selectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by juliay on 23-Dec-15
 */
public class CssSelectors {

    public CssSelectors(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[value='New...']")
    public WebElement linkCreateNewComment;

    @FindBy(css = "[value='Duplicate...']")
    public WebElement buttonDuplicateExistingComment;

	@FindBy(css = "[value='Edit...']")
	public WebElement buttonEditExistingComment;

	@FindBy(css = "[value='Delete']")
	public WebElement buttonDeleteExistingComment;

    @FindBy(css = "#Text")
    public WebElement fieldCommentText;

	@FindBy(css = "#msgText")
	public WebElement textDialogWindow;

	@FindBy(css = "span[class*=\"button-text\"]")
	public List<WebElement> buttonsOnDialogWindow;

	@FindBy(css = "#infoField")
	public WebElement textInfo;

	@FindBy(css = "[href='/']")
	public WebElement linkRefreshPage;

	@FindBy(css = "#title")
	public WebElement titlePage;

    @FindBy(css = "[value='Save']")
    public WebElement buttonSaveComment;

    @FindBy(css = "#Categories")
    public List<WebElement> checkBoxAvailableCategories;

    @FindBy(css = "[name='CurSelect']")
    public WebElement moveChosenCategoryInSelect;

    @FindBy(css = ".textcolumn")
    public List<WebElement> allTDInCommentsText;

    @FindBy(css = ".categorycolumn")
    public List<WebElement> allCategoriesInCommentsText;

    @FindBy(css = ".checkedcolumn>input[name='SelectedId']")
    public List<WebElement> allCheckBoxesCommentsText;

    @FindBy(css = "#Number")
    public WebElement fieldNumber;

}
