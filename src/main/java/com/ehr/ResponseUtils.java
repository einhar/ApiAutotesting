package com.ehr;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ResponseUtils {

    @Deprecated
    public static String getHeaderFromResponse(HttpResponse response, String header) {
        Header[] headers = response.getAllHeaders();
        List<Header> httpHeaders = Arrays.asList(headers);
        String returnHeader = "";

        for (Header h : httpHeaders) {
            if (header.equalsIgnoreCase(h.getName())) {
                returnHeader = h.getValue();
            }
        }

        if (returnHeader.isEmpty()) {
            throw new RuntimeException("Cannot find the header: " + header);
        }

        return returnHeader;
    }

    public static String getHeader(HttpResponse response, String header) {
        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        Header returnHeader = httpHeaders.stream()
                .filter(h -> header.equalsIgnoreCase(h.getName()))
                .findFirst().orElseThrow(() -> new RuntimeException("Cannot find the header: " + header));

        return returnHeader.getValue();
    }

    public static boolean isHeaderPresent(HttpResponse response, String header) {
        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        return httpHeaders.stream()
                .anyMatch(h -> h.getName().equalsIgnoreCase(header));
    }

    public static <T> T unmarshall(HttpResponse response, Class<T> inputClass) throws IOException {

        String jsonBody = EntityUtils.toString(response.getEntity());

        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(jsonBody, inputClass);
    }
}
