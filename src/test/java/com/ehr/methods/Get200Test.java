package com.ehr.methods;

import com.ehr.BaseTest;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Get200Test extends BaseTest {

    private static final int EXPECTED_STATUS = 200;

    @Test
    public void baseUrl() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertThat(actualStatus, is(equalTo(EXPECTED_STATUS)));
    }

    @Test
    public void rateLimit() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/rate_limit");
        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertThat(actualStatus, is(equalTo(EXPECTED_STATUS)));
    }

    @Test
    public void searchResponse() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/search/repositories?q=java");
        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertThat(actualStatus, is(equalTo(EXPECTED_STATUS)));
    }
}
