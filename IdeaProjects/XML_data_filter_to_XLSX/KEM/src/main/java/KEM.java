import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class KEM {
    private static final String ATTR = "<dsml:value>";
    private static final String NAME_ATTR = "name=\"cauid\"";
    private static final String ADMIN_ATTR = "name=\"caAdmin\"";
    private static final String DATE_ATTR = "name=\"caDatelist\"";
    private static final String READ_ATTR = "name=\"caRead\"";
    private static final String MODIFY_ATTR = "name=\"caModify\"";
    private static final String CREATE_ATTR = "name=\"caCreate\"";
    private static final String OPEN_ATTR = "name=\"caOpen\"";
    private static String INPUT;
    private static String OUTPUT;

    public static void main(String[] args) {
        INPUT = args[0];
        OUTPUT = args[1];
        try {
            getDataFromXMLFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getDataFromXMLFile() throws IOException {
        String[] columns = {"Username", "Admin", "DateField", "Read", "Modify", "Create", "Open"};
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("KEM");
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        int rowNum = 1;

        try {
            BufferedReader br = new BufferedReader(new FileReader(new java.io.File(INPUT)));
            String line = br.readLine();

            while (line != null) {

                if (line.toLowerCase().contains(ADMIN_ATTR.toLowerCase()) || line.contains(NAME_ATTR)) {
                    String userName = "";
                    String admin = "";
                    line = br.readLine();

                    if (line.contains("no") || line.contains("yes")) {
                        admin = getValue(line);
                    } else {
                        userName = getValue(line);
                    }

                    if (line.contains(ATTR)) {
                        String date = "";
                        String read = "";
                        String modify = "";
                        String create = "";
                        String open = "";

                        while (!line.contains("</dsml:entry>")) {

                            if (line.contains(NAME_ATTR)) {
                                line = br.readLine();
                                userName = getValue(line);
                                line = br.readLine();

                            } else if (line.contains(CREATE_ATTR)) {
                                line = br.readLine();
                                while (!line.contains("</dsml:attr>")) {
                                    create += getValue(line) + ";";
                                    line = br.readLine();
                                }

                            } else if (line.contains(DATE_ATTR)) {
                                line = br.readLine();
                                while (!line.contains("</dsml:attr>")) {
                                    date += getValue(line) + ";";
                                    line = br.readLine();
                                }

                            } else if (line.contains(MODIFY_ATTR)) {
                                line = br.readLine();
                                while (!line.contains("</dsml:attr>")) {
                                    modify += getValue(line) + ";";
                                    line = br.readLine();
                                }

                            } else if (line.contains(OPEN_ATTR)) {
                                line = br.readLine();
                                while (!line.contains("</dsml:attr>")) {
                                    open += getValue(line) + ";";
                                    line = br.readLine();
                                }

                            } else if (line.contains(READ_ATTR)) {
                                line = br.readLine();
                                while (!line.contains("</dsml:attr>")) {
                                    read += getValue(line) + ";";
                                    line = br.readLine();
                                }

                            } else if (line.contains(ADMIN_ATTR)) {
                                line = br.readLine();
                                while (!line.contains("</dsml:attr>")) {
                                    admin = getValue(line);
                                    line = br.readLine();
                                }

                            } else {
                                line = br.readLine();
                            }
                        }
                        Row row = sheet.createRow(rowNum++);
                        row.createCell(0).setCellValue(userName);
                        row.createCell(1).setCellValue(admin);
                        row.createCell(2).setCellValue(date);
                        row.createCell(3).setCellValue(read);
                        row.createCell(4).setCellValue(modify);
                        row.createCell(5).setCellValue(create);
                        row.createCell(6).setCellValue(open);
                    }
                } else {
                    line = br.readLine();
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        FileOutputStream fileOut = new FileOutputStream(OUTPUT);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }

    private static String getValue(String line) {
        String value = line.substring(line.indexOf(">") + 1, line.lastIndexOf("<"));
        return value;
    }
}