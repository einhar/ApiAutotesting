package com.ehr.gui.home;

public class HomePage {

    private HomePageActController act;

    public HomePageActController act() {
        return act;
    }

    private HomePage(HomePageActController act) {
        this.act = act;
    }

    public static HomePage getHomePage() {
        return new HomePage(new HomePageActController());
    }
}
