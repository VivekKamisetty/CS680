package edu.umb.cs680.hw08;

import edu.umb.cs680.hw08.fs.*;
import edu.umb.cs680.hw08.fs.util.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileSearchVisitorTest extends TestFixatureInitializer{


    @Test
    public void checkGetFoundFileA() {
        FileSearchVisitor visitor = new FileSearchVisitor("a");
        prjRoot.accept(visitor);
        assertEquals(a.getName(), visitor.getFoundFiles().get(0).getName());
    }

    @Test
    public void checkGetFoundFileB() {
        FileSearchVisitor visitor = new FileSearchVisitor("b");
        prjRoot.accept(visitor);
        assertEquals(b.getName(), visitor.getFoundFiles().get(0).getName());
    }

    @Test
    public void checkGetFoundFileC() {
        FileSearchVisitor visitor = new FileSearchVisitor("c");
        prjRoot.accept(visitor);
        assertEquals(c, visitor.getFoundFiles().get(0));
    }
}
