package com.ehr.gui.login;

public class LoginPage {

    private LoginPageActController act;

    private LoginPageVerifyController verify;

    public LoginPageActController act() {
        return act;
    }

    public LoginPageVerifyController verify() {
        return verify;
    }

    private LoginPage(LoginPageActController act, LoginPageVerifyController verify) {
        this.act = act;
        this.verify = verify;
    }

    public static LoginPage getLoginPage() {
        return new LoginPage(new LoginPageActController(), new LoginPageVerifyController());
    }
}
