package com.ehr.api.bodyandheaders;

import com.ehr.api.BaseTest;
import com.ehr.api.entities.User;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BodyWithSimpleMapTest extends BaseTest {

    @Test
    public void returnCorrectLogin() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/einhar");
        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject(jsonBody);

        String loginValue = (String) getValueFor(jsonObject, User.LOGIN);

        assertThat(loginValue, is(equalTo("einhar")));

    }

    @Test
    public void returnCorrectId() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/einhar");
        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject(jsonBody);

        Integer loginValue = (Integer) getValueFor(jsonObject, User.ID);

        assertThat(loginValue, is(equalTo(30666023)));

    }

    private Object getValueFor(JSONObject jsonObject, String key) {
        return jsonObject.get(key);
    }
}
