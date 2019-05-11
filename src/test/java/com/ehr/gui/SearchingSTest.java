package com.ehr.gui;

import com.ehr.gui.home.HomePage;
import com.ehr.gui.search.SearchNavi;
import com.ehr.gui.search.SearchPage;
import com.ehr.gui.search.SortUser;
import com.ehr.gui.user.UserPage;
import org.junit.Ignore;
import org.junit.Test;

public class SearchingSTest extends BaseSTest {

    @Test
    public void checkSearchRedirect() throws InterruptedException {
        HomePage.getHomePage().act().getSearchPage("einhar");
        Thread.sleep(1000);
        SearchPage.getSearchPage().act().selectNaviFilter(SearchNavi.USERS);
        Thread.sleep(1000);
        SearchPage.getSearchPage().act().selectUserSortOrder(SortUser.BEST_MATCH);
        Thread.sleep(1000);
        SearchPage.getSearchPage().act().selectUserSortOrder(SortUser.MOST_FOLLOWERS);
        Thread.sleep(1000);
        SearchPage.getSearchPage().act().searchForString("einhar");
        Thread.sleep(1000);
    }

    @Test
    public void checkUserSearchByBestMatch() throws InterruptedException {
        HomePage.getHomePage().act().getSearchPage("redirect");
        Thread.sleep(1000);
        SearchPage.getSearchPage().act().selectNaviFilter(SearchNavi.USERS);
        Thread.sleep(1000);
        SearchPage.getSearchPage().act().selectUserSortOrder(SortUser.BEST_MATCH);
        Thread.sleep(1000);
        SearchPage.getSearchPage().act().searchForString("einhar");
        Thread.sleep(1000);
        SearchPage.getSearchPage().act().goToUserSearchResult(1);
        Thread.sleep(1000);
        UserPage.getUserPage().verify().verifyUsername("einhar");
        Thread.sleep(1000);

    }


    @Ignore
    @Test
    public void searchUser() {
        // TODO: search for 'github' from homepage then enter,
        //  then select for Users,
        //  then click into user,
        //  then check if is it user
    }

    @Ignore
    @Test
    public void searchUserOrderByMostFollowers() {
        // TODO: search for 'github' from homepage then enter,
        //  then select for Users,
        //  then select for 'Most followers',
        //  then check follower number at 1st on the top,
        //  then check follower number at 2st on the top,
        //  then compare values of followers
    }

    @Ignore
    @Test
    public void searchUserOrderByMostRecentlyJoined() {
        // TODO: search for 'github' from homepage then enter,
        //  then select for Users,
        //  then select for 'Most Recently Joined',
        //  then check joined time of 1st on the top,
        //  then check joined time of 2st on the top,
        //  then compare values of time
    }

    @Ignore
    @Test
    public void searchUserOrderByMostRepositories() {
        // TODO: search for 'github' from homepage then enter,
        //  then select for Users,
        //  then select for 'Most Repositories',
        //  then check repos number of 1st on the top,
        //  then check repos number of 2st on the top,
        //  then compare numbers of repos
    }

    @Ignore
    @Test
    public void searchUserOrderByBestMatch() {
        // TODO: search for 'einhar' from homepage then enter,
        //  then select 'Users',
        //  then select sort 'Best match',
        //  then check if 1st is 'einhar'
    }
}
