package PageObjects;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class automationLanguage {
	public WebDriver driver;
	WebDriverWait wait;
	Actions act;

	public automationLanguage(WebDriver wd)
	{ driver =wd;
	  PageFactory.initElements(driver, this);
	  wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	  act=new Actions(driver);
	}

	@FindBy(xpath = "//span[@class='icp-nav-link-inner']//span[@class='nav-line-2']")private WebElement SelectLanguage;
	@FindBy(xpath = "//div[normalize-space()='EN']")private WebElement DefaultSelectLanguage;
	@FindBy(xpath = "//div[@id='nav-flyout-icp']//a[5]//span[1]//i[1]")private WebElement Kannada;
	@FindBy(xpath = "//div[@id='nav-flyout-icp']//a[8]//span[1]//i[1]") private WebElement MarathiLanguage;
	@FindBy(xpath = "//div[@id='nav-flyout-icp']//a[2]//span[1]//i[1]") private WebElement HindiLanguage;
	@FindBy(xpath = "(//div[@id='nav-tools']/descendant::div)[1]")private WebElement SelectedLanguage;
	@FindBy(xpath = "//div[@id='nav-flyout-icp']//a[contains(@href,'#switch-lang')]") private List<WebElement> NoOfLanguages;

	public void language_Verification()
	{wait.until(ExpectedConditions.visibilityOf(SelectLanguage));
	 act.moveToElement(SelectLanguage).build().perform();
	 System.out.println(DefaultSelectLanguage.getText());
	 Assert.assertTrue(DefaultSelectLanguage.getText().equals("EN"));
	 System.out.println("Default Language is: English");
	}

	public void select_KannadaLanguage()
	{act.moveToElement(SelectLanguage).build().perform();
	 wait.until(ExpectedConditions.visibilityOf(Kannada));
	 Kannada.click();
	 driver.navigate().refresh();
	 Assert.assertTrue(SelectedLanguage.getText().equals("KN"));
	 System.out.println("Selected Language is: KANNADA");
	}

	public void select_MarathiLanguage()
	{act.moveToElement(SelectLanguage).build().perform();
	 wait.until(ExpectedConditions.visibilityOf(MarathiLanguage));
	 MarathiLanguage.click();
	 driver.navigate().refresh();
	 wait.until(ExpectedConditions.visibilityOf(SelectedLanguage));
	 System.out.println(SelectedLanguage.getText());
	 Assert.assertTrue(SelectedLanguage.getText().equals("MR"));
	 System.out.println("Selected Language is: MARATHI");
	}

	public void countryLanguages()
	{wait.until(ExpectedConditions.visibilityOfAllElements(NoOfLanguages));
	 System.out.println("Amazon India WebPage Country Language List As Below-----------");
	 for(WebElement menu:NoOfLanguages)
	 {System.out.println(menu.getText());}
	}




}
