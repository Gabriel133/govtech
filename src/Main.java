import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

	// Regex to search \" and \' in the string
	final static String ESCP_QUOTE = "(\\\\\" | \\\\')";
	// Regex to search string with single or double quotes in the content
	final static String STRING = "(\".*\"|\'.*\')";
	// Regex to search template string in the content
	final static String TEMPLATE_STRING = "`(.)*?`";
	// Regex to search comments in the content
	final static String COMMENTS = "//.*|(?s)/\\*(.)*?\\*/";
	// Regex to search TODO keyword
	final static String TODO = "(TODO|todo|Todo|To-do|To-dos)";

	public static void main(String[] args) throws IOException {
		System.out.println("\n-- PROGRAM START --");
		
		String path = args.length != 0 ? args[0] : ".";
		
		if (! (new File(path).isDirectory())) {
			System.out.println("\nPlease specify a valid directory in first argument");
	        System.out.println("\n-- PROGRAM END --");
	        return;
	    }
	    else {
	        List<File> files = new ArrayList<>();
	        System.out.println("\nSearching all files in directory: " + path);

	        // Get all files in the dir (included sub-dir)
	        dirFileList(path, files);
	        
	        // Check is there any file contained TODO keyword in single and multi line comment
	        System.out.println("File(s) contained \'TODO\' comment:");
	        int i = 0;
	        for (File file : files) {
	        	// Check if TODO keyword inside the file content
	        	if (searchTodoFile(file.getPath())) {
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
	
	/**
	 * Print file(s) which contain TODO keyword in the comments 
	 * @param files
	 */
	public static Boolean searchTodoFile(String filePath) {
		Boolean found = false;
		try {
			String fileStr = readFile(filePath);
			// Filter out all string in the file's content
			String filterEscapeQuote = fileStr.replaceAll(ESCP_QUOTE, "{ESCAPE-QUOTE}");
			String filterString = filterEscapeQuote.replaceAll(STRING, "{STRING}");
			String filterTemplateString = filterString.replaceAll(TEMPLATE_STRING, "{TEMPLATE-STRING}");
			
			// Search comments from the file's content
			Pattern commentPattern = Pattern.compile(COMMENTS);
			Matcher matcher = commentPattern.matcher(filterTemplateString);
			while (matcher.find() && !found) {
				String comment = matcher.group();
				// Search keyword from the comment
				Pattern keywordPattern = Pattern.compile(TODO);
				Matcher keyMtchr = keywordPattern.matcher(comment);
				if(keyMtchr.find()) {
					// Print file path once found keyword
					found = true;
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return found;
	}
	
	/**
	 *  Recursively loop through all the file in dir and its sub-dir
	 * @param directoryName
	 * @param files
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
	 * JAVA 7 approach to convert file content to string 
	 * @param path
	 * @return String
	 * @throws IOException
	 */
	public static String readFile(String path) throws IOException {
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded);
	}
}
