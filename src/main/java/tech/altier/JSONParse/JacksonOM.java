package tech.altier.JSONParse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.altier.JProxy.http.GETRequest;

import java.io.IOException;
import java.util.Map;

public class JacksonOM {
    public static GETRequest parseGETRequest(String inputString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(inputString, GETRequest.class);
    }

    public static Map<String, String> mapStringToJSON(String input) throws IOException {
        return new ObjectMapper().readValue(input.getBytes(), new TypeReference<Map<String,String>>(){});
    }
}
