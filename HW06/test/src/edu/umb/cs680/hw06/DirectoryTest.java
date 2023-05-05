package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;



public class DirectoryTest extends TestFixatureInitializer{



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
        LocalDateTime localDateTime = LocalDateTime.now();
        Directory temp = new Directory(src, "temp", 0, localDateTime);
        assertEquals(3, src.getChildren().size());
        assertEquals(src, temp.getParent());
    }



    @Test
    public void testSubDirectories() {
        assertEquals(3, prjRoot.getSubDirectories().size());
        assertEquals(1, src.getSubDirectories().size()); // src has a subDir called temp(testAppendChildre())
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
        assertEquals(150, src.getTotalSize());
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
