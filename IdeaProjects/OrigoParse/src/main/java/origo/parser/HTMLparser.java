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
import java.util.ArrayList;
import java.util.List;
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
            writeToFile(text);
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

        public static List<String> getURLs (String origoUrl) throws IOException {
            Document doc;
            doc = Jsoup.connect(origoUrl).get();
            String title = doc.title();
            String body = String.valueOf(doc.body());
            List <String> containedUrls = new ArrayList <>();
            List <String> relevantUrls = new ArrayList <>();
            String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
            Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
            Matcher urlMatcher = pattern.matcher(body);
            while (urlMatcher.find()) {
                containedUrls.add(body.substring(urlMatcher.start(0),
                        urlMatcher.end(0)));
            }
            for (String url : containedUrls) {
                //if (url.contains("microsoft") || url.contains("techbazis") && !url.contains("index.html") && !url.contains("facebook.com")) {
                if (!url.contains("index.html") && !url.contains("facebook.com") && !url.contains("origo.hu//")) {
                    relevantUrls.add(url);
                }
            }
            for (String url : relevantUrls) {
                System.out.println(url);
            }
            return relevantUrls;
        }

        public static void writeToFile (String content) throws IOException {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./origo_microsoft.txt", true));
            bw.append("\n" + content + "\n");
            bw.flush();
            bw.close();
            System.out.println("Origo articles for tag/keyword 'Microsoft' were saved to file!");
        }
    }