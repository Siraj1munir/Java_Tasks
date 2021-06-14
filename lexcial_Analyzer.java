package com.company;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class lexcial_Analyzer {

    public static void main(String[] args) throws IOException {
        fileRead();
    }

    public static void fileRead() {
        try {
            File file = new File("C:/Users/siraj/IdeaProjects/LexicalAnalyzer/src/com/company/me.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                ArrayList<String> datatype = new ArrayList<String>();
                datatype.add("int");
                datatype.add("String");
                datatype.add("double");
                datatype.add("char");
                datatype.add("long");
                datatype.add("array");

                ArrayList<String> accesModeiferArray = new ArrayList<String>();
                accesModeiferArray.add("private");
                accesModeiferArray.add("public");
                accesModeiferArray.add("protected");

                ArrayList<String> con = new ArrayList<String>();
                con.add("if");
                con.add("switch");
                con.add("while");
                con.add("for");
                con.add("do while");

                if (datatype.contains(line)) {
                    stringBuffer.append(line + " (DataType)");
                    stringBuffer.append("\n");
                } else if (accesModeiferArray.contains(line)) {
                    stringBuffer.append(line + " (AccessModifier)");
                    stringBuffer.append("\n");
                } else if (con.contains(line)) {
                    stringBuffer.append(line + " (Condition)");
                    stringBuffer.append("\n");
                } else {
                    stringBuffer.append(line);
                    stringBuffer.append("\n");

                }

            }
            fileReader.close();
            System.out.println("Contents of file:");
            System.out.println(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

