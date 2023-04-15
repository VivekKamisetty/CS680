package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FileTest {

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
        FileSystem fs = FileSystem.getFileSystem();
        Directory prjRoot = new Directory(null, "prjRoot", 100, localDatetTime);
        Directory src = new Directory(prjRoot, "src", 100, localDatetTime);
        Directory lib = new Directory(prjRoot, "lib", 100, localDatetTime);
        Directory test = new Directory(prjRoot, "test", 100, localDatetTime);
        Directory testSrc = new Directory(test, "src", 100, localDatetTime);


        File a = new File(src, "a", 25, localDatetTime);
        File b = new File(src, "b", 25, localDatetTime);
        File c = new File(lib, "c", 25, localDatetTime);
        File d = new File(testSrc, "d", 25, localDatetTime);
        File x = new File(prjRoot, "x", 25, localDatetTime);
        assertTrue(x.isFile());
        assertTrue(a.isFile());
        assertTrue(b.isFile());
        assertTrue(c.isFile());
        assertTrue(d.isFile());

    }






}
