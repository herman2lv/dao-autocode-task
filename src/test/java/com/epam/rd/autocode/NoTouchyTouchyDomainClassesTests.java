package com.epam.rd.autocode;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NoTouchyTouchyDomainClassesTests {

    @Test
    public void testNoChangesToReferenceClasses() throws Exception {
        final Path sources = Paths.get("src/test/resources");
        Files.walk(sources)
                .filter(Files::isRegularFile)
                .filter(p -> p.toString().endsWith(".ref"))
                .peek(p -> System.out.println(p))
                .forEach(ref -> assertSourceEqualsReference(
                        Paths.get(
                                "src/main/java/com/epam/rd/autocode/domain",
                                ref.getFileName().toString().replace(".ref", ".java")),
                        ref));
    }

    private void assertSourceEqualsReference(final Path src, final Path ref) {
        try {
            final List<String> refLines = Files.readAllLines(src);
            final List<String> srcLines = Files.readAllLines(ref);
            assertEquals(src + " was modified", refLines, srcLines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
