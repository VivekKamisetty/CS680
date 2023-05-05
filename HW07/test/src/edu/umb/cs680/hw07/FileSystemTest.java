package edu.umb.cs680.hw07;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class FileSystemTest extends TestFixatureInitializer{

    private static LocalDateTime localDatetTime;

    @Test
    void testAppendRootDir() {

        fileSystem.appendRootDir(prjRoot);


        Directory newRootDir = new Directory(null, "newRootDir", 0, localDatetTime);
        fileSystem.appendRootDir(newRootDir);
        assertEquals(2, fileSystem.getRootDirs().size());
        assertEquals(newRootDir, fileSystem.getRootDirs().get(1));
    }

    @Test
    void testGetRootDirs() {

        fileSystem.appendRootDir(prjRoot);
        assertEquals(3, fileSystem.getRootDirs().size());
    }

}