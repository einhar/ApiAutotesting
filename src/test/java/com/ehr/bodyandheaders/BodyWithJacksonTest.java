package com.ehr.bodyandheaders;

import com.ehr.BaseTest;
import com.ehr.ResponseUtils;
import com.ehr.entities.NotFound;
import com.ehr.entities.RateLimit;
import com.ehr.entities.User;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BodyWithJacksonTest extends BaseTest {

    @Test
    public void returnCorrectLogin() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/einhar");
        response = client.execute(get);

        User user = ResponseUtils.unmarshall(response, User.class);

        assertThat(user.getLogin(), is(equalTo("einhar")));
    }

    @Test
    public void returnCorrectId() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/einhar");
        response = client.execute(get);

        User user = ResponseUtils.unmarshall(response, User.class);

        assertThat(user.getId(), is(equalTo(30666023)));
    }

    @Test
    public void notFoundMessageIsCorrect() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/shouldBeEmptyUser");
        response = client.execute(get);

        NotFound notFound = ResponseUtils.unmarshall(response, NotFound.class);

        assertThat(notFound.getMessage(), is(equalTo("Not Found")));
    }

    @Test
    public void correctRateLimitsAreSet() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/rate_limit");
        response = client.execute(get);

        RateLimit rateLimit = ResponseUtils.unmarshall(response, RateLimit.class);

        assertThat(rateLimit.getCoreLimit(), is(equalTo(60)));
        assertThat(rateLimit.getSearchLimit(), is(equalTo("10")));

    }

}
