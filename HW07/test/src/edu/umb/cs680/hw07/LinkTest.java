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

    private String[] linkToStringArray(Link l) {
        String[] linkInfo = {l.getName(), String.valueOf(l.getSize()), String.valueOf(l.getCreationTime()),l.getTarget().getName().toString()};
        return linkInfo;
    }

    @Test
    public void verifyLinkEqualityWithNameSizeAndCreationTime() {
        String[] expected = {"link", "0", "2022-03-31T15:22:30.345","a"};
        Link actual = new Link(null, "link", 0, LocalDateTime.parse("2022-03-31T15:22:30.345"), a);
        assertArrayEquals(expected, linkToStringArray(actual));
    }




}
