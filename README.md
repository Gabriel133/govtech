# govtech
This is a Java program to produces a list of all files (using their absolute paths) containing the keyword "TODO" in them. The files can be in the immediate directory, or a sub-directory (or a sub-directory of the sub-directory, ad infinitum).

## Approach
This Java program use **regular expression** to search for the TODO keyword from a list of files under specific directory.

## Folder Structure
**/src**
 - Containd the program source code

**/target-search-dir**
 - Contained all test files

**Test Files Datil:**
| File | Test Detail |
| --- | --- |
| test0.js | JavaScript source file contain TODO keyword in single line comment |
| test1.java | Java source file contain TODO keyword in single line comment |
| test2.js | JavaScript source file contain TODO keyword in multi line comment |
| test3.java | Java source file contain TODO keyword in multi line comment |
| test4.js | JavaScript source file doesn't contain TODO keyword in the comment but there is a TODO keyword found in a string (This file path will not print out) |
| test5.java | Java source file doesn't contain TODO keyword in the comment but there is a TODO keyword found in a string (This file path will not print out) |
| test6.js | JavaScript source file doesn't contain TODO keyword in the comment but there is a TODO keyword found in a template string (This file path will not print out) |

**/run.bat**
 - For Windows user, you can run the program by double click on this `run.bat` file
 - For MacOS or Linux user, please refer to below section **Compile & Run** for more detail
 - User can specify directory in the command of the bat file
   - Example: `java main <directory>`
 

## Compile & Run
1. Open Command Prompt/Terminal and change directory to `./src`
2. Compile the main class of this program `javac main.java`
3. Run and test the program `java main .\..\target-search-dir`
 - User are able to specify directory by changing the run command:
   - Example: `java main <directory>`
