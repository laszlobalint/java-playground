package origo.parser;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.document.TextDocument;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import de.l3s.boilerpipe.sax.BoilerpipeSAXInput;
import de.l3s.boilerpipe.sax.HTMLDocument;
import de.l3s.boilerpipe.sax.HTMLFetcher;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElasticSearch {

    // ElasticSearch: http://localhost:9200/
    // Kibana: http://localhost:5601/

    public static void main(List relevantUrls, String tag) throws IOException, BoilerpipeProcessingException, SAXException {

        ElasticSearch parser = new ElasticSearch();

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")
                ));
        IndexRequest indexRequest = new IndexRequest(tag, "doc");
        for (int k = 0; k < relevantUrls.size(); k++) {
            final HTMLDocument htmlDoc = HTMLFetcher.fetch(new URL((String) relevantUrls.get(k)));
            final TextDocument doc = new BoilerpipeSAXInput(htmlDoc.toInputSource()).getTextDocument();
            URL url = new URL((String) relevantUrls.get(k));
            String text = ArticleExtractor.INSTANCE.getText(url);
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("url", relevantUrls.get(k));
            jsonMap.put("title", doc.getTitle());
            jsonMap.put("content", text);
            client.index(indexRequest.source(jsonMap));
        }
        client.close();
    }
}