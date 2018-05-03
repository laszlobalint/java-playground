import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

public class SpecificProfileTweets {

    public static void main(String[] args) {
        SpecificProfileTweets feedGetterAll = new SpecificProfileTweets("MLSZhivatalos", true);
        //SpecificProfileTweets feedGetter = new SpecificProfileTweets("ChiliPeppers", 200, false);
        feedGetterAll.gettingFeed();
        //feedGetter.gettingFeed();
    }

    private String username;
    private int numberOfTweets;
    private boolean isAll;

    public SpecificProfileTweets(String username, boolean isAll) {
        this.username = username;
        this.isAll = isAll;
    }

    public SpecificProfileTweets(String username, int numberOfTweets, boolean isAll) {
        this.username = username;
        this.numberOfTweets = numberOfTweets;
        this.isAll = isAll;
    }

    public void gettingFeed() {
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey("uRW6AJbfloNkLd4TuUtQtQBNh")
                    .setOAuthConsumerSecret("BuZ1m7DTj06zwafIZVhicrTaiEXJt2pfPccJ6WegXsjkzfLZ0P")
                    .setOAuthAccessToken("989077780007661571-PsYu563dRxS1gF9xUC2xOWGuPepMje9")
                    .setOAuthAccessTokenSecret("9ZjUdlujMfIMWJBIQH6d7sHKzEfGd1GGnA052ON2NC5ZP")
                    .setTweetModeExtended(true);
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter1 = tf.getInstance();
            int pageno = 1;
            List<Status> statuses = new ArrayList<>();
            String user;
            if (isAll) {
                while (true) {
                    user = username;
                    int size = statuses.size();
                    Paging page = new Paging(pageno++, 100);
                    statuses.addAll(twitter1.getUserTimeline(user, page));
                    if (statuses.size() == size)
                        break;
                }
            } else {
                while (true) {
                    user = username;
                    int size = statuses.size();
                    Paging page = new Paging(pageno++, numberOfTweets);
                    statuses.addAll(twitter1.getUserTimeline(user, page));
                    if (statuses.size() == numberOfTweets)
                        break;
                }
            }

            System.out.println("Showing @" + user + "'s user timeline.");
            int counter = 0;
            for (Status status : statuses) {
                counter++;
                if (status.getText().contains("Szalai")) {
                    System.out.println(counter + ".: @" + status.getUser().getScreenName() + " - " + status.getText());
                }
                }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
    }
}