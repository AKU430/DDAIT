package org.discord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    public static String readToken() {
        try {
            return Files.readString(Path.of("BOTTOKEN.token"));
        } catch (IOException e) {
            e.printStackTrace(System.err);
            return "";
        }
    }
}
