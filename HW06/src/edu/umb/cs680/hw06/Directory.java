package edu.umb.cs680.hw06;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

    private LinkedList<FSElement> children = new LinkedList<FSElement>();
    private LinkedList<Directory> subDirectories = new LinkedList<Directory>();
    private LinkedList <File> files = new LinkedList<File>();

    Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        // TODO Auto-generated constructor stub
        if (parent != null)
        {
            //System.out.println("Appending....");
            parent.appendChild(this);

        }
        //System.out.println("else Appending....");

    }



    public LinkedList<FSElement> getChildren() {
        return this.children;
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren() {
        return getChildren().size();
    }

    public LinkedList<Directory> getSubDirectories() {
        for( FSElement child : getChildren()) {
            if (child.isDirectory()) {
                subDirectories.add((Directory) child);
            }
        }
        return subDirectories;
    }

    public LinkedList<File> getFiles() {
        for( FSElement child : getChildren()) {
            if (child.isFile()) {
                files.add((File) child);
            }
        }
        return files;
    }

    public int getTotalSize() {
        int totalSize = this.getSize();
        for (FSElement element : this.getChildren()) {
            if (element.isDirectory()) {
                totalSize += ((Directory) element).getTotalSize();
            } else {
                totalSize += element.getSize();
            }
        }
        return totalSize;
    }

    @Override
    public boolean isDirectory() {
        // TODO Auto-generated method stub
        return true;
    }



    @Override
    public boolean isFile() {
        // TODO Auto-generated method stub
        return false;
    }







}
