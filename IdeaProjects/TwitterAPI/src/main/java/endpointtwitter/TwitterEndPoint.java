package endpointtwitter;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.io.IOException;
import java.util.*;

public final class TwitterEndPoint {

    public static final String[] SET_VALUES = new String[] {"18+", "boner" , "PMT", "porn", "porno", "pornography,", "anal", "anilingus", "arse",
            "arsehole", "aussie kiss", "axe wound", "baby batter", "back passage", "bad bitch", "bad bitches", "balloon knot",
            "banging", "bang", "banjee boy", "baps", "bareback", "beat the bishop", "bell-end", "bell end", "bellend", "bint",
            "bisexual", "blowjob", "blowjobs", "bollocking", "bollocks", "boobs", "buff", "bugger", "buggery", "bum", "clunge",
            "cock", "cock tease", "cockblock", "cocktease", "condom", "condomplate", "condoms", "cum", "dangly-bits", "dick",
            "dick inches", "dickhead", "dickheads", "dicks", "dogging", "donkey punch", "doppel banger", "doppelbanger", "fag",
            "faggot", "faggots", "fags", "fap", "felching", "fisting", "fling cleaning", "flirtationship", "frig", "fuckit list",
            "gagging", "get stuffed", "hentai", "heterosexual", "hoes", "homosexual", "hookers", "horny", "hymen", "jackintosh",
            "japanese movies", "jubblies", "kerb crawler", "knackers", "knob", "lady bits", "lesbian", "lesbians", "liptease",
            "manky", "manther", "masturbate", "masturbated", "masturbation", "masturnap", "masturwait", "ninja sex", "nipples",
            "nookie", "nsfw", "nude", "nudes", "paedophile", "penis", "pervy", "porn", "porn moment", "pornocchio", "pornstars",
            "procrasturbating", "pussy", "puta", "quim", "rape", "raping", "road bone", "sapiosexual", "screwvenir", "serosorting",
            "sex", "sexorcism", "sexual", "shag", "shagged", "skank", "slag", "slut", "snog", "spanking", "spiders", "sporking",
            "starkers", "thirst trap", "thirst traps", "thirsty girl", "thirsty girls", "thirsty guy", "thirsty guys", "thrupney bits",
            "tinder glow", "tits", "viagra", "wank", "wanker", "y-fronts", "thirsty nigga", "thirsty niggas", "thirsty gay", "thirsty gays",
            "thirsty ass", "sexy ass", "be thirsty", "soo thirsty", "too thirsty", "fucking bitch", "fucking bitches", "sext", "get fucked",
            "getting fucked", "gettin fucked", "make love", "making love", "makin love", "hot movie", "hot short movie", "sexy",
            "contraception", "contraceptive", "first night", "strip club", "erotic", "cakeboy", "cake guy", "your nuts", "dhick",
            "lick my nuts", "fuck", "fucking", "fuckin", "fucks", "fucked", "fuckboi", "bitch", "hoe", "bitches", "hoes", "shit", "dick", "cunt",
            "cunts", "ass", "asshole", "wtf"};
    public static final Set<String> MY_SET = new TreeSet <>(Arrays.asList(SET_VALUES));

    public static void main(String[] args) {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey("uRW6AJbfloNkLd4TuUtQtQBNh")
                .setOAuthConsumerSecret("BuZ1m7DTj06zwafIZVhicrTaiEXJt2pfPccJ6WegXsjkzfLZ0P")
                .setOAuthAccessToken("989077780007661571-PsYu563dRxS1gF9xUC2xOWGuPepMje9")
                .setOAuthAccessTokenSecret("9ZjUdlujMfIMWJBIQH6d7sHKzEfGd1GGnA052ON2NC5ZP");

        TwitterStream twitterStream = new TwitterStreamFactory(cb.build())
                .getInstance();

        StatusListener listener = new StatusListener() {

            @Override
            public void onStatus(Status status) {
                boolean loop = false;
                int i = 0;
                while (!loop && i < SET_VALUES.length) {
                    loop = status.getText().contains(SET_VALUES[i]);
                    i++;
                }
                if (!loop && status.getLang().equals("en")) {
                    System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
                    JSONObject datas = new JSONObject();
                    JSONObject users = new JSONObject();
                    JSONObject tweets = new JSONObject();

                    JSONArray text = new JSONArray();
                    JSONArray id_str = new JSONArray();
                    JSONArray created_at = new JSONArray();
                    JSONArray screen_name = new JSONArray();
                    JSONArray geolocation = new JSONArray();
                    JSONArray language = new JSONArray();

                    text.put(status.getText());
                    id_str.put(status.getId());
                    created_at.put(status.getCreatedAt());
                    screen_name.put(status.getUser().getScreenName());
                    geolocation.put(status.getGeoLocation());
                    language.put(status.getLang());
                    try {
                        tweets.put("text", text);
                        tweets.put("id_str", id_str);
                        tweets.put("created_at", created_at);

                        users.put("screen_name", screen_name);
                        users.put("geolocation", geolocation);
                        users.put("language", language);
                        datas.put("users", users);
                        datas.put("tweets", tweets);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    RestHighLevelClient client = new RestHighLevelClient(
                            RestClient.builder(
                                    new HttpHost("localhost", 9200, "http")
                            ));
                    IndexRequest indexRequest = new IndexRequest("twitter_posts", "doc");
                    Map <String, Object> jsonMap = new HashMap <>();
                    jsonMap.put("text", text);
                    jsonMap.put("id_str", id_str);
                    jsonMap.put("created_at", created_at);
                    jsonMap.put("geolocation", geolocation);
                    jsonMap.put("screen_name", screen_name);
                    jsonMap.put("language", language);
                    try {
                        client.index(indexRequest.source(jsonMap));
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                //System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {
                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }

            @Override
            public void onStallWarning(StallWarning warning) {
                System.out.println("Got stall warning:" + warning);
            }

            @Override
            public void onException(Exception ex) {
                ex.printStackTrace();
            }
        };
        twitterStream.addListener(listener);
        twitterStream.sample();
    }
}
