package origo.parser;

import static origo.parser.HTMLparser.*;

public class Main {
    static String[] links = {
            "http://cimkezes.origo.hu/cimkek/korrupcio/index.html?tag=korrupci%F3&hits=600",
            "http://cimkezes.origo.hu/cimkek/korrupcio/index.html?tag=korrupci%F3&hits=600&offset=600",
            "http://cimkezes.origo.hu/cimkek/korrupcio/index.html?tag=korrupci%F3&hits=600&offset=1200"
    };
    static String[] links2 = {
            "http://cimkezes.origo.hu/cimkek/microsoft/index.html?tag=Microsoft&offset=0&hits=600",
            "http://cimkezes.origo.hu/cimkek/microsoft/index.html?tag=Microsoft&hits=600&offset=600",
            "http://cimkezes.origo.hu/cimkek/microsoft/index.html?tag=Microsoft&hits=600&offset=1200",
            "http://cimkezes.origo.hu/cimkek/microsoft/index.html?tag=Microsoft&hits=600&offset=1800",
            "http://cimkezes.origo.hu/cimkek/microsoft/index.html?tag=Microsoft&hits=600&offset=2400"
    };

    public static void main(String[] args) throws Exception {
        //boilerPipe(getURLs("http://cimkezes.origo.hu/cimkek/microsoft/index.html?tag=Microsoft&offset=0&hits=3000"));
        //ElasticSearch.main(HTMLparser.getURLs(links), "korrupció");
        //writeToFile(HTMLparser.getURLs(links), "./korrupcio.txt");
        //ElasticSearch.main(HTMLparser.getURLs(links2), "microsoft");
        //writeToFile(HTMLparser.getURLs(links2), "./microsoft.txt");
        ElasticSearch.main(HTMLparser.getURLs(links2), "microsoft");
    }
}