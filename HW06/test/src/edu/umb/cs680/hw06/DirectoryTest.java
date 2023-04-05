package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;



public class DirectoryTest {

    private static LocalDateTime localDatetTime;

    Directory root = new Directory(null, "Root", 100, localDatetTime);
    Directory home = new Directory(root, "home", 100, localDatetTime);
    Directory applications = new Directory(root, "applications", 0, localDatetTime);

    File file1 = new File(home, "file1", 25, localDatetTime);
    File file2 = new File(home, "file2", 25, localDatetTime);
    File file3 = new File(home, "file3", 25, localDatetTime);
    File file4 = new File(home, "file4", 25, localDatetTime);

    @Test
    public void testGetChildren() {
        assertEquals(2, root.getChildren().size());
        //System.out.println(root.getChildren());
        assertEquals(4, home.getChildren().size());
        //System.out.println(home.getChildren());

    }

    @Test
    public void testAppendChildren() {
        Directory temp = new Directory(home, "temp", 0, localDatetTime);
        assertEquals(5, home.getChildren().size());
        assertEquals(home, temp.getParent());
    }

    @Test
    public void testCountChildren() {
        assertEquals(2, root.getSubDirectories().size());
        assertEquals(0, home.getSubDirectories().size());
    }

    @Test
    public void testSubDirectories() {
        assertEquals(2, root.getSubDirectories().size());
        assertEquals(0, home.getSubDirectories().size());

    }

    @Test
    public void testGetFiles() {
        assertEquals(0, root.getFiles().size());
        assertEquals(4, home.getFiles().size());
    }

    @Test
    public void testGetTotalSize() {
        assertEquals(200, home.getTotalSize());
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
