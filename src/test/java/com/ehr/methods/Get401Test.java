package com.ehr.methods;

import com.ehr.BaseTest;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Get401Test extends BaseTest {

    private static final int EXPECTED_STATUS = 401;

    @Test
    public void user() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/user");
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertThat(actualStatus,
                is(equalTo(EXPECTED_STATUS)));
    }

    @Test
    public void userFollowers() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/user/followers");
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertThat(actualStatus,
                is(equalTo(EXPECTED_STATUS)));
    }

    @Test
    public void userNotifications() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/notifications");
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertThat(actualStatus,
                is(equalTo(EXPECTED_STATUS)));
    }
}
