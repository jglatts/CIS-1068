package glatts_john_assignment_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReverse {
    
    private final File file;
    private final ArrayList<String> list = new ArrayList<>();  
    private final ArrayList<String> revList = new ArrayList<>();
    private final ArrayList<String> swappedList = new ArrayList<>();
    private final String revFileName = "reversed_file.txt";
    private final String swapFileName = "swapped_file.txt";
    private final PrintStream reversedFile = new PrintStream(new File(revFileName)); 
    private final PrintStream swappedFile = new PrintStream(new File(swapFileName));
    
    /*
        Construct a new FileReverse with the given file
    */ 
    public FileReverse(File f) throws FileNotFoundException {
        this.file = f;
        readFile();
    }
    
    /*
        Read the given file and add to a new list
    */     
    private void readFile() throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        while(scan.hasNext()) {
            list.add(scan.nextLine());
        }
    }
    
    /*
        Reverse the whole file
    */       
    public void reverse() throws IOException {
        for (int i = list.size()-1; i >= 0; --i) {
            String[] words = list.get(i).split(" ");
            String newStr = "";
            for (int x = words.length-1; x >= 0; --x) {
                newStr += words[x] + " ";
            }
            revList.add(newStr);
        }      
        this.printReverseFile(reversedFile, revList);
    }
    
    /*
        Reverse the words on each line of the list
    */       
    public void reverseLines() throws IOException {
        for (int i = 0; i < list.size(); ++i) {
            String[] words = list.get(i).split(" ");
            String newStr = "";
            for (int x = words.length-1; x >= 0; --x) {
                newStr += words[x] + " ";
            }
            swappedList.add(newStr);
        }
        this.printReverseFile(swappedFile, swappedList);
    }
    
    /*
        Print the unaltered list
    */       
    public void printFileString() {
        list.forEach((s) -> {
            System.out.println(s);
        });
    }     
        
    /*
        Return the reversed file location name
    */
    public String getReversedFileName() {
       return revFileName;     
    }
 
    /*
        Return the reversed and swapped file location name
    */    
    public String getSwappedFileName() {
       return swapFileName;    
    }
    
    /*
        Print the reversed file to the given location
    */      
    private void printReverseFile(PrintStream p, ArrayList<String> l) {
        for (int i = 0; i < l.size(); ++i) {
                p.print(l.get(i)); 
                p.println();
        }        
    }
    
}
