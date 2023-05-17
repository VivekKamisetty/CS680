package edu.umb.cs680.hw14;

import edu.umb.cs680.hw14.fs.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReverseAlphabeticalComparatorTest extends TestFixatureInitializer{

    @Test
    public void getChildrenReverseAlphabeticallySortedTest() {
        List<FSElement> alpha = List.of(y, x, test, src, lib);
        assertEquals(alpha, prjRoot.getChildren((obj1, obj2) -> obj2.getName().compareTo(obj1.getName())));
        //System.out.println(prjRoot.getChildren(new AlphabeticalComparator()));
    }

    @Test
    public void getSubDirectoriesReverseAlphabeticallySortedTest() {
        List<FSElement> alpha = List.of(test, src, lib);
        assertEquals(alpha, prjRoot.getSubDirectories((obj1, obj2) -> obj2.getName().compareTo(obj1.getName())));
    }

    @Test
    public void getFilesReverseAlphabeticallySortedTest() {
        List<FSElement> alpha = List.of(b, a);
        assertEquals(alpha, src.getFiles((obj1, obj2) -> obj2.getName().compareTo(obj1.getName())));
    }
}