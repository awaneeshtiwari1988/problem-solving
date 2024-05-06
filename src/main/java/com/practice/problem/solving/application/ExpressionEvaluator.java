package com.practice.problem.solving.application;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionEvaluator {
    private static Map<String, Map<String, String>> memoryMap = new HashMap<>();

    public String evaluateExpression(JsonObject expressionObj, String groupName) {
        String expressionName = expressionObj.get("name").getAsString();
        String expressionType = expressionObj.get("expressionType").getAsString();
        String expression = expressionObj.get("expression").getAsString();

        // Check if dependencies are present
        JsonArray dependencies = expressionObj.getAsJsonArray("dependencies");
        for (JsonElement dependencyElement : dependencies) {
            String dependency = dependencyElement.getAsString();
            String cachedValue = memoryMap.get(groupName).get(dependency);
            expression = expression.replace("${" + dependency + "}", cachedValue);
        }

        // Evaluate the expression based on its type
        switch (expressionType) {
            case "DIRECT":
                break; // No additional processing needed for DIRECT expressions
            case "RS_EXPRESSION":
                expression = "{" + expression + "} RS";
                break;
            case "DOLLAR_EXPRESSION":
                expression = "$(" + expression + ") $";
                break;
            default:
                // Handle unsupported expression types
                break;
        }

        // Cache the evaluated value
        memoryMap.get(groupName).put(expressionName, expression);

        return expressionName + ":" + expression;
    }

    public String evaluateGroupExpressions(JsonArray expressions, String groupName) {
        // Evaluate all expressions within a group
        StringBuilder result = new StringBuilder(groupName + ":");
        for (JsonElement expressionElement : expressions) {
            JsonObject expression = expressionElement.getAsJsonObject();
            result.append(evaluateExpression(expression, groupName)).append(":");
        }
        return result.deleteCharAt(result.length() - 1).toString(); // Remove trailing colon and return as String
    }

    public List<String> evaluateAllGroups(JsonArray groups) {
        // Main function to evaluate all expression groups
        List<String> results = new ArrayList<>();
        for (JsonElement groupElement : groups) {
            JsonObject group = groupElement.getAsJsonObject();
            String groupName = group.get("groupName").getAsString();
            JsonArray expressions = group.getAsJsonArray("expressions");
            memoryMap.put(groupName, new HashMap<>());
            results.add(evaluateGroupExpressions(expressions, groupName));
        }
        return results;
    }

    public static void main(String[] args) {
        String inputJson = "[{\"groupName\":\"Group1\",\"expressions\":[{\"name\":\"a\",\"expressionType\":\"DIRECT\",\"expression\":\"10\",\"dependencies\":[]},{\"name\":\"b\",\"expressionType\":\"RS_EXPRESSION\",\"expression\":\"${a} + 10\",\"dependencies\":[\"a\"]},{\"name\":\"c\",\"expressionType\":\"DOLLAR_EXPRESSION\",\"expression\":\"${a} + 10\",\"dependencies\":[\"a\"]}]},{\"groupName\":\"Group2\",\"expressions\":[{\"name\":\"a\",\"expressionType\":\"DIRECT\",\"expression\":\"20\",\"dependencies\":[]},{\"name\":\"b\",\"expressionType\":\"RS_EXPRESSION\",\"expression\":\"${a} + 10\",\"dependencies\":[\"a\"]}]},{\"groupName\":\"Group3\",\"expressions\":[]}]";
        JsonArray groups = new Gson().fromJson(inputJson, JsonArray.class);

        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        List<String> results = evaluator.evaluateAllGroups(groups);
        for (String result : results) {
            System.out.println(result);
        }
    }
}

