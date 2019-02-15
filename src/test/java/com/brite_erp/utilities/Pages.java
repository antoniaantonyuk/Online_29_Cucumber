package com.brite_erp.utilities;

import com.brite_erp.pages.*;

public class Pages {
    private LoginPage loginPage;
    private ChooseERP chooseERP;
    private DiscussPage discussPage;
    private PurchasesMain purchasesMain;
    private CreateChannelPage createChannelPage;

    private Vendors vendors;
    private QuotationRequest quotationRequest;
    private BrowserUtils browserUtils;

    public BrowserUtils browserUtils()
    {
        if (browserUtils==null)
            browserUtils=new BrowserUtils();

        return browserUtils;
    }
    public LoginPage login() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public ChooseERP chooseERP() {
        if (chooseERP == null) {
            chooseERP = new ChooseERP();
        }
        return chooseERP;
    }

    public CreateChannelPage createChannelPage() {
        if (createChannelPage == null) {
            createChannelPage = new CreateChannelPage();
        }
        return createChannelPage;
    }
    public DiscussPage discussPage() {
        if (discussPage == null) {
            discussPage = new DiscussPage();
        }
        return discussPage;
    }
    public PurchasesMain purchasesMain() {
        if (purchasesMain == null) {
            purchasesMain = new PurchasesMain();
        }
        return purchasesMain;
    }
    public QuotationRequest quotationRequest() {
        if (quotationRequest == null) {
            quotationRequest = new QuotationRequest();
        }
        return quotationRequest;
    }

    public Vendors vendors() {
        if (vendors == null) {
            vendors = new Vendors();
        }
        return vendors;
    }

}
