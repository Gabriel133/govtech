# govtech
This is a technical assessement from GovTech that required to write an application/script that when executed in a directory, produces a list of all files (using their absolute paths) containing the keyword "TODO" in them. The files can be in the immediate directory, or a sub-directory (or a sub-directory of the sub-directory, ad infinitum). (Please refer to https://gitlab.com/mycf.sg/challenges/dev-checkin)

## Approach
I used lexical analysis to look for matches instead of regular expression approach and leverage ANTLR(v3.2) parser generator to look for matches. For more detail of Antlr, please refer to https://www.antlr.org/

## Folder Structure
**/src**
 - Contained program source files. There are 3 main components of this program:
   - antlr-3.2.jar: ANTLR parser generator jar
   - JavaCommentLexer.g: a lexer grammar file that composed lexer rules. Rof more detail of writing lexer grammar, please refer to https://en.wikipedia.org/wiki/Regular_expression
   - Main.java: contained program `main` function

**/target-search-dir**
 - Contained all testing files

**/run.bat**
 - For Windows OS only
 - A batch file which contained CMD command that to execute this program
 - User can specify directory in the command
   - Example: `java -cp .;antlr-3.2.jar Main <directory>`

## Build & Run
Following guide for Windows OS only
1. Open CMD and change directory to `./src` directory
2. Build and generate lexer class `java -cp .;antlr-3.2.jar org.antlr.Tool JavaCommentLexer.g`
3. Build the main class of this program `javac -cp .;antlr-3.2.jar Main.java`
4. Run and test the program `java -cp .;antlr-3.2.jar Main .\..\target-search-dir`
