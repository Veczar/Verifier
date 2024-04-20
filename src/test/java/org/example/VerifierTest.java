package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class VerifierTest {
    @Test
    public void testValidInputJson() {
        String filePath = "C:\\Users\\Vecza\\IntelliJ_Projects\\Verifier\\resources\\example2.json"; // Replace with path to valid JSON file
        assertTrue(Verifier.verifyInputJson(filePath));
    }

    // Test for invalid input JSON containing a single asterisk in Resource field
    @Test
    public void testInvalidInputJson() {
        String filePath = "C:\\Users\\Vecza\\IntelliJ_Projects\\Verifier\\resources\\example.json"; // Replace with path to invalid JSON file
        assertFalse(Verifier.verifyInputJson(filePath));
    }

    // Test for non-existent file
    @Test
    public void testNonExistentFile() {
        String filePath = "C:\\Users\\Vecza\\IntelliJ_Projects\\Verifier\\resources\\example3.json"; // Replace with non-existent file path
        assertFalse(Verifier.verifyInputJson(filePath));
    }

    // Test for IOException when reading file
    @Test
    public void testIOException() {
        String filePath = "unreadable_file.iml"; // Replace with path to unreadable file
        assertFalse(Verifier.verifyInputJson(filePath));
    }
}