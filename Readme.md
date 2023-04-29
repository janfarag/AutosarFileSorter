AutosarFileSorter
AutosarFileSorter is a Java program that reads an ARXML file containing a list of containers, each with a unique ID, and reorders the containers alphabetically by their SHORT-NAME element. The program then writes the reordered containers to a new ARXML file.

Requirements
Java 8 or higher
An ARXML input file containing a list of containers with SHORT-NAME elements

Usage
To run the program, use the following command:

Copy
java AutosarFileSorter inputfile.arxml
Replace inputfile.arxml with the name of your ARXML input file.

The program will output the sorted containers to a new ARXML file with the same name as the input file, but with the _mod.arxml suffix.

Exceptions
The program may throw two types of exceptions:

NotValidAutosarFileException: if the input file does not have the .arxml extension
EmptyAutosarFileException: if the input file is empty
If an exception occurs, the program will output an error message to the console and terminate.

Batch File
Included in this repository is a sample batch file run.bat that you can use to run the program with the three possible cases: normal case, invalid file case, and empty file case.

To use the batch file, follow these steps:

Open run.bat in a text editor
Modify the inputfile variable to the name of your input file
Save the file and close the text editor
Double-click run.bat to run the program with the specified input file
The batch file will compile the Java program and run it with the specified input file. If the input file is not valid or empty, the program will output an error message to the console and terminate.

License
AutosarFileSorter is licensed under the MIT license. See LICENSE for details.