package com.ehr.api.entities;


/**
 * Represents JSON object GET from https://www.GitHub.com
 *
 * */
public class User {

    /**
     * For tests using JsonObject
     */
    public static final String LOGIN = "login";
    public static final String ID = "id";
    public static final String NODE_ID = "node_id";
    public static final String AVATAR_URL = "avatar_url";
    public static final String GRAVATAR_ID = "gravatar_id";
    public static final String URL = "url";
    public static final String HTML_URL = "html_url";
    public static final String FOLLOWERS_URL = "followers_url";
    public static final String FOLLOWING_URL = "following_url";
    /*  TODO:   etc.. */

    private String login;

    private int id;

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }
}
