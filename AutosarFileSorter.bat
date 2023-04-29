@echo off
javac *.java
java Main input.arxml
java Main inputEmpty.arxml
java Main notvalid.ccc
pause