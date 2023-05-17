package edu.umb.cs680.hw12.fs;

import edu.umb.cs680.hw12.TestFixatureInitializer;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlphabeticalComparatorTest extends TestFixatureInitializer {


    @Test
    public void getChildrenAlphabeticallySortedTest() {
        List<FSElement> alpha = List.of(lib, src, test, x, y);
        assertEquals(alpha, prjRoot.getChildren(new AlphabeticalComparator()));
        //System.out.println(prjRoot.getChildren(new AlphabeticalComparator()));
    }

    @Test
    public void getSubDirectoriesAlphabeticallySortedTest() {
        List<FSElement> alpha = List.of(lib, src, test);
        assertEquals(alpha, prjRoot.getSubDirectories(new AlphabeticalComparator()));
    }

    @Test
    public void getFilesAlphabeticallySortedTest() {
        List<FSElement> alpha = List.of(a, b);
        assertEquals(alpha, src.getFiles(new AlphabeticalComparator()));
    }
}