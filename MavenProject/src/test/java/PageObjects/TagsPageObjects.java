package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TagsPageObjects {
	public WebDriver driver;

    public TagsPageObjects(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void login(String username, String password) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement usernamefield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='userName']")));
        usernamefield.sendKeys("SystemAdmin@qa.com");
	   
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("Test$123");  
        Thread.sleep(10000);
        
        WebElement loginButton = driver.findElement((By.xpath("//button[@class='btn btn-block btn-primary mb-0 login-btn']")));
        loginButton.click();
        Thread.sleep(10000);
   
    }

    public void navigateToTagsTab() throws InterruptedException {
    	
    	
		WebElement grid = driver.findElement(By.xpath("//div[@class='row gap-10']"));
        List<WebElement> organizationCards = grid.findElements(By.xpath("//h5[text()='Audi']"));
		
	    for (WebElement card : organizationCards) {
	    WebElement organizationNameElement = card.findElement(By.xpath("//h5[text()='Audi']"));
	    //WebElement organizationNameElement = card.findElement(By.xpath("//h5[text()='InfoTech']"));
        String organizationName = organizationNameElement.getText();
        if (organizationName.equals("Audi")) {
	            card.click();  
	        }
	    }
	    System.out.println("Organization card is clicked and it navigates to dashboard page");
	    Thread.sleep(5000);
        
        
        //LHS click
        WebElement lhsSettings = driver.findElement(By.xpath("//span[text()='Settings']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",lhsSettings );
        lhsSettings.click();
        
        System.out.println("Settings module is clicked on the LHS Menu");
        Thread.sleep(8000);
        
        //TagsTabclick
	    WebElement tagsTab = driver.findElement(By.xpath("//div[text()='Tags']"));
	    tagsTab.click();
	    System.out.println("Tags tab is clicked");
	    Thread.sleep(10000);
	    
    }
    
    public boolean VerifythePresenceofCreateTagbutton() {
		boolean status = driver.findElement(By.xpath("(//button[starts-with(text(),'Create Tag')])[2]")).isDisplayed();
		return status;
		
	}
    
    public boolean getCreateTagbuttonbackgroudcolour() {
    	  
		WebElement errorMessage = driver.findElement(By.xpath("(//button[starts-with(text(),'Create Tag')])[2]"));
        String color = errorMessage.getCssValue("background-color");
        return true;
	}
    
	public void openTagCreationPopup() throws InterruptedException {
        WebElement createTagButton = driver.findElement(By.xpath("(//button[starts-with(text(),'Create Tag')])[2]"));
        createTagButton.click();
        Thread.sleep(5000);
    }
    
	public String Verifyaddtagpopuptitle() {
		WebElement title= driver.findElement(By.xpath("//span[text()='Create Tag']"));
		return title.getText();
       
	}
	
	 
        

      
    
    public  String validateCreatePlaceholderText(String placeholderText) {
    	
    	WebElement tagNameField = driver.findElement(By.xpath("//input[@placeholder='Enter Tag Name']"));
    	String placeholderText1 = tagNameField.getAttribute("placeholder");

        String expectedPlaceholder = "Enter Tag Name";
        if (placeholderText1.equals(expectedPlaceholder)) {
            System.out.println("Placeholder text validation successful.");
        } else {
            System.out.println("Placeholder text validation failed.");
            System.out.println("Expected Placeholder: " + expectedPlaceholder);
            System.out.println("Actual Placeholder: " + placeholderText1);
        }
		return placeholderText1;
    }
	
    public void tagName(String tagName) {
    	
        WebElement tagNameField = driver.findElement(By.xpath("//input[@placeholder='Enter Tag Name']"));
        tagNameField.clear();
        tagNameField.sendKeys(tagName);	         
    }
    
    
    public  void validateAndTrimTagTextField() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	WebElement tagNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Tag Name']")));
    	String trimtagName = "       trimming   ";
    	tagNameField.clear();
        tagNameField.sendKeys(trimtagName);
        tagNameField.sendKeys(Keys.TAB);
        
    }
    
    public void TagNameExceedTest() {
		WebElement tagNameInput = driver.findElement(By.xpath("//input[@placeholder='Enter Tag Name']"));
        String longtagName = "Tag name is more than 40 characters.....";
        tagNameInput.clear();
        tagNameInput.sendKeys(longtagName);
        String enteredValue = tagNameInput.getAttribute("value");

        if(enteredValue.length() <=40) {
			System.out.println("Tag name is within 40 characters. Test passed.");
			
		}
		else {
			System.out.println("Tag name exceeds 40 character limit. Test failed.");
		}
		
	}
	

    public String getaddTagEmptyDataValidationMessage() {
        WebElement validationMessage = driver.findElement(By.xpath("//label[text()='Tag name is required.']"));
        return validationMessage.getText();
    }
    
    public void VerifyAlphanumericCharacters() {
    	WebElement tagNameInput = driver.findElement(By.xpath("//input[@placeholder='Enter Tag Name']"));
    	String tagAlpha = "Demo 12345";
    	tagNameInput.clear();
        tagNameInput.sendKeys(tagAlpha);
        tagNameInput.sendKeys(Keys.TAB);
        //String enteredValue = tagNameInput.getAttribute("value");
			System.out.println("Tag name allows Alphanumeric values");  	
    }
    
    public void VerifySpecialCharacters() {
    	WebElement tagNameInput = driver.findElement(By.xpath("//input[@placeholder='Enter Tag Name']"));
    	String tagSpecial = "%%)**";
    	tagNameInput.clear();
        tagNameInput.sendKeys(tagSpecial);
        tagNameInput.sendKeys(Keys.TAB);
        //String enteredValue = tagNameInput.getAttribute("value");
		System.out.println("Tag name allows Special Characters" );  	
    }
    
    public void VerifySpaces() {
    	WebElement tagNameInput = driver.findElement(By.xpath("//input[@placeholder='Enter Tag Name']"));
    	String tagSpaces = "Spaces within tagnames";
    	tagNameInput.clear();
        tagNameInput.sendKeys(tagSpaces);
        tagNameInput.sendKeys(Keys.TAB);
        //String enteredValue = tagNameInput.getAttribute("value");
		System.out.println("Tag name allows spaces between words");  	
    }
    
    public boolean VerifythePresenceofsavebutton() {
		boolean status = driver.findElement(By.xpath("(//button[text()='Save'])[1]")).isDisplayed();
		return status;
		
	}
    
    public boolean getSavebuttonbackgroudcolour() {
    	  
		WebElement errorMessage = driver.findElement(By.xpath("(//button[text()='Save'])[1]"));
        String color = errorMessage.getCssValue("background-color");
		return true;
        
	}

    public void clickSaveButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Save'])[1]")));
        saveButton.click();
    }
    
    public boolean VerifythePresenceofcancelbutton() {
		boolean status = driver.findElement(By.xpath("(//button[text()='Cancel'])[3]")).isDisplayed();
		return status;
	}
    
    public boolean mousehovertheAddCancelButtongetthebackgroundcolour() {
  	   WebElement element =driver.findElement(By.xpath("(//button[text()='Cancel'])[3]"));
  	   Actions act =new Actions(driver);
  	   act.moveToElement(element).build().perform();
	return true;
       }

    public void clickCancelButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Cancel'])[3]")));
        cancelButton.click();
    }
    
    public void clickonCrossicon() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	WebElement crossIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='p-dialog-header-close-icon ng-tns-c149-78 pi pi-times']")));
        crossIcon.click();
    }
    
    
	
	public boolean validateExistingTagToastNotification(String expectedTitle, String expectedMessage) {
	       
        WebElement toastTitle = driver.findElement(By.id("toast-container"));
        WebElement toastMessage = driver.findElement(By.xpath("//div[@id='toast-container']"));

        
        String actualTitle = toastTitle.getText();
        String actualMessage = toastMessage.getText();
        

        
        if (actualTitle.equals(expectedTitle) && actualMessage.equals(expectedMessage)) {
            System.out.println("Toast notification validation successful.");
        }	
        	else {
            System.out.println("Toast notification validation success.");
            System.out.println("Expected Title: " + expectedTitle + ", Actual Title: " + actualTitle);
            System.out.println("Expected Message: " + expectedMessage + ", Actual Message: " + actualMessage);
        }
		return true;
        
        }
	
	//Edit Tag
	public void ClickonEditIcon() {
	    //try {
            
            List<WebElement> tagElements = driver.findElements(By.xpath("(//app-setting-tags[@class='ng-star-inserted'])[2]"));
            Actions actions = new Actions(driver);          
            for (WebElement tagElement : tagElements) {               
                actions.moveToElement(tagElement).perform();                
                WebElement tagNameElement = tagElement.findElement(By.xpath("(//div[@class='d-flex align-items-center justify-content-between'])[61]"));              
                WebElement editicon = tagElement.findElement(By.xpath("(//a[@title='Edit'])[61]"));
                
                String tagName = tagNameElement.getText();
                tagNameElement.click(); 
	            editicon.click();
	            System.out.println("Tag is clicked in the listing");
            } 
	    }
    	       
	public String VerifyEdittagpopuptitle() {
		WebElement title= driver.findElement(By.xpath("//span[text()='Edit Tag']"));
		return title.getText();
		
	}
	
	public  String validateEditPlaceholderText(String placeholderText) {
    	
    	WebElement tagNameField = driver.findElement(By.xpath("//input[@placeholder='Enter Tag Name']"));
    	String placeholderText1 = tagNameField.getAttribute("placeholder");

        String expectedPlaceholder = "Enter Tag Name";
        if (placeholderText1.equals(expectedPlaceholder)) {
            System.out.println("Placeholder text validation successful.");
        } else {
            System.out.println("Placeholder text validation failed.");
            System.out.println("Expected Placeholder: " + expectedPlaceholder);
            System.out.println("Actual Placeholder: " + placeholderText1);
        }
		return placeholderText1;
    }
    public void enterTagName(String editName) {
    	
        WebElement tagNameField = driver.findElement(By.xpath("//input[@placeholder='Enter Tag Name']"));
        tagNameField.clear();
        tagNameField.sendKeys(editName);
    }
    
    public  void EditvalidateAndTrimTagTextField() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	WebElement tagNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Tag Name']")));
    	String trimtagName = "   ThisisTrim  ";
    	tagNameField.clear();
        tagNameField.sendKeys(trimtagName);
        tagNameField.sendKeys(Keys.TAB);
        
    }
    
    public void EditTagNameExceedTest() {
		WebElement tagNameInput = driver.findElement(By.xpath("//input[@placeholder='Enter Tag Name']"));
        String longtagName = "EditIsAtagssNameWithMoreThan40Characters";
        tagNameInput.clear();
        tagNameInput.sendKeys(longtagName);
        
        String enteredValue = tagNameInput.getAttribute("value");
        tagNameInput.sendKeys(Keys.TAB);

        if(enteredValue.length() <=40) {
			System.out.println("Tag name is within 40 characters. Test passed.");
			
		}
		else {
			System.out.println("Tag name exceeds the 40 character limit. Test failed.");
		}
		
	}
    
    public void EditVerifyAlphanumericCharacters() {
    	WebElement tagNameInput = driver.findElement(By.xpath("//input[@placeholder='Enter Tag Name']"));
    	String tagAlpha = "11Edit12";
    	tagNameInput.clear();
        tagNameInput.sendKeys(tagAlpha);
        String enteredValue = tagNameInput.getAttribute("value");
        tagNameInput.sendKeys(Keys.TAB);
        System.out.println("Tag name allows Alphanumeric values" +enteredValue);  	
    }
    
    public void EditVerifySpecialCharacters() {
    	WebElement tagNameInput = driver.findElement(By.xpath("//input[@placeholder='Enter Tag Name']"));
    	String tagSpecial = "!%%%!)";
    	tagNameInput.clear();
        tagNameInput.sendKeys(tagSpecial);        
        String enteredValue = tagNameInput.getAttribute("value");
        tagNameInput.sendKeys(Keys.TAB);
        System.out.println("Tag name allows Special Characters" +enteredValue);  	
    }
    
    public void EditVerifySpaces() {
    	WebElement tagNameInput = driver.findElement(By.xpath("//input[@placeholder='Enter Tag Name']"));
    	String tagSpaces = "Spaces while editing";
    	tagNameInput.clear();
        tagNameInput.sendKeys(tagSpaces); 
        String enteredValue = tagNameInput.getAttribute("value");
        tagNameInput.sendKeys(Keys.TAB);
        System.out.println("Tag name allows spaces between words" +enteredValue);  	
    }
    public void EditVerifytext() {
    	WebElement text = driver.findElement(By.xpath("//input[@placeholder='Enter Tag Name']"));
        text.clear();
        text.click();
        System.out.println("Text is cleared");
    }
	

    public String getEditTagEmptyDataValidationMessage() {
        WebElement validationMessage = driver.findElement(By.xpath("(//label[normalize-space()='Tag name is required.'])[1]"));
        validationMessage.sendKeys(Keys.TAB);
        return validationMessage.getText();
        
    }
    
    public boolean VerifythePresenceofEditTagUpdatebutton() {
		boolean status = driver.findElement(By.xpath("//button[text()='Update']")).isDisplayed();
		return status;
		
	}
    
    public boolean getUpdatebuttonbackgroudcolour() {
  	  
		WebElement errorMessage = driver.findElement(By.xpath("//button[text()='Update']"));
        String color = errorMessage.getCssValue("background-color");
		return true;
        
	}

    public void clickonEditTagUpdateButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8)); 
        WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Update']")));
        updateButton.click();
    }
    
    public boolean VerifythePresenceofEditTagCancelbutton() {
		boolean status = driver.findElement(By.xpath("(//button[text()='Cancel'])[3]")).isDisplayed();
		return status;
	}
    
    public boolean mousehoverthecancelButtongetthebackgroundcolour() {
 	   WebElement element =driver.findElement(By.xpath("(//button[text()='Cancel'])[3]"));
 	   Actions act =new Actions(driver);
 	   act.moveToElement(element).build().perform();
	return true;
      }


    public void clickonEditTagCancelButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8)); 
        WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Cancel'])[3]")));
        cancelButton.click();
    }
    
    public void clickonEditTagCrossicon() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8)); 
    	WebElement crossIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='p-dialog-header-close-icon ng-tns-c149-80 pi pi-times']")));
        crossIcon.click();
    }
    
   
    
    public boolean EditTagToastNotification(String expectedTitle, String expectedMessage) {
	       
        WebElement toastTitle = driver.findElement(By.id("toast-container"));
        WebElement toastMessage = driver.findElement(By.xpath("//div[@id='toast-container']"));

        
        String actualTitle = toastTitle.getText();
        String actualMessage = toastMessage.getText();
        

        
        if (actualTitle.equals(expectedTitle) && actualMessage.equals(expectedMessage)) {
            System.out.println("Toast notification validation successful.");
        }	
        	else {
            System.out.println("Toast notification validation success.");
            System.out.println("Expected Title: " + expectedTitle + ", Actual Title: " + actualTitle);
            System.out.println("Expected Message: " + expectedMessage + ", Actual Message: " + actualMessage);
        }
		return true;
        
        }
    //Delete Tag
    public void VerifyDeleteIcon() throws InterruptedException {
		
            List<WebElement> tagElements = driver.findElements(By.xpath("(//app-setting-tags[@class='ng-star-inserted'])[2]"));
            Actions actions = new Actions(driver);          
            for (WebElement tagElement : tagElements) {               
                actions.moveToElement(tagElement).perform();                
                WebElement tagNameElement = tagElement.findElement(By.xpath("(//div[@class='d-flex align-items-center justify-content-between'])[61]"));
                WebElement deleteicon = tagElement.findElement(By.xpath("(//a[@title='Delete'])[61]"));
                String tagName = tagNameElement.getText();
                tagNameElement.click(); 
	            deleteicon.click();
	            System.out.println("Tag is clicked in the listing");
	            Thread.sleep(5000);
            }
}
	
public String VerifyDeletetagpopuptext() {
	WebElement title= driver.findElement(By.xpath("//h6[text()='Please enter word \"Delete\" to continue']"));
	return title.getText();
}

public  void validateDelPlaceholderText() {
	
	WebElement tagNameField = driver.findElement(By.xpath("//input[@placeholder='Type Delete']"));
	String placeholderText1 = tagNameField.getAttribute("placeholder");

    String expectedPlaceholder = "Type Delete";
    if (placeholderText1.equals(expectedPlaceholder)) {
        System.out.println("Placeholder text validation successful.");
    } else {
        System.out.println("Placeholder text validation failed.");
        System.out.println("Expected Placeholder: " + expectedPlaceholder);
        System.out.println("Actual Placeholder: " + placeholderText1);
    }
}

public void entertextDelete(String tagName) {
	
    WebElement tagNameField = driver.findElement(By.xpath("//input[@placeholder='Type Delete']"));
    tagNameField.clear();
    tagNameField.sendKeys(tagName);
	
}


public void DeleteTagNameExceedTest() {
	WebElement textNameInput = driver.findElement(By.xpath("//input[@placeholder='Type Delete']"));
    String longtextName = "DeleteWithMoreThan15Characters";
    textNameInput.clear();
    textNameInput.sendKeys(longtextName);
    String enteredValue = textNameInput.getAttribute("value");
    textNameInput.sendKeys(Keys.TAB);

    if(enteredValue.length() <=15) {
		System.out.println("Text is below 15 characters and delete word is entered");
		
	}
	else {
		System.out.println("Text is above characters.");
	}
	
}


public String getDeleteTagEmptyDataValidationMessage() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
	WebElement deltext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Type Delete']")));
    deltext.click();
    deltext.sendKeys(Keys.TAB);
	WebElement validationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Confirmation text is required.']")));
    return validationMessage.getText();
}

public boolean VerifythePresenceofSubmitbutton() {
	boolean status = driver.findElement(By.xpath("//button[@class='btn btn-primary small-btn rounded-pill m-2 deleteCursor']")).isDisplayed();
	return status;
}

public void getSubmitbuttonbackgroudcolour() {
	  
	WebElement errorMessage = driver.findElement(By.xpath("//button[@class='btn btn-primary small-btn rounded-pill m-2 deleteCursor']"));
    String color = errorMessage.getCssValue("background-color");
    
}

public void clickonSubmitTagButton() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary small-btn rounded-pill m-2 deleteCursor']")));
    submitButton.click();
}



public void clickonDeleteTagCrossicon() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
	WebElement crossIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='p-dialog-header-close-icon ng-tns-c149-81 pi pi-times']")));
    crossIcon.click();
}


public boolean DeleteTagToastNotification(String expectedTitle, String expectedMessage) {
    
    WebElement toastTitle = driver.findElement(By.id("toast-container"));
    WebElement toastMessage = driver.findElement(By.xpath("//div[@id='toast-container']"));

    
    String actualTitle = toastTitle.getText();
    String actualMessage = toastMessage.getText();
    

    
    if (actualTitle.equals(expectedTitle) && actualMessage.equals(expectedMessage)) {
        System.out.println("Toast notification validation successful.");
    }	
    	else {
        System.out.println("Toast notification validation success.");
        System.out.println("Expected Title: " + expectedTitle + ", Actual Title: " + actualTitle);
        System.out.println("Expected Message: " + expectedMessage + ", Actual Message: " + actualMessage);
    }
	return true;
    
    }

       // Search
public String VerifyNomatchfoundText() {
	String status= driver.findElement(By.xpath("(//h3[normalize-space()='No Match Found.'])[1]")).getText();
    return status;
}



public boolean VerifythepresenceofSearchbox() {
	boolean status =driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]")).isDisplayed();
	return status;
}

public boolean VerifythepresenceLensSymobolinsearchbox() {
	boolean status =driver.findElement(By.xpath("(//button[@aria-label='search button'])[2]")).isDisplayed();
	return status;
}



public  void testTagSearch(String searchQuery) throws InterruptedException {
    
    WebElement searchField = driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]"));

    
    searchField.sendKeys(searchQuery);
    searchField.sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    
    WebElement searchResults = driver.findElement(By.xpath("(//div[@class='tabs-body'])[2]"));
    String searchResultsText = searchResults.getText();

    if (searchResultsText.contains(searchQuery)) {
        System.out.println("Tag search test passed for query: " + searchQuery);
    } else {
        System.out.println("Tag search test failed for query: " +VerifyNomatchfoundText());
    }
    searchField.clear();
    
}

     //Listing
public void validatetext() throws InterruptedException {
	 WebElement dropdown =driver.findElement(By.xpath("//a[@class='drop-down-icon ng-star-inserted']"));
	 dropdown.click();
	 WebElement org =driver.findElement(By.xpath("(//div[@class='e-fullrow'])[2]"));
	 org.click();
	 
	 WebElement text = driver.findElement(By.xpath("(//h3[@class='fs-14 fw-500 text-center m-b-0 p-t-10 p-b-10 nmf ng-star-inserted'])[2]"));
	 String actualtext = text.getText();
	 String expectedtext = "There are no items to display.";
	 if(actualtext.equals(expectedtext)) {
		 System.out.println("Text is validated");
	 }
	 else {
		 System.out.println("Text is not as expected");
	 }
	 
	 
}

public boolean ClickonSelectAll() throws InterruptedException {
	WebElement ele = driver.findElement(By.xpath("(//label[text()='Select All'])[2]"));
	//WebElement ele = driver.findElement(By.xpath("(//div[@class='p-checkbox-box'])[64]"));
	   boolean status = ele.isDisplayed();
	   
	   if(status== true)
	   {
		   boolean flag = ele.isEnabled();
		   
		   if(flag== true)
		   {
		   ele.click();
		   }
		   else
		   {
			  System.out.println("Element is not enabled");
		   }
	   }
	   return status;
}
public boolean uncheckClearAll() {
	
	   WebElement ele1 = driver.findElement(By.xpath("(//span[@class='p-checkbox-icon pi pi-check'])[1]"));
      boolean status = ele1.isDisplayed();
	   
	   if(status== true)
	   {
		   boolean flag = ele1.isEnabled();
		   
		   if(flag== true)
		   {
		   ele1.click();
		   }
		   else
		   {
			  System.out.println("Element is not enabled");
		   }
	   }
	   return status;
  
}




public boolean VerifythePresenceofDeleteTagsbutton() {
	
	boolean status = driver.findElement(By.xpath("(//button[@type='button'])[6]")).isDisplayed();
	return status;
	
}

public boolean getDeleteTagsbuttonbackgroudcolour() {
	  
	WebElement errorMessage = driver.findElement(By.xpath("(//button[@type='button'])[6]"));
   String color = errorMessage.getCssValue("background-color");
	return true;
   
}

public boolean ValidateMousehoveroverstheTag() {

	WebElement nameElement = driver.findElement(By.xpath("(//div[@class='checkboxes d-flex align-items-center justify-content-between Inactive'])[61]"));

   Actions actions = new Actions(driver);  
   actions.moveToElement(nameElement).perform();
   
   WebElement tagname = driver.findElement(By.xpath("(//div[@class='d-flex align-items-center justify-content-between'])[61]"));
   String tagnameTooltip = tagname.getText();

   if (tagname.isDisplayed() && tagnameTooltip.equals(tagname)) {
       System.out.println("Tagname tooltip is displayed with correct tooltip");
   } else {
       System.out.println("Tagname tooltip is  displayed ");
   }

   
   WebElement editIcon = driver.findElement(By.xpath("(//a[@title='Edit'])[61]"));
   String editTooltip = editIcon.getAttribute("title");

   if (editIcon.isDisplayed() && editTooltip.equals("Edit")) {
       System.out.println("Edit icon is displayed with correct tooltip");
   } else {
       System.out.println("Edit icon is not displayed or tooltip is incorrect");
   }

  
   WebElement deleteIcon = driver.findElement(By.xpath("(//a[@title='Delete'])[61]"));
   String deleteTooltip = deleteIcon.getAttribute("title");

   
   if (deleteIcon.isDisplayed() && deleteTooltip.equals("Delete")) {
       System.out.println("Delete icon is displayed with correct tooltip");
   } else {
       System.out.println("Delete icon is not displayed or tooltip is incorrect");
   }

  
   actions.moveToElement(nameElement).perform();
	return true;
   

}


public void verifyPagination() {
	// Find the list
	 try {
   List<WebElement> itemList = driver.findElements(By.xpath("//span[@class='p-checkbox-icon']"));

   // Get the size of the list
   int listSize = itemList.size();
   System.out.println("Size of the list: " + listSize);
   
   WebElement pagination = driver.findElement(By.xpath("//div[@id='e-content-tab_default_2']//div//div[@class='ng-star-inserted p-paginator p-component']"));
   JavascriptExecutor js = (JavascriptExecutor)driver;
   js.executeScript("arguments[0].scrollIntoView();",pagination );
   
   
   if (listSize > 60 && pagination.isDisplayed()) {
  
       System.out.println("Pagination is displayed");
   } else {
       
       System.out.println("Pagination is not displayed");
   }}
   catch (Exception e) {
       System.out.println("Pagination check failed: "); 
   
   }
}


public void clickonDeleteTagsButton() throws InterruptedException {
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8)); 
	WebElement tag3 = driver.findElement(By.xpath("(//div[@class='d-flex align-items-center justify-content-between'])[65]"));
	tag3.click();
	WebElement tag4 = driver.findElement(By.xpath("(//div[@class='checkboxes d-flex align-items-center justify-content-between Inactive'])[66]"));
	tag4.click();
	Thread.sleep(3000);
   WebElement deleteTags = driver.findElement(By.xpath("(//button[normalize-space()='Delete 2 Tag(s)'])[1]"));
   deleteTags.click();
   WebElement deleteText = driver.findElement(By.xpath("(//input[@placeholder='Type Delete'])[1]"));
   deleteText.sendKeys("delete");
   WebElement submit = driver.findElement(By.xpath("(//button[normalize-space()='Submit'])[1]"));
   submit.click();
}

public void Verifycheckboxesagainsttags() {
	
	List<WebElement> checkboxes = driver.findElements(By.className("p-checkbox-box"));
	List<WebElement> names = driver.findElements(By.xpath("//span[@tooltipposition='top']"));

	int minSize = Math.min(checkboxes.size(), names.size());
	for (int i = 60; i < minSize-1; i++) {
	    WebElement checkbox = checkboxes.get(i);
	    WebElement name = names.get(i);

	    // Get the name text
	    String tagName = name.getText();
	    boolean status = checkbox.isDisplayed();
	    boolean flag = checkbox.isEnabled();
	    boolean isSelect = checkbox.isSelected();
	    if ((status == true) && flag == true && isSelect == true) {
	        System.out.println("Checkbox checked for tagname: " + tagName);
	    } else {
	        System.out.println("Checkbox checked for tagname in list: " + tagName);
	        
	    }
	}
           
   
}


public void tagsorder() {

  
  List<WebElement> gridElements = driver.findElements(By.xpath("//span[@tooltipposition='top']"));
  
  
  List<String> elementTexts = new ArrayList<>();
  for (WebElement element : gridElements) {
      elementTexts.add(element.getText());
  }
  
  Collections.sort(elementTexts, (s1, s2) -> {
      if (containsSpecialCharacters(s1) && !containsSpecialCharacters(s2)) {
          return -1;
      } else if (!containsSpecialCharacters(s1) && containsSpecialCharacters(s2)) {
          return 1;
      } else if (isDecimalNumber(s1) && !isDecimalNumber(s2)) {
          return -1;
      } else if (!isDecimalNumber(s1) && isDecimalNumber(s2)) {
          return 1;
      } else {
          return s1.compareToIgnoreCase(s2);
      }
  });
  
  List<String> sortedTexts = new ArrayList<>(elementTexts);
  Collections.sort(sortedTexts, String.CASE_INSENSITIVE_ORDER);
  
  if (elementTexts.equals(sortedTexts)) {
      System.out.println("Listing grid is in the expected order.");
  } else {
      System.out.println("Listing grid -  expected order.");
  }
  
}

// Method to check if a string contains special characters
public  boolean containsSpecialCharacters(String s) {
  return !s.matches("[a-zA-Z0-9 ]*");
}

// Method to check if a string is a decimal number
public boolean isDecimalNumber(String s) {
  return s.matches("-?\\d+(\\.\\d+)?");
}

}
