package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.service.WriteToFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Before;
import org.junit.Test;

public class WriteToFileImplTest {
    private final String pathTo = "src/main/resources/res.csv";
    private final String testText = "TASK";
    private WriteToFile writeToFile;

    @Before
    public void setUp() {
        writeToFile = new WriteToFileImpl();
    }

    @Test
    public void writeToFile_Ok() {
        writeToFile.writeFile(Path.of(pathTo), testText);
        try {
            String actual = Files.readString(Path.of(pathTo));
            assertEquals(testText, actual);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}