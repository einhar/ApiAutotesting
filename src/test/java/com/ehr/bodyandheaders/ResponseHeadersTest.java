package com.ehr.bodyandheaders;

import com.ehr.BaseTest;
import com.ehr.ResponseUtils;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class ResponseHeadersTest extends BaseTest {

    @Test
    public void contentTypeIsJson() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        Header contentType = response.getEntity().getContentType();
        assertThat(contentType.getValue(),
                is(equalTo("application/json; charset=utf-8")));

        ContentType content = ContentType.getOrDefault(response.getEntity());
        
        assertThat(content.getMimeType(),
                is(equalTo("application/json")));
    }

    @Test
    public void serverIsGithubOld() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        
        String headerValue = ResponseUtils.getHeaderFromResponse(response, "Server");
        
        assertThat(headerValue,
                is(equalTo("GitHub.com")));
    }

    @Test
    public void serverIsGithub() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        
        String headerValue = ResponseUtils.getHeader(response, "Server");
        
        assertThat(headerValue,
                is(equalTo("GitHub.com")));
    }

    @Test
    public void xRateLimitIsSixty() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        
        String limit = ResponseUtils.getHeader(response, "X-RateLimit-Limit");
        
        assertThat(limit,
                is(equalTo("60")));
    }

    @Test
    public void eTagIsPresent() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);

        boolean isPresent = ResponseUtils.isHeaderPresent(response, "ETag");

        assertTrue(isPresent);
    }

}
