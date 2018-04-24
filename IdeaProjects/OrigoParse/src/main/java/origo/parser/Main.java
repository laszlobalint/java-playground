package origo.parser;

import static origo.parser.HTMLparser.*;

public class Main {

    public static void main(String[] args) throws Exception {
        //boilerPipe(getURLs("http://cimkezes.origo.hu/cimkek/microsoft/index.html?tag=Microsoft&offset=0&hits=3000"));
        //ElasticSearch.main(HTMLparser.getURLs("http://cimkezes.origo.hu/cimkek/microsoft/index.html?tag=Microsoft&offset=0&hits=3000"), "microsoft");
        ElasticSearch.main(HTMLparser.getURLs("http://cimkezes.origo.hu/cimkek/korrupcio/index.html?tag=korrupci%F3&hits=10000"), "korrupcio");
    }
}