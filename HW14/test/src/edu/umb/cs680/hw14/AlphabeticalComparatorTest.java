package edu.umb.cs680.hw14;

import edu.umb.cs680.hw14.fs.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlphabeticalComparatorTest extends TestFixatureInitializer{

    @Test
    public void getChildrenAlphabeticallySortedTest() {
        List<FSElement> alpha = List.of(lib, src, test, x, y);
        assertEquals(alpha, prjRoot.getChildren((obj1, obj2) -> obj1.getName().compareTo(obj2.getName())));
        //System.out.println(prjRoot.getChildren(new AlphabeticalComparator()));
    }

    @Test
    public void getSubDirectoriesAlphabeticallySortedTest() {
        List<FSElement> alpha = List.of(lib, src, test);
        assertEquals(alpha, prjRoot.getSubDirectories((obj1, obj2) -> obj1.getName().compareTo(obj2.getName())));
    }

    @Test
    public void getFilesAlphabeticallySortedTest() {
        List<FSElement> alpha = List.of(a, b);
        assertEquals(alpha, src.getFiles((obj1, obj2) -> obj1.getName().compareTo(obj2.getName())));
    }
}