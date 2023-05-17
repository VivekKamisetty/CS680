package edu.umb.cs680.hw12.util;

import edu.umb.cs680.hw12.fs.Directory;
import edu.umb.cs680.hw12.fs.FSVisitor;
import edu.umb.cs680.hw12.fs.File;
import edu.umb.cs680.hw12.fs.Link;

public class CountingVisitor implements FSVisitor {

    int fileCount = 0;
    int dirCount = 0;
    int linkCount = 0;

    @Override
    public void visit(Link link) {
//        System.out.println("link count call");
        linkCount++;
    }

    @Override
    public void visit(Directory dir) {
//        System.out.println("dir count call");
        dirCount++;
    }

    @Override
    public void visit(File file) {
//        System.out.println("file count call");
        fileCount++;
    }

    public int getFileCount() {
//        System.out.println("getfilecount");
        return fileCount;
    }

    public int getDirCount() {
//        System.out.println("getdircount");
        return dirCount;
    }

    public int getLinkCount() {
//        System.out.println("getlinkcount");
        return linkCount;
    }
}
