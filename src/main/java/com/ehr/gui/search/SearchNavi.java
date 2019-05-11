package com.ehr.gui.search;

public enum SearchNavi {

    REPOSITORIES("Repositories"),
    CODE("Code"),
    COMMITS("Commits"),
    ISSUES("Issues"),
    MARKETPLACE("Marketplace"),
    TOPICS("Topics"),
    WIKIS("Wikis"),
    USERS("Users");

    private String value;

    SearchNavi(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
