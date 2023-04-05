package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FileTest {
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
        FileSystem fs = FileSystem.getFileSystem();
        Directory root1 = new Directory(null, "root1", 0, LocalDateTime.now());
        fs.appendRootDir(root1);
        Directory apps = new Directory(root1, "apps", 0, LocalDateTime.now());
        File x = new File(apps, "x", 10, LocalDateTime.now());
        File y = new File(apps, "y", 20, LocalDateTime.now());
        assertTrue(x.isFile());
    }




}