package Task1;

import Task1.Exceptions.FileOrDirectoryNotExistsException;

import java.io.*;
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

    public void createTxtFile(String name) throws FileOrDirectoryNotExistsException, IOException {
        if (root.equals("")) {
            throw new FileOrDirectoryNotExistsException();
        }

        File text = new File(root + selected + name + ".txt");
        text.createNewFile();
    }

    public void addToTxtFile(String filename, String text) throws FileOrDirectoryNotExistsException {
        File file = new File(root + selected + filename + ".txt");
        if (!file.exists())
            throw new FileOrDirectoryNotExistsException();

        StringBuilder newText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line=reader.readLine())!=null){
                newText.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        newText.append("\n");
        newText.append(text);
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(file))){
            writer.write(newText.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void deleteTxtFile(String filename) {
        File file = new File(root + selected + filename + ".txt");
        if (file.exists())
            file.delete();

    }

    public String getPath() {
        return root + selected;
    }
}
