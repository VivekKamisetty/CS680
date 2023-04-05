package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class LinkTest {

    private static LocalDateTime localDatetTime;

    Directory root = new Directory(null, "Root", 100, localDatetTime);
    Directory home = new Directory(root, "home", 75, localDatetTime);
    Directory applications = new Directory(root, "applications", 25, localDatetTime);

    File file1 = new File(home, "file1", 25, localDatetTime);
    File file2 = new File(home, "file2", 25, localDatetTime);
    File file3 = new File(home, "file3", 25, localDatetTime);
    File file4 = new File(applications, "file4", 25, localDatetTime);

    Link myfile1 = new Link(root, "myfile1", 25, localDatetTime, file1);
    Link myfile4 = new Link(root, "myfile4", 25, localDatetTime, file4);

    @Test
    public void checkTarget(){
       File expected = file1;
       assertEquals(myfile1.getTarget(), expected);

       expected = file4;
       assertEquals(myfile4.getTarget(), expected);
    }

    @Test
    public void CheckDirectory() {
        assertFalse(myfile1.isDirectory());
        assertFalse(myfile4.isDirectory());
    }

    @Test
    public  void CheckFile() {
        assertFalse(myfile1.isFile());
        assertFalse(myfile4.isFile());
    }

    @Test
    public void checkLink() {
        assertTrue(myfile1.isLink());
        assertTrue(myfile4.isLink());
    }




}
