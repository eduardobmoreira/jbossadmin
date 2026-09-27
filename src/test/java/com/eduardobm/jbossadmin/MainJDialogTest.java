package com.eduardobm.jbossadmin;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class MainJDialogTest {

    @Test
    void shouldValidateJbossRootDirectory() throws IOException {
        Path tempRoot = Files.createTempDirectory("jboss-eap-7.4");
        Files.createDirectories(tempRoot.resolve("bin"));
        Files.createDirectories(tempRoot.resolve("modules"));

        assertTrue(MainJDialog.isValidJbossPath(tempRoot.toString()));
    }

    @Test
    void shouldRejectNonJbossDirectory() throws IOException {
        Path tempRoot = Files.createTempDirectory("not-jboss");
        Files.createDirectories(tempRoot.resolve("tmp"));

        assertFalse(MainJDialog.isValidJbossPath(tempRoot.toString()));
    }
}
