package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class LinkTest extends TestFixatureInitializer{

    private static LocalDateTime localDatetTime;

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
