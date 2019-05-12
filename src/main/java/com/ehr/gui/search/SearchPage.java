package com.ehr.gui.search;

public class SearchPage {

    private SearchPageActController act;

    public SearchPageActController act() {
        return act;
    }

    public SearchPage(SearchPageActController act) {
        this.act = act;
    }

    public static SearchPage getSearchPage() {
        return new SearchPage(new SearchPageActController());
    }
}
