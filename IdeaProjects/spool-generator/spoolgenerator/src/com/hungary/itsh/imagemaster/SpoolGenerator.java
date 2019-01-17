package com.hungary.itsh.imagemaster;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class SpoolGenerator {

    private static int numOfDocs;
    private static String sourceFileExtension;
    private static String attachmentFileExtension;
    private static String spoolName;
    private static String sep;

    private static String currencies[] = {"EUR", "HUF", "RSD", "USD", "GBP", "BRL", "AUD", "CAD", "HRK"};

    public static void main(String[] args) {
        numOfDocs = Integer.parseInt(args[0]);
        sourceFileExtension = args[1];
        attachmentFileExtension = args[2];
        spoolName = args[3];
        sep = args[4];

        createRandomDocument();
    }

    private static void createRandomDocument() {
        for (int num = 0; num < numOfDocs; num++) {
            String field1_invoiceNumber = String.valueOf((int)Math.floor(Math.random() * 9999 + 1));
            String field2_invoiceDate = getRandomDate();
            String field3_grossAmount = String.valueOf(Math.round(getRandomGrossAmount()));
            String field4_netValue = String.valueOf(Math.round(Integer.parseInt(field3_grossAmount) * 0.8));
            String field5_currency = currencies[new Random().nextInt(currencies.length)];
            String field6_taxAmount = String.valueOf(Math.round(Integer.parseInt(field3_grossAmount) * 0.2));
            String field7_attachment = spoolName + num + "." + attachmentFileExtension;
            String content = field1_invoiceNumber + sep + field2_invoiceDate + sep + field3_grossAmount + ".00" + sep + field4_netValue + ".00" +
                    sep + field5_currency + sep + field6_taxAmount + ".00" + sep + field7_attachment;

            writeAndCreateFiles(content, num);
        }
    }

    private static void writeAndCreateFiles(String content, int number) {
        List<String> lines = Arrays.asList(content);
        Path file1 = Paths.get(spoolName + number + "." + sourceFileExtension);
        try {
            Files.write(file1, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path file2 = Paths.get(spoolName + number + "." + attachmentFileExtension);
        try {
            Files.write(file2, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getRandomDate() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randomIntBetween(1980, 2019);
        gc.set(gc.YEAR, year);
        int dayOfYear = randomIntBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return new SimpleDateFormat("dd.MM.yyyy").format(gc.getTime());
    }

    private static int randomIntBetween(int start, int end) {

        return start + (int)Math.round(Math.random() * (end - start));
    }

    private static int getRandomGrossAmount() {
        int max = 1000000;
        int min = 500;

        return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
    }
}