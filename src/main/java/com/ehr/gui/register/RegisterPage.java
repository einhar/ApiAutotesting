package com.ehr.gui.register;

public class RegisterPage {

    private RegisterPageActController act;

    private RegisterPageVerifyController verify;

    public RegisterPageActController act() {
        return act;
    }

    public RegisterPageVerifyController verify() {
        return verify;
    }

    private RegisterPage(RegisterPageActController act, RegisterPageVerifyController verify) {
        this.act = act;
        this.verify = verify;
    }

    public static RegisterPage getRegisterPage() {
        return new RegisterPage(new RegisterPageActController(), new RegisterPageVerifyController());
    }
}
