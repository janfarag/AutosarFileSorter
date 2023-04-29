

import java.io.*;
import java.util.*;
import java.lang.*;

public class Main  {
    public static void main(String[] arguments) {
        try{
            String inputFileName = arguments[0];
            if(!inputFileName.endsWith(".arxml")){
                throw new InvalidAutosarFileException();
            }
            File inputFile = new File(inputFileName);
            FileInputStream inputStream = new FileInputStream(inputFile);
            int character;
            StringBuilder stringBuilder = new StringBuilder();
            if (inputFile.length() == 0 ){
                throw new RuntimeException("EmptyAutosarFileException");
            }
            while((character=inputStream.read()) != -1){
                stringBuilder.append((char) character);
            }

            String data = stringBuilder.toString();
            Scanner scanner = new Scanner(data);
            ArrayList<AutosarContainer>  autosarContainers = new ArrayList<>();
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.contains("<CONTAINER")){
                    String uuid = line.substring(line.indexOf("UUID="),line.indexOf(">"));
                    String shortNameTag = scanner.nextLine();
                    String shortName = shortNameTag.substring(shortNameTag.indexOf(">")+1,shortNameTag.indexOf("</"));
                    String longNameTag = scanner.nextLine();
                    String longName = longNameTag.substring(longNameTag.indexOf(">")+1,longNameTag.indexOf("</"));
                    AutosarContainer autosarContainer = new AutosarContainer();
                    autosarContainer.setUuid(uuid);
                    autosarContainer.setShortNameTag(shortName);
                    autosarContainer.setLongNameTag(longName);
                    autosarContainers.add(autosarContainer);
                }
            }
            Collections.sort(autosarContainers);
            String outputFileName = inputFileName.substring(0,inputFileName.indexOf("."))+"_mod.arxml";
            FileOutputStream   outputStream = new FileOutputStream(outputFileName);
            outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            outputStream.write("<AUTOSAR>\n\n".getBytes());
            for (int i =0; i< autosarContainers.size(); i++){
                outputStream.write(autosarContainers.get(i).toString().getBytes());
            }

            outputStream.write("<AUTOSAR>\n".getBytes());

        }  catch(InvalidAutosarFileException e){
            e = new InvalidAutosarFileException("Not valid Autosar file");
        }
        catch(FileNotFoundException e) {
            e = new FileNotFoundException("File  is not found!");
        }
        catch (IOException e){
            e = new IOException("IOException!");

        }



    }
}