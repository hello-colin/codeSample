package hcl;

import com.fasterxml.jackson.databind.node.ArrayNode;
import org.mvel2.MVEL;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonArrayFilter {

    public static void main(String[] args) {
        String jsonArrayStr = "[{\"name\":\"Alice\",\"age\":25,\"city\":\"New York\"},{\"name\":\"Bob\",\"age\":30,\"city\":\"London\"}]";
        String dynamicCondition = " city ~= 'Lon.*'";


        // Step 1: Parse JSON array
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonArray = objectMapper.readTree(jsonArrayStr);

            // Step 2: Filter JSON array
            JsonNode filteredArray = filterJsonArray(jsonArray, dynamicCondition);

            // Step 3: Print filtered JSON array
            System.out.println(filteredArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to filter JSON array based on dynamic conditions
    private static JsonNode filterJsonArray(JsonNode jsonArray, String dynamicCondition) throws IOException {
        JsonNode filteredArray = jsonArray.deepCopy();

        for (int i = filteredArray.size() - 1; i >= 0; i--) {
            JsonNode element = filteredArray.get(i);
            if (!evaluateCondition(element, dynamicCondition)) {
                ((ArrayNode) filteredArray).remove(i);
            }
        }

        return filteredArray;
    }

    // Helper method to evaluate the condition using MVEL expression
    private static boolean evaluateCondition(JsonNode element, String condition) throws IOException {
        Map<String ,String>map=new HashMap<>();
        ObjectMapper objectMapper=new ObjectMapper();
        map=objectMapper.readValue(element.toString(), Map.class);

        return (boolean) MVEL.eval(condition, map);
    }
}
