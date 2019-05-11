package com.ehr.gui.user;

public class UserPage {

    private UserPageActController act;

    private UserPageVerifyController verify;

    public UserPageActController act() {
        return act;
    }

    public UserPageVerifyController verify() {
        return verify;
    }

    private UserPage(UserPageActController act, UserPageVerifyController verify) {
        this.act = act;
        this.verify = verify;
    }


    public static UserPage getUserPage() {
        return new UserPage(new UserPageActController(), new UserPageVerifyController());
    }
}
