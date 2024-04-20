package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Verifier {
    public static boolean verifyInputJson(String filePath) {
        try {
            // Read JSON file
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject json = new JSONObject(content);

            // Get Statement array from PolicyDocument
            JSONObject policyDocument = json.getJSONObject("PolicyDocument");
            JSONArray statements = policyDocument.getJSONArray("Statement");

            // Check Resource field in each statement
            for (int i = 0; i < statements.length(); i++) {
                JSONObject statement = statements.getJSONObject(i);
                String resource = statement.optString("Resource", "");

                // If Resource contains a single asterisk, return false
                if ("*".equals(resource)) {
                    return false;
                }
            }

            // If no statement contains a single asterisk, return true
            return true;

        } catch (IOException e) {
            System.out.println("An error occurred while reading the JSON file: " + e.getMessage());
            return false;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        String path = "C:\\Users\\Vecza\\IntelliJ_Projects\\Verifier\\resources\\example.json";
        System.out.println(verifyInputJson(path));
        path = "C:\\Users\\Vecza\\IntelliJ_Projects\\Verifier\\resources\\example2.json";
        System.out.println(verifyInputJson(path));
    }
}