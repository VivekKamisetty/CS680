package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FileTest extends TestFixatureInitializer{

    private static LocalDateTime localDatetTime;
    private String[] fileToStringArray(File f) {
        String[] fileInfo = {f.getName(), String.valueOf(f.getSize()), String.valueOf(f.getCreationTime())};
        return fileInfo;
    }

    @Test
    public void verifyFileEqualityWithNameSizeAndCreationTime() {
        String[] expected = {"file1", "100", "2022-03-31T15:22:30.345"};
        File actual = new File(null, "file1", 100, LocalDateTime.parse("2022-03-31T15:22:30.345"));
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyFileSystemRootDirectories() {
        assertTrue(x.isFile());
        assertTrue(a.isFile());
        assertTrue(b.isFile());
        assertTrue(c.isFile());
        assertTrue(d.isFile());
    }




}