package origo.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.document.TextDocument;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import de.l3s.boilerpipe.sax.BoilerpipeSAXInput;
import de.l3s.boilerpipe.sax.HTMLDocument;
import de.l3s.boilerpipe.sax.HTMLFetcher;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static origo.parser.Main.links;
import static origo.parser.Main.links2;

public class ElasticSetup {
    private static final String PATH = "./src/main/resources/";

    public static void main(String[] args) throws IOException {
        indexMapper("microsoft");
        elasticConnector(HTMLparser.getURLs(links2), "microsoft");
    }

    public static void indexMapper(String tag) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")
                ));
        ObjectMapper mapper = new ObjectMapper();
        File from = new File(PATH + "template.json");
        TypeReference<HashMap<String,Object>> typeRef
                = new TypeReference<HashMap<String,Object>>() {};

        HashMap<String,Object> map = null;
        try {
            map = mapper.readValue(from, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(tag);
        try {
            client.indices().create(createIndexRequest.mapping("doc", map));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void elasticConnector(Set <String> relevantUrls, String tag) throws IOException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy.MM.dd");
        Date date = null;
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")
                ));
        IndexRequest indexRequest = new IndexRequest(tag, "doc");
        for (String temp : relevantUrls) {
            final String regex = "\\d{4}\\.(0?[1-9]|1[012])\\.(..)";
            final HTMLDocument htmlDoc = HTMLFetcher.fetch(new URL(temp));
            TextDocument doc = null;
            try {
                doc = new BoilerpipeSAXInput(htmlDoc.toInputSource()).getTextDocument();
            } catch (BoilerpipeProcessingException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            URL url = new URL(temp);
            String text = null;
            try {
                text = ArticleExtractor.INSTANCE.getText(url);
            } catch (BoilerpipeProcessingException e) {
                e.printStackTrace();
            }
            Map <String, Object> jsonMap = new HashMap <>();
            final Pattern pattern = Pattern.compile(regex);
            final Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                try {
                    date = parser.parse(matcher.group(0));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                jsonMap.put("date", date);
                System.out.println(matcher.group(0));
            }
            jsonMap.put("title", doc.getTitle());
            jsonMap.put("content", text);
            try {
                client.index(indexRequest.source(jsonMap));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
