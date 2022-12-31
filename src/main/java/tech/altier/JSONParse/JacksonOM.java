package tech.altier.JSONParse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class JacksonOM {
    public static void mapJSON(String input) throws IOException {
        byte[] mapData = input.getBytes();
        Map<String,String> myMap = new ObjectMapper().readValue(mapData, new TypeReference<Map<String,String>>(){});
        System.out.println(
                myMap.get("hello")
        );
    }
}
