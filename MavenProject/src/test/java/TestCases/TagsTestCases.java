package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PhoenixBase.Phoenixbase;

import PageObjects.TagsPageObjects;


public class TagsTestCases extends Phoenixbase {
	@Test(priority=1)
	public void login() throws InterruptedException {
		tmpo=new TagsPageObjects(driver);
		tmpo.login("SystemAdmin@qa.com","Test$123");
		Thread.sleep(15000);
		tmpo.navigateToTagsTab();
		Thread.sleep(20000);	
	}
	
	
	
	@Test(priority=2)
	public void VerifytheCreateTagbutton() throws InterruptedException {
		tmpo= new TagsPageObjects(driver);
		Assert.assertTrue(tmpo.VerifythePresenceofCreateTagbutton());
		Assert.assertTrue(tmpo.getCreateTagbuttonbackgroudcolour());
		tmpo.openTagCreationPopup();
		Thread.sleep(6000);
	}
	
	@Test(priority=3)
	public void VerifytheCreateTagPopup() throws InterruptedException {
		Assert.assertEquals(tmpo.Verifyaddtagpopuptitle(),"Create Tag");
		Thread.sleep(2000);		
	
		} 
	
	@Test(priority=4)
	public void VerifyCreatePlaceholderText() throws InterruptedException {
		Assert.assertEquals(tmpo.validateEditPlaceholderText("placeholderText"), ("Enter Tag Name"));
		Thread.sleep(2000);	
	}
	
	
	@Test(priority=5)
	   public void VerifythepresenceofSavebutton() throws InterruptedException {
		   Assert.assertTrue(tmpo.VerifythePresenceofsavebutton());
		   Assert.assertTrue(tmpo.getSavebuttonbackgroudcolour());
		   tmpo.clickSaveButton();
		   Thread.sleep(3000);
	   }
	@Test(priority=6)
	   public void VerifyCreateCancelbutton() throws InterruptedException {
			Assert.assertTrue(tmpo.VerifythePresenceofcancelbutton()); 
			Assert.assertTrue(tmpo.mousehovertheAddCancelButtongetthebackgroundcolour());
			Thread.sleep(7000);
	   }
	@Test(priority=7)
	   public void ClickonCreatecancelbutton() throws InterruptedException {
		   tmpo.clickCancelButton();
		   Thread.sleep(10000);
		   tmpo.openTagCreationPopup();
			Thread.sleep(6000);
	}
	@Test(priority=8)
	   public void ClickonCreatecrossicon() throws InterruptedException {
		   tmpo.clickonCrossicon();
		   Thread.sleep(10000);
		   tmpo.openTagCreationPopup();
			Thread.sleep(6000);
	}
	
	
		   
		   
    @Test(priority=9)
    public void VerifyTagNamerequiredvalidationmessage() throws InterruptedException {   	
		        tmpo.clickSaveButton();
		  		Thread.sleep(5000);
		  		Assert.assertEquals(tmpo.getaddTagEmptyDataValidationMessage(),"Tag name is required.");
		  		Thread.sleep(7000);

	}
    
	@Test(priority=10)
	public void VerifyCreateEnterAlphanumaricCharacters() throws InterruptedException {
		
		tmpo.VerifyAlphanumericCharacters();
		Thread.sleep(5000);
    }
	
	@Test(priority=11)
	public void VerifyCreateTagNamefieldacceptsSpaceswithintheword() throws InterruptedException {
		
		tmpo.VerifySpaces();
	    Thread.sleep(7000);
	}
	
	@Test(priority=12)
	public void VerifytheMaxlengthrangeofCreateTagNamefield() throws InterruptedException {
		
		tmpo.TagNameExceedTest();
		Thread.sleep(5000);
		
	}
	
	@Test(priority=13)
	public void VerifythecreateTagnameEnterspecialchareacters() throws InterruptedException {
	    tmpo.VerifySpecialCharacters();
		Thread.sleep(5000);
		
	}
	
	
	@Test(priority=14)
	public void VerifythecreateTagNameTrimmingfuctionality() throws InterruptedException {
	
		tmpo.validateAndTrimTagTextField();
		Thread.sleep(5000);
	}
	
	@Test(priority=16)
	public void clickonsavebutton() throws InterruptedException
	{
		tmpo.tagName("DemoTags creation");
		tmpo.clickSaveButton();
		Thread.sleep(3000);	
	}
	
	
	
	@Test(priority=17)
	public void verifytoast() {
		
		Assert.assertTrue(tmpo.validateExistingTagToastNotification("Create Tag", "Tag created successfully.")) ;
	}
	
	@Test(priority = 15)
	public void VerifyDuplicatetoast() throws InterruptedException {
		
		tmpo.tagName("Test Tag");
		Thread.sleep(2000);
		tmpo.clickSaveButton();
		Thread.sleep(3000);	
		
		Assert.assertTrue(tmpo.validateExistingTagToastNotification("Create Tag", "Tag already exists.")) ;
		
	}
	
	
	//Edit
	@Test(priority=18)
	public void VerifyEditIcon() {
		tmpo=new TagsPageObjects(driver);
		tmpo.ClickonEditIcon();
		
		
	}
	@Test(priority=19)
	public void VerifytheEditTagPopup() {
		Assert.assertEquals(tmpo.VerifyEdittagpopuptitle(),"Edit Tag");
		
		} 
	
	@Test(priority=20)
	public void VerifyPlaceholderText() throws InterruptedException {
		Assert.assertEquals(tmpo.validateEditPlaceholderText("placeholderText"),("Enter Tag Name"));
		Thread.sleep(2000);	
	}
	
	
	@Test(priority=21)
	   public void VerifythepresenceofUpdatebutton() throws InterruptedException {
		   Assert.assertTrue(tmpo.VerifythePresenceofEditTagUpdatebutton());
		   Assert.assertTrue(tmpo.getUpdatebuttonbackgroudcolour());			  
		   Thread.sleep(3000);
	   }
	@Test(priority=22)
	   public void VerifyCancelbutton() throws InterruptedException {
			Assert.assertTrue(tmpo.VerifythePresenceofEditTagCancelbutton()); 
			Assert.assertTrue(tmpo.mousehoverthecancelButtongetthebackgroundcolour());
			Thread.sleep(7000);
	   }
	@Test(priority=23)
	   public void Clickoncancelbutton() throws InterruptedException {
		tmpo.clickonEditTagCancelButton();
		   Thread.sleep(10000);
		 
	}
	@Test(priority=24)
	   public void Clickoncrossicon() throws InterruptedException {
		tmpo.ClickonEditIcon();
		tmpo.clickonEditTagCrossicon();
		   Thread.sleep(10000);
		   tmpo.ClickonEditIcon();
			Thread.sleep(5000);
	}
	
	@Test(priority=25)
	public void VerifyEnterAlphanumaricCharacters() throws InterruptedException {
		
		tmpo.EditVerifyAlphanumericCharacters();		
		Thread.sleep(5000);
    }
	
	@Test(priority=26)
	public void VerifyTagNamefieldacceptsSpaceswithintheword() throws InterruptedException {
		
		tmpo.EditVerifySpaces();
		Thread.sleep(7000);
	}
	
	@Test(priority=27)
	public void VerifytheMaxlengthrangeofTagNamefield() throws InterruptedException {
		
		tmpo.EditTagNameExceedTest();
		Thread.sleep(5000);
		
	}
	
	@Test(priority=28)
	public void VerifytheTagnameEnterspecialchareacters() throws InterruptedException {
	    
		tmpo.EditVerifySpecialCharacters();
		Thread.sleep(5000);
	}
	
	
	@Test(priority=29)
	public void VerifytheTagNameTrimmingfuctionality() throws InterruptedException {
		tmpo.EditvalidateAndTrimTagTextField();
		Thread.sleep(5000);
	}
	
	@Test(priority=31)
	public void clickonUpdatebutton() throws InterruptedException
	{
		
		tmpo.enterTagName("Demo Edit");
		tmpo.clickonEditTagUpdateButton();
		Thread.sleep(3000);
	}
	
	

@Test(priority=32)
public void VerifyEditTagToastTitleandToasttext() throws InterruptedException {
	Assert.assertTrue(tmpo.EditTagToastNotification("Edit Tag", "Tag updated successfully."));
	Thread.sleep(10000);
}


@Test(priority=30)
public void duplicateEditTagToastTitleandToasttext() throws InterruptedException {
	
	tmpo.enterTagName("Test Tag");
	tmpo.clickonEditTagUpdateButton();
	Thread.sleep(3000);
	Assert.assertTrue(tmpo.EditTagToastNotification("Update Tag", "Tag already exists"));
	Thread.sleep(3000);

}


//Delete
@Test(priority=33)
public void VerifyDeleteTagIcon() throws InterruptedException {
	tmpo=new TagsPageObjects(driver);
	tmpo.VerifyDeleteIcon();
	Thread.sleep(3000);
	
}

@Test(priority=34)
public void clickonDeleteTagCrossicon()
{	
	tmpo.clickonDeleteTagCrossicon();

}


@Test(priority= 35)
public void VerifyDeletetagpopuptext() throws InterruptedException {
	tmpo=new TagsPageObjects(driver);
	tmpo.VerifyDeleteIcon();
	Assert.assertEquals(tmpo.VerifyDeletetagpopuptext(),"Please enter word \"Delete\" to continue");
	
}



@Test(priority=36)
public void VerifydelPlaceholdertext() throws InterruptedException {
	tmpo=new TagsPageObjects(driver);
	tmpo.validateDelPlaceholderText();
Thread.sleep(3000);
}

@Test(priority=37)
public void VerifythePresenceofSubmitbutton() throws InterruptedException{

	tmpo.VerifythePresenceofSubmitbutton();
	Thread.sleep(2000);
}

@Test(priority=38)
public void getSubmitbuttonbackgroudcolour() throws InterruptedException {
	tmpo.getSubmitbuttonbackgroudcolour();
Thread.sleep(2000);
	
}

@Test(priority=39)
public void getDeleteTagEmptyDataValidationMessage() throws InterruptedException {

	tmpo.getDeleteTagEmptyDataValidationMessage();
	Thread.sleep(2000);
}

@Test(priority=40)
public void DeleteTagNameExceedTest() throws InterruptedException {

	tmpo.DeleteTagNameExceedTest();
	Thread.sleep(2000);
}

@Test(priority=42)
public void entertextDelete() throws InterruptedException {
	tmpo.entertextDelete("delete");
	Thread.sleep(2000);
	
}
		

@Test(priority=43)
public void clickonSubmitTagButton() throws InterruptedException {

	tmpo.clickonSubmitTagButton();
	Thread.sleep(2000);
}



@Test(priority=44)
public void toast() {
	
	Assert.assertTrue(tmpo.DeleteTagToastNotification("Delete Tag", "Tag(s) deleted successfully."));
}

@Test(priority=41)
public void invalidtoast() throws InterruptedException {
    tmpo.entertextDelete("dont delete");
    
	Thread.sleep(3000);
	
	tmpo.clickonSubmitTagButton();
	Assert.assertTrue(tmpo.DeleteTagToastNotification("Delete Tag", "Type the phrase DELETE in the textbox."));
	Thread.sleep(5000);
	
}



//Search
@Test(priority=45)
public void VerifySearchField() {
	tmpo = new TagsPageObjects(driver);
	tmpo.VerifythepresenceofSearchbox();
	//Assert.assertTrue(spo.VerifythepresenceofSearchbox(),"Unable to display Search Field");
    
}

@Test(priority=46)
public void VerifySearchLens() {
	Assert.assertTrue(tmpo.VerifythepresenceLensSymobolinsearchbox(),"Unable to display Search lens symbol");
}


@Test(priority=48)
public void VerifyNomatchfoundText() throws InterruptedException {	
	tmpo.testTagSearch("aaaaaaaaaaaaaaaaaa");
	Assert.assertEquals(tmpo.VerifyNomatchfoundText(),"No Match Found.");
	driver.navigate().refresh();
    Thread.sleep(15000);
}

@Test(priority=47)
public void testTagSearch() throws InterruptedException {
	tmpo = new TagsPageObjects(driver);
	tmpo.testTagSearch("!@#$%^&*()");
	Thread.sleep(5000);
	tmpo.testTagSearch("12");
    Thread.sleep(5000);
    tmpo.testTagSearch("44444444444444444");
    
}


//Listing
@Test(priority=49)
public void VerifytheSelectAlloption() throws InterruptedException {
	tmpo.ClickonSelectAll();
	Thread.sleep(8000);
	
}


@Test(priority=50)
public void VerifythepresenceDeleteTagsbutton() throws InterruptedException {
	Assert.assertTrue(tmpo.VerifythePresenceofDeleteTagsbutton());
	Thread.sleep(3000);	
	
}


@Test(priority=51)
public void DeleteTagsbuttonbackgroudcolour() throws InterruptedException {
    Assert.assertTrue(tmpo.getDeleteTagsbuttonbackgroudcolour());
    Thread.sleep(3000);	
   
}



@Test(priority=52)
public void VerifyCheckboxesagainstTags() throws InterruptedException{
	
	tmpo.Verifycheckboxesagainsttags();
	
}


@Test(priority=53)
public void VerifyMousehoveroverstheTag() throws InterruptedException {
	Assert.assertTrue(tmpo.ValidateMousehoveroverstheTag());
	Thread.sleep(3000);
}


@Test(priority=54)
public void ClickonDeleteTagsButton() throws InterruptedException {
	tmpo.uncheckClearAll();
	Thread.sleep(3000);
	tmpo.clickonDeleteTagsButton();
	Thread.sleep(3000);
}

@Test(priority=55)
public void VerifyPagination1() throws InterruptedException {
	
	tmpo.verifyPagination() ;
	Thread.sleep(3000);
	
}

@Test(priority=56)
public void Verifytagsorder() { 
	tmpo.tagsorder();
	tmpo.containsSpecialCharacters("$");
	tmpo.isDecimalNumber("0.0");

}



@Test(priority=57)
public void VerifywhennoTagsarecreated() throws InterruptedException {
	tmpo.validatetext();
	Thread.sleep(3000);
}




}
