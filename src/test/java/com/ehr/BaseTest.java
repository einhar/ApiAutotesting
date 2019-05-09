package com.ehr;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;

public abstract class BaseTest {

    public static final String BASE_ENDPOINT = "https://api.github.com";

    protected CloseableHttpClient client;
    protected CloseableHttpResponse response;

    @Before
    public void setUp() {
        client = HttpClientBuilder.create().build();
    }

    @After
    public void cleanUp() throws IOException {
        client.close();
    }
}
