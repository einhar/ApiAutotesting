package com.ehr.methods;

import com.ehr.BaseTest;
import com.ehr.ResponseUtils;
import org.apache.http.client.methods.HttpOptions;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Option204Test extends BaseTest {

    @Test
    public void optionsReturnsCorrectMethodsList() throws IOException {

        String header = "Access-Control-Allow-Methods";
        String expectedReply = "GET, POST, PATCH, PUT, DELETE";

        HttpOptions request = new HttpOptions(BASE_ENDPOINT);
        response = client.execute(request);

        String value = ResponseUtils.getHeader(response, header);

        assertThat(value, is(equalTo(expectedReply)));
    }
}
