package origo.parser;

import de.l3s.boilerpipe.extractors.ArticleExtractor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLparser {
    static DBConnect db = new DBConnect("root", "toor");
    static String sql = "SELECT * FROM origo";

    public static void boilerPipe(List relevantUrls) throws Exception {
        ResultSet rs = null;
        for (Object link : relevantUrls) {
            URL url = new URL((String) link);
            String text = ArticleExtractor.INSTANCE.getText(url);
            //writeToFile(text);
            try {
                db.connect();
                db.insertArticle("Microsoft", text);
                rs = db.getStat().executeQuery(sql);

                while (rs.next()) {
                    String keyword = rs.getString("keyword");
                    String content = rs.getString("content");
                    System.out.println();
                    System.out.println("Keyword: " + keyword);
                    System.out.println("Content: " + content);
                    System.out.println("...................");
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        rs.close();
        db.closeConnection();
    }

    public static Set<String> getURLs(String[] urls) throws IOException {
        Set<String> containedUrls = new HashSet <>();
        Set<String> relevantUrls = new HashSet <>();
        for (int i = 0; i < urls.length; i++) {
            Document doc = Jsoup.connect(urls[i]).get();
            String title = doc.title();
            String body = String.valueOf(doc.body());
            String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
            Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
            Matcher urlMatcher = pattern.matcher(body);
            while (urlMatcher.find()) {
                containedUrls.add(body.substring(urlMatcher.start(), urlMatcher.end()));
            }
            for (String url : containedUrls) {
                if (!url.contains("index.html") && url.contains("www.origo.hu") && (url.length() > 35) && !url.contains("(2)") && !url.contains("www.origo.hu//")) {
                    relevantUrls.add(url);
                }
            }
        }
        for (String url : relevantUrls) {
            System.out.println(url);
        }
        return relevantUrls;
    }

    public static void writeToFile(List <String> relevantUrls, String fileName) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        bw.append("Search was completed on: " + dateFormat.format(date) + '\n');
        for (String url : relevantUrls) {
            bw.append(url + "\n");

        }
        bw.flush();
        bw.close();
        System.out.println("Origo articles for tag/keyword 'Korrupció' were saved to file!");
    }
}