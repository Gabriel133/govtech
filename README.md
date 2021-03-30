# govtech
This is a technical assessement from GovTech that required to write an application/script that when executed in a directory, produces a list of all files (using their absolute paths) containing the keyword "TODO" in them. The files can be in the immediate directory, or a sub-directory (or a sub-directory of the sub-directory, ad infinitum).

## Approach
I used lexical analysis to look for matches instead of regular expression approach and leverage ANTLR(v3.2) parser generator in this program. For more detail of ANTLR, please refer to https://www.antlr.org/

## Folder Structure
**/src**
 - Contained program source files. There are **THREE** main components for this program:
   - antlr-3.2.jar: ANTLR parser generator jar
   - JavaCommentLexer.g: a lexer grammar file that composed lexer rules. For more detail of writing lexer grammar, please refer to https://en.wikipedia.org/wiki/Regular_expression
   - Main.java: contained program `main` function

**/target-search-dir**
 - Contained all test files

**/run.bat**
 - For Windows OS only
 - A batch file which contained CMD command that to execute this program
 - User can specify directory in the command
   - Example: `java -cp .;antlr-3.2.jar Main <directory>`

## Build & Run
*If you only want to start the program, you can directly run it by double click on `run.bat` file*

Following guide for Windows OS only:
1. Open CMD and change directory to `./src` directory
2. Build and generate lexer class `java -cp .;antlr-3.2.jar org.antlr.Tool JavaCommentLexer.g`
3. Build the main class of this program `javac -cp .;antlr-3.2.jar Main.java`
4. Run and test the program `java -cp .;antlr-3.2.jar Main .\..\target-search-dir`
