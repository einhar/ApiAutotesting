package com.ehr.methods;

import com.ehr.BaseTest;
import com.ehr.credentials.CredentialsData;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DeleteAndPostTest extends BaseTest {

    /**
     * Used Basic Auth Header
     */
    @Ignore("specify your own authorization")
    @Test
    public void createRepository()throws IOException {
        HttpPost request = new HttpPost(BASE_ENDPOINT + "user/repos");

        String auth = CredentialsData.EMAIL + ":" + CredentialsData.PASSWORD;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        String json = "{\"name\": \"PROJECT_TO_BE_DELETED\"}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();

        assertThat(actualStatusCode, is(equalTo(201)));
    }

    /**
     * Used Token Auth
     */
    @Ignore("specify your own authorization")
    @Test
    public void deleteRepository() throws IOException {
        HttpDelete request = new HttpDelete(BASE_ENDPOINT + "/einhar/PROJECT_TO_BE_DELETED");
        request.setHeader(HttpHeaders.AUTHORIZATION, "token " + CredentialsData.TOKEN);
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();

        assertThat(actualStatusCode, is(equalTo(204)));

    }

}
