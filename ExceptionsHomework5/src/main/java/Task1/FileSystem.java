package Task1;

import Task1.Exceptions.FileOrDirectoryNotExistsException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FileSystem {
    private String LOST_FOUND = "lost+found";

    private String selected = "";
    private String root = "";


    public FileSystem() {
    }

    public ArrayList<String> getDirs() throws FileOrDirectoryNotExistsException {
        ArrayList<String> list = new ArrayList<>();

        if (root.equals("")) {
            for (File tmp : File.listRoots()) {
                list.add(tmp.toString());
            }
            return list;
        }

        File selectedDir = new File(root + selected);
        if (selectedDir.list() == null)
            throw new FileOrDirectoryNotExistsException();

        for (String s : selectedDir.list()) {
            if (new File(root + selected + s).isDirectory() && !s.equals(LOST_FOUND)) {
                list.add(s);
            }
        }
        return list;
    }

    public void changeDir(String directory) throws FileOrDirectoryNotExistsException {
        if (root.equals("")) {
            for (String s : getDirs()) {
                if (directory.equals(s)) {
                    root = directory;
                    return;
                }
            }
        } else {
            for (String s : getDirs()) {
                if (directory.equals(s)) {
                    selected += directory + File.separator;
                    return;
                }
            }
        }
        throw new FileOrDirectoryNotExistsException();
    }

    public ArrayList<String> getFiles() throws FileOrDirectoryNotExistsException {
        ArrayList<String> list = new ArrayList<>();

        if (root.equals("")) {
            for (File tmp : File.listRoots()) {
                list.add(tmp.toString());
            }
            return list;
        }

        File selectedDir = new File(root + selected);
        if (selectedDir.list() == null)
            throw new FileOrDirectoryNotExistsException();

        for (String s : selectedDir.list()) {
            if (new File(root + selected + s).isFile()) {
                list.add(s);
            }
        }
        return list;
    }

    public void createTxtFile(String name){
        
    }

    public String getPath() {
        return root+selected;
    }
}
