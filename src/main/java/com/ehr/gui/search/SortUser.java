package com.ehr.gui.search;

public enum SortUser {

    BEST_MATCH("Best match"),
    MOST_FOLLOWERS("Most followers"),
    FEWEST_FOLLOWERS("Fewest followers"),
    MOST_RECENTLY_JOINED("Most recently joined"),
    LEAST_RECENTLY_JOINED("Least recently joined"),
    MOST_REPOSITORIES("Most repositories"),
    FEWEST_REPOSITORIES("Fewest repositories");

    private String value;

    SortUser(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
