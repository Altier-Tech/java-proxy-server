package tech.altier.JSONParse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.altier.JProxy.models.ClientRequest;
import tech.altier.JProxy.models.HttpMethod;

import java.io.IOException;
import java.util.Map;

public class JacksonOM {
    public static ClientRequest parseClientRequest(String inputString) throws IOException {
        Map<String, String> inputMap = mapStringToMap(inputString);
        return new ClientRequest(
                HttpMethod.valueOf(inputMap.get("method")),
                inputMap.get("endpoint"),
                inputMap.get("version"),
                inputMap.get("body")
        );
    }

    public static Map<String, String> mapStringToMap(String input) throws IOException {
        return new ObjectMapper().readValue(input.getBytes(), new TypeReference<Map<String,String>>(){});
    }
}
