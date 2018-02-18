package skaiserUnit1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Sam Kaiser
 * This class, once instantiated, will create a FileInput
 * object using a file name in string form.
 *
 */
public class FileInput {
    private BufferedReader in = null;
    private String fileName;

    public FileInput(String fileName) {
        this.fileName = fileName;
        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File Open Error: " + fileName + " " + e);
        }
    }

    public String fileReadLine() {
        try {
            String line = in.readLine();
            return line;
        } catch (Exception e) {
            System.out.println("File Read Error: " + fileName + " " + e);
            return null;
        }
    }
}
