package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    static final String EXAMPLE_STRING = """
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
        Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
        Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
        Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
        """;

    public void write(String output) {
        try (var writer = new FileWriter(output)) {
            writer.write(EXAMPLE_STRING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
