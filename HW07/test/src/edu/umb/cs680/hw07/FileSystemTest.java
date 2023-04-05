package edu.umb.cs680.hw07;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class FileSystemTest {

    private static LocalDateTime localDatetTime;



    @Test
    void testAppendRootDir() {

        FileSystem fileSystem = FileSystem.getFileSystem();
        Directory rootDir = new Directory(null, "root", 0, localDatetTime);
        Directory subDir1 = new Directory(rootDir, "subDir1", 0, localDatetTime);
        Directory subDir2 = new Directory(rootDir, "subDir2", 0, localDatetTime);
        File file1 = new File(subDir1, "file1", 100, localDatetTime);
        File file2 = new File(subDir2, "file2", 100, localDatetTime);
        fileSystem.appendRootDir(rootDir);


        Directory newRootDir = new Directory(null, "newRootDir", 0, localDatetTime);
        fileSystem.appendRootDir(newRootDir);
        assertEquals(2, fileSystem.getRootDirs().size());
        assertEquals(newRootDir, fileSystem.getRootDirs().get(1));
    }

    @Test
    void testGetRootDirs() {

        FileSystem fileSystem = FileSystem.getFileSystem();
        Directory rootDir = new Directory(null, "root", 0, localDatetTime);
        Directory subDir1 = new Directory(rootDir, "subDir1", 0, localDatetTime);
        Directory subDir2 = new Directory(rootDir, "subDir2", 0, localDatetTime);
        File file1 = new File(subDir1, "file1", 100, localDatetTime);
        File file2 = new File(subDir2, "file2", 100, localDatetTime);
        fileSystem.appendRootDir(rootDir);
        assertEquals(3, fileSystem.getRootDirs().size());
    }

}