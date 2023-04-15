package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;



public class DirectoryTest {

    private static LocalDateTime localDatetTime;

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

    Link y = new Link(prjRoot, "y", 0, localDatetTime, d);


    @Test
    public void testGetChildren() {
        assertEquals(4, prjRoot.getChildren().size());
        //System.out.println(root.getChildren());
        assertEquals(2, src.getChildren().size());
        //System.out.println(home.getChildren());
        assertEquals(1, lib.getChildren().size());
        assertEquals(1, test.getChildren().size());
    }

    @Test
    public void testAppendChildren() {
        Directory temp = new Directory(prjRoot, "temp", 0, localDatetTime);
        assertEquals(5, prjRoot.getChildren().size());
        assertEquals(prjRoot, temp.getParent());
    }


    @Test
    public void testSubDirectories() {
        assertEquals(3, prjRoot.getSubDirectories().size());
        assertEquals(0, src.getSubDirectories().size());
        assertEquals(0, lib.getSubDirectories().size());
        assertEquals(1, test.getSubDirectories().size());

    }

    @Test
    public void testGetFiles() {
        assertEquals(1, prjRoot.getFiles().size());
        assertEquals(2, src.getFiles().size());
        assertEquals(1, lib.getFiles().size());
        assertEquals(0, test.getFiles().size());
    }

    @Test
    public void testGetTotalSize() {
        assertEquals(625, prjRoot.getTotalSize());
    }

    private String[] dirToStringArray(Directory d) {
        String[] dirInfo = {d.getName(), String.valueOf(d.getTotalSize()), String.valueOf(d.getCreationTime())};
        return dirInfo;
    }

    @Test
    public void verifyDirEqualityWithNameSizeAndCreationTime() {
        String[] expected = {"parentDir", "12345", "2022-03-31T15:22:30.345"};
        Directory actual = new Directory(null, "parentDir", 12345, LocalDateTime.parse("2022-03-31T15:22:30.345"));
        assertArrayEquals(expected, dirToStringArray(actual));
    }




}