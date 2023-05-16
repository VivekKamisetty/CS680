package edu.umb.cs680.hw06;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class FileSystemTest extends TestFixatureInitializer{

    private static LocalDateTime localDatetTime;

    @Test
    void testAppendRootDir() {

        Directory newRootDir = new Directory(null, "newRootDir", 0, localDatetTime);
        fileSystem.appendRootDir(newRootDir);
        assertEquals(1, fileSystem.getRootDirs().size());
        assertEquals(newRootDir, fileSystem.getRootDirs().get(0));
    }

    @Test
    void testGetRootDirs() {

        fileSystem.appendRootDir(prjRoot);
        assertEquals(2, fileSystem.getRootDirs().size());
    }

    @Test
    void SingletonTest(){
        FileSystem fileSystem1 = FileSystem.getFileSystem();
        FileSystem fileSystem2 = FileSystem.getFileSystem();
        assertSame(fileSystem1, fileSystem2);
    }
}
