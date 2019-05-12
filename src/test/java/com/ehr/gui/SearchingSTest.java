package com.ehr.gui;

import com.ehr.gui.home.HomePage;
import com.ehr.gui.search.SearchNavi;
import com.ehr.gui.search.SearchPage;
import com.ehr.gui.search.SortUser;
import com.ehr.gui.user.UserPage;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;

public class SearchingSTest extends BaseSTest {

    @Test
    public void checkSearchRedirect() {
        HomePage.getHomePage().act().getSearchPage("einhar");
        SearchPage.getSearchPage().act().selectNaviFilter(SearchNavi.USERS);
        SearchPage.getSearchPage().act().selectUserSortOrder(SortUser.MOST_FOLLOWERS);
        SearchPage.getSearchPage().act().searchForString("einhar");
    }

    @Test
    public void checkUserSearchByBestMatch() {
        HomePage.getHomePage().act().getSearchPage("redirect");
        SearchPage.getSearchPage().act().selectNaviFilter(SearchNavi.USERS);
        SearchPage.getSearchPage().act().selectUserSortOrder(SortUser.BEST_MATCH);
        SearchPage.getSearchPage().act().searchForString("einhar");
        SearchPage.getSearchPage().act().goToUserSearchResult(1);
        UserPage.getUserPage().verify().verifyUsername("einhar");

    }

    @Test
    public void searchUserOrderByMostFollowers() {
        HomePage.getHomePage().act().getSearchPage("github");
        SearchPage.getSearchPage().act().selectNaviFilter(SearchNavi.USERS);
        SearchPage.getSearchPage().act().selectUserSortOrder(SortUser.MOST_FOLLOWERS);

        SearchPage.getSearchPage().act().goToUserSearchResult(1);
        int n_1 = UserPage.getUserPage().act().getUserFollowers();

        UserPage.getUserPage().act().backPage();

        SearchPage.getSearchPage().act().goToUserSearchResult(2);
        int n_2 = UserPage.getUserPage().act().getUserFollowers();

        MatcherAssert.assertThat(n_1, Is.is(Matchers.greaterThan(n_2)));
    }

    @Test
    public void searchUserOrderByMostRecentlyJoined() {
        HomePage.getHomePage().act().getSearchPage("github");
        SearchPage.getSearchPage().act().selectNaviFilter(SearchNavi.USERS);
        SearchPage.getSearchPage().act().selectUserSortOrder(SortUser.MOST_RECENTLY_JOINED).waitForPageLoaded();

        SearchPage.getSearchPage().act().goToUserSearchResult(2);
        LocalDateTime date_1 = UserPage.getUserPage().act().getUserJoinedDate();

        UserPage.getUserPage().act().backPage();

        SearchPage.getSearchPage().act().goToUserSearchResult(3);
        LocalDateTime date_2 = UserPage.getUserPage().act().getUserJoinedDate();

        MatcherAssert.assertThat("Date " + date_1 + " should be after date " + date_2,
                date_1.isAfter(date_2));
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

        // TODO: There are different types of user accounts,
        //  so different elements to work with
    }
}
