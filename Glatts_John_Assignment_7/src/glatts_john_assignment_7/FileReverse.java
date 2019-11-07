package glatts_john_assignment_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReverse {
    
    protected File file;
    protected ArrayList<String> list = new ArrayList<>();  
    
    public FileReverse(File f) throws FileNotFoundException {
        this.file = f;
        readFile();
    }
    
    private void readFile() throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        while(scan.hasNext()) {
            list.add(scan.nextLine());
        }
    }
    
    public void reverse() {
        ArrayList<String> newList = new ArrayList<>();
        int count = 0;
        for(int i = list.size()-1; i > 0; --i, ++count)
              newList.add(list.get(i));
        this.list = newList;
    }
    
    public void printFile() {
        list.forEach((s) -> {
            System.out.println(s);
        });
    }   
    
}
