package com.appmodule.share_PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appmodule.Generic_method.Generic_class;

public class Wall_PageClass extends Generic_class{

	@FindBy(xpath="//h3[text()='Wall']")
	public static WebElement wall_logo;
	
	@FindBy(xpath="//a[@href='/index.php/wallPosts']")
	public static WebElement Wall_link;
	
	@FindBy(id="post_body_ifr")
	public static WebElement Wall_desc_ifrmae;
	
	@FindBy(xpath="//body[@id='tinymce']/p")
	public static WebElement Wall_post_description;
	
	
	@FindBy(xpath="//div[@class='span2']/input")
	public static WebElement Post_Button;
	
	
}
