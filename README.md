# Verifier
Verifier is a Java class that provides a method to verify input JSON files based on certain criteria. It is designed to check whether the JSON data conforms to specific requirements regarding the "Resource" field in each statement of the AWS IAM Policy Document.

## Usage
The verifyInputJson method in the Verifier class takes a file path as input and returns true if the JSON data meets the specified criteria, and false otherwise.

To use the verifyInputJson method, simply call it and provide the file path of the JSON file to be verified:
```java
String filePath = "path/to/your/json/file.json";
boolean result = Verifier.verifyInputJson(filePath);
System.out.println("Input JSON is " + (result ? "valid." : "not valid."));
```

## Dependencies
This project requires the org.json library, which is used for manipulating JSON data in Java. Ensure that you have added the appropriate dependency to your project.
And also uses org.junit.jupiter. This dependency is used for writing and executing unit tests using JUnit 5.

## Example
Here's an example of how to use the Verifier class:
```java
public static void main(String[] args) {
    String path = "path/to/your/json/file.json";
    System.out.println(Verifier.verifyInputJson(path));
}
```
