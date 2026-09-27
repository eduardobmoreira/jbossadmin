package com.eduardobm.jbossadmin;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
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

    @Test
    void shouldValidateArtifactExtensions() throws IOException {
        Path artifact = Files.createTempFile("app", ".war");
        assertTrue(MainJDialog.isValidArtifactPath(artifact.toString()));

        Path invalid = Files.createTempFile("notes", ".txt");
        assertFalse(MainJDialog.isValidArtifactPath(invalid.toString()));
    }

    @Test
    void shouldMoveArtifactIntoDeploymentsFolder() throws IOException {
        Path tempRoot = Files.createTempDirectory("jboss-eap-7.4");
        Files.createDirectories(tempRoot.resolve("bin"));
        Files.createDirectories(tempRoot.resolve("modules"));
        Files.createDirectories(tempRoot.resolve("standalone").resolve("deployments"));

        Path artifact = Files.createTempFile(tempRoot, "app", ".jar");

        Path deployedArtifact = MainJDialog.deployArtifactToDeployments(tempRoot.toString(), artifact.toString());

        assertTrue(Files.exists(deployedArtifact));
        assertFalse(Files.exists(artifact));
        assertTrue(deployedArtifact.toString().endsWith("standalone" + File.separator + "deployments" + File.separator + artifact.getFileName()));
    }
}
