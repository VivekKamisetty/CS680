package edu.umb.cs680.hw15.fs;

import java.util.LinkedList;

public class FileSystem {

    private final LinkedList<Directory> rootDirs;

    private FileSystem() {
        rootDirs = new LinkedList<Directory>();
    }

    private static FileSystem fileSystem;

    public static FileSystem getFileSystem() {
        if(fileSystem == null) {
            fileSystem = new FileSystem();
        }
        return fileSystem;
    }

    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
    }

    public void appendRootDir(Directory root) {
        rootDirs.add(root);
    }
}