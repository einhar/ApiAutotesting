package com.ehr.api.methods.parametrized;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class ParametrizedGetTest {
    public static final String BASE_ENDPOINT = "https://api.github.com";

    CloseableHttpClient client;
    CloseableHttpResponse response;

    @Before
    public void setUp() {
        client = HttpClientBuilder.create().build();
    }


    @After
    public void cleanUp() throws IOException {
        client.close();
    }


    private String input;
    private int output;

    public ParametrizedGetTest(String input, int output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"/", 200},
                {"/rate_limit", 200},
                {"/search/repositories?q=java", 200},
                {"/user", 401},
                {"/user/followers", 401},
                {"/notifications", 401},
                {"/nonexistingurl", 404},
        });
    }

    @Test
    public void parametrizedTest() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + input);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertThat(actualStatus, is(equalTo(output)));
    }
}
