package edu.umb.cs680.hw12.util;

import edu.umb.cs680.hw12.fs.Directory;
import edu.umb.cs680.hw12.fs.FSVisitor;
import edu.umb.cs680.hw12.fs.File;
import edu.umb.cs680.hw12.fs.Link;

import java.util.LinkedList;

public class FileSearchVisitor implements FSVisitor {

    String Filename;
    LinkedList<File> foundFiles = new LinkedList<File>();

    public FileSearchVisitor(String name) {
        this.Filename = name;
    }

    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory dir) {
        return;
    }

    @Override
    public void visit(File file) {
        if (file.getName().equals(Filename)) {
            foundFiles.add(file);
        }
    }

    public LinkedList<File> getFoundFiles() {
        return foundFiles;
    }


}
