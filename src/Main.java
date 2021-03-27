import java.util.List;
import java.io.File;
import java.util.ArrayList;
import org.antlr.runtime.*;

public class Main {

  public static void main(String[] args) throws Exception {

    System.out.println("\n-- PROGRAM START --");

    // Check if args provided
    if (args.length == 0) {
      System.out.println("Please specify directory in first argument");
      System.out.println("-- PROGRAM END --");
      return;
    }
    else {
      String path = args[0];
      // Check if a valid path
      if (! (new File(path).isDirectory())) {
        System.out.println("\nPlease specify a valid directory in first argument");
        System.out.println("\n-- PROGRAM END --");
        return;
      }
      else {
        List<File> files = new ArrayList<>();
        System.out.println("\nSearching all files in directory: " + args[0]);

        // Get all files in the dir (included sub-dir)
        dirFileList(path, files);
        
        // Check is there any file contained TODO keyword in single and multi line comment
        System.out.println("File(s) contained \'TODO\' comment:");
        int i = 0;
        for (File file : files) {
          if (isTodoFound(file.getPath())) {
            i++;
            System.out.println("\t" + i + ". " + file.getCanonicalPath());
          }
        }
        if (i <= 0) {
          System.out.println("\t** No file found **");
        }
      }
      System.out.println("\n-- PROGRAM END --");
    }
  }

  /**
   * Recursively loop through all the file in dir and its sub-dir
   */
  public static void dirFileList(String directoryName, List<File> files) {
    File directory = new File(directoryName);

    // Get all files from a directory
    File[] fList = directory.listFiles();
    if(fList != null) {
      for (File file : fList) {      
        if (file.isFile()) {
          files.add(file);
        } else if (file.isDirectory()) {
          // Recursively loop through sub-dir
          dirFileList(file.getPath(), files);
        }
      }
    }
  }

  /**
   * Using lexical analysis to look for matches 
   * instead of regex approach.
   * Leverage Antlr(v3.2) parser generator to
   * look for matches.
   */
  public static Boolean isTodoFound(String fileName) throws Exception {
    ANTLRFileStream input = new ANTLRFileStream(fileName);
    // Create lexer instance with the file content
    JavaCommentLexer lexer = new JavaCommentLexer(input);
    // Get the tokens for the lexer
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    
    Boolean isTodoFound = false;

    for(Object obj : tokens.getTokens()) {
      CommonToken token = (CommonToken)obj;
      if(token.getType() == JavaCommentLexer.SingleLineComment 
          || token.getType() == JavaCommentLexer.MultiLineComment) {
        isTodoFound = true;
        break;
      }
    }

    return isTodoFound;
  }
  
}