package com.ehr.api.methods;

import com.ehr.api.BaseTest;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class Get404Test extends BaseTest {

    private static final int EXPECTED_STATUS = 404;

    @Test
    public void nonExistingUrl() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/nonExistingUrl");
        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertThat(actualStatus, is(equalTo(EXPECTED_STATUS)));
    }
}
