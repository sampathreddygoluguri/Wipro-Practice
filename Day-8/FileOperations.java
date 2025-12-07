import java.io.*;
public class FileOperations {
    public static void main(String[] args) {
        File essayFile = new File("C:\\Users\\sampa\\Downloads\\Wipro\\Day-8\\essay.txt");
        File reportFile = new File("C:\\Users\\sampa\\Downloads\\Wipro\\Day-8\\report.txt");

        //create essay.txt with multiple lines
        try (BufferedWriter essayWriter = new BufferedWriter(new FileWriter(essayFile))) {
            essayWriter.write("This is first line of essay.");
            essayWriter.newLine();
            essayWriter.write("It contains several words.");
            essayWriter.newLine();
            essayWriter.write("Hello! I am Learning Java Programming.");
            essayWriter.newLine();
            essayWriter.write("we are counting lines and words in this file.");
        } catch (IOException e) {
            System.err.println("Error!");
            return;
        }
        int totLines = 0;
        int totWords = 0;

        //open and read essay.txt
        try (BufferedReader essayReader = new BufferedReader(new FileReader(essayFile))) {
            String line;
            while ((line = essayReader.readLine()) != null) {
                totLines++;
                String[] words = line.split(" ");
                totWords += words.length;
            }
        } catch (IOException e) {
            System.err.println("Error!");
        }

        //writing to report.txt
        try (BufferedWriter reportWriter = new BufferedWriter(new FileWriter(reportFile))){
            reportWriter.write("Number of lines: " + totLines);
            reportWriter.newLine();
            reportWriter.write("Number of words: " + totWords);

        } catch (IOException e) {
            System.err.println("Error!");
        }
        System.out.println("Report generated Successfully!");
    }
}
