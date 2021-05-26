package com.hungary.itsh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class XML_Modifier {

    private static final String INFO = "<info roleName";
    private static final String DISPLAY_NAME = "<displayName default";
    private static final String DESCRIPTION = "<description default";
    private static final String ATTRIBUTE = "attributeValue=";
    private static List<String> ROLES_DATA = new ArrayList<>();
    private static String INPUT;
    private static String ROLE_NAME;
    private static String ATTRIBUTE_VALUE;

    public static void main(String[] args) throws IOException {

        if (args.length != 0) {
            INPUT = args[0];
        } else {
            INPUT = "roles_list.txt";
        }

        loadDataFromXMLFile();

        for (String item : ROLES_DATA) {
            ROLE_NAME = item;
            ATTRIBUTE_VALUE = getAttributeValue(ROLE_NAME);
            try {
                getDataFromXMLFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void loadDataFromXMLFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new java.io.File(INPUT)));
        String line = br.readLine();
        while (line != null) {
            ROLES_DATA.add(line);
            line = br.readLine();
        }
        br.close();
    }

    private static void getDataFromXMLFile() throws IOException {

        try {
            List<String> lines = new ArrayList<>();
            String SAMPLE = "xml_sample_file.xml";
            BufferedReader br = new BufferedReader(new FileReader(new java.io.File(SAMPLE)));
            String line = br.readLine();

            while (line != null) {

                if (line.contains(INFO)) {
                    line = line.replace(getRoleValue(line), ROLE_NAME);
                    lines.add(line);
                    line = br.readLine();

                } else if (line.contains(DISPLAY_NAME) || line.contains(DESCRIPTION)) {
                    line = line.replace(getValue(line), ROLE_NAME);
                    lines.add(line);
                    line = br.readLine();

                } else if (line.contains(ATTRIBUTE)) {
                    line = line.replace(changeAttributeValue(line), ATTRIBUTE_VALUE);
                    lines.add(line);
                    line = br.readLine();

                } else {
                    lines.add(line);
                    line = br.readLine();
                }
            }

            Path file = Paths.get(ROLE_NAME + ".xml");
            Files.write(file, lines, Charset.forName("UTF-8"));
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getValue(String line) {
        return line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));
    }

    private static String getRoleValue(String line) {
        return line.substring(line.indexOf("\"") + 1, line.indexOf("\" systemType"));
    }

    private static String changeAttributeValue(String line) {
        return line.substring(line.lastIndexOf("=\"") + 2, line.lastIndexOf("\"/>"));
    }

    private static String getAttributeValue(String tmp) {
        String[] temp = tmp.split("_");
        return temp[temp.length - 2] + " " + temp[temp.length - 1];
    }
}