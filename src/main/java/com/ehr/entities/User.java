package com.ehr.entities;


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
/*    public static final String LOGIN = "gists_url";
    public static final String LOGIN = "starred_url";
    public static final String LOGIN = "subscriptions_url";
    public static final String LOGIN = "organizations_url";
    public static final String LOGIN = "repos_url";
    public static final String LOGIN = "events_url";
    public static final String LOGIN = "received_events_url";
    public static final String LOGIN = "type";
    public static final String LOGIN = "name";
    public static final String LOGIN = "company";
    public static final String LOGIN = "blog";
    public static final String LOGIN = "location";
    public static final String LOGIN = "email";
    public static final String LOGIN = "bio";
    public static final String LOGIN = "public_repos";
    public static final String LOGIN = "public_gists";
    public static final String LOGIN = "followers";
    public static final String LOGIN = "following";
    public static final String LOGIN = "created_at";
    public static final String LOGIN = "updated_at";*/

    private String login;
    private int id;

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }
}
