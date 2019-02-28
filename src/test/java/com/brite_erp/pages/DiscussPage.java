package com.brite_erp.pages;

import com.brite_erp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.brite_erp.utilities.ApplicationConstants.NEW_CHANNEL;



public class DiscussPage extends Menu {
    public DiscussPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@title='Add'])[3]")
    public WebElement addPrivateChannelPlusButton;

    @FindBy(xpath = "//input[@placeholder='Add a private channel']" )
    public  WebElement privateChannelCreatorBar;

    @FindBy(xpath = "//span[@class='o_channel_name']")
    public  WebElement privateChannelName;

    @FindBy(xpath = "//*[@title='InvitationTest']")
    public  WebElement privateChannelNameNewInvitation;

    @FindBy(xpath = "//textarea[@class='o_input o_composer_text_field']")
    public WebElement privateChannelMessageField;

    @FindBy(partialLinkText = NEW_CHANNEL)
    public  WebElement privateChannelNameNew;

    @FindBy(xpath = "//span[@title='Leave this channel']")
    public WebElement deletePrivateChannelXButton;

    @FindBy(xpath = "//button[@title='Invite people']")
    public WebElement clickInviteButton;

    @FindBy(xpath = "(//input[@type='text'])[7]")
    public WebElement selectUsersInDropDownMenu;

    @FindBy(id = "o_chat_fileupload3")
    public WebElement iframeInInvitationWindow;

    @FindBy(xpath= "//button[@class='btn btn-sm btn-primary']")
    public WebElement inviteButtonInFrame;

    @FindBy(xpath= "//*[@class='oe_topbar_name']")
    public WebElement avatar;

    @FindBy(xpath= "//a[@data-menu='logout']")
    public WebElement logOut;

    @FindBy(xpath = "//div[@class='o_mail_chat_sidebar']//i[@class='fa fa-inbox mr8']")
    public WebElement inboxLink;

    @FindBy( xpath= "(//li[@class='active'])[2]")
    public WebElement InboxTitle;

    @FindBy( xpath = "//h4[@class='o_mail_open_channels']" )
    public WebElement channelsLink;

    @FindBy (xpath = "//div[@class='oe_module_vignette oe_kanban_global_click o_kanban_record']")
    public WebElement generalChannelBlock;

    @FindBy(xpath = "(//span[@title='Add'])[2]")
    public WebElement addDirectMessagePlusButton;

    @FindBy(xpath = "//input[@placeholder='User name']" )
    public  WebElement AddOtherUserNameBar;

    @FindBy(xpath = "//li[@class='ui-menu-item']")
    public WebElement selectOtherUserInDropDownMenu;

    @FindBy(xpath = "(//span[@class='o_channel_name'])[6]")
    public  WebElement OtherUserName;

    @FindBy(xpath = "//span[@title='Leave this channel']")
    public WebElement deleteOtherUserNameXButton;

    @FindBy(xpath = "//textarea[@placeholder='Write something...']")
    public WebElement writeText;

    @FindBy(xpath = "(//div[@class='o_thread_message_content'])[3]")
    public WebElement actualMessage;

    @FindBy(xpath = "(//div[@class='o_thread_message_content'])[14]")
    public WebElement starMessage;

    @FindBy(xpath = "(//span[@class='o_thread_icons'])[20]")
    public WebElement starMark;

    @FindBy(xpath = "//span[@class='o_mail_sidebar_needaction badge ']")
    public WebElement starred;

    public boolean isElementPreset() {
        try {
            Driver.getDriver().findElement(By.xpath("(//span[@class='o_channel_name'])[6]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public boolean isStarPreset(){
        try {
            Driver.getDriver().findElement(By.xpath("(//span[@class='o_channel_name'])[6]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @FindBy(xpath = "//*[@class='oe_module_vignette oe_kanban_global_click o_kanban_record']" )
    public WebElement channelBlock;








}
