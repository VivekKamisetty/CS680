package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class LinkTest {

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
    public void checkTarget(){
       File expected = d;
       assertEquals(y.getTarget(), expected);

    }

    @Test
    public void CheckDirectory() {
        assertFalse(y.isDirectory());
    }

    @Test
    public  void CheckFile() {
        assertFalse(y.isFile());
    }

    @Test
    public void checkLink() {
        assertTrue(y.isLink());
    }




}
