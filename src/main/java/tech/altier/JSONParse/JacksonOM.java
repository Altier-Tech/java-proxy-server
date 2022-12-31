package tech.altier.JSONParse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class JacksonOM {
    public static Map<String, String> mapStringToJSON(String input) throws IOException {
        return new ObjectMapper().readValue(input.getBytes(), new TypeReference<Map<String,String>>(){});
    }
}
