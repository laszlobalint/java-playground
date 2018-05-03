import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.util.List;

public class FollowedTweets {
    public static void main(String[] args) {
        ConfigurationBuilder cf = new ConfigurationBuilder();

        cf.setDebugEnabled(true)
                .setOAuthConsumerKey("uRW6AJbfloNkLd4TuUtQtQBNh")
                .setOAuthConsumerSecret("BuZ1m7DTj06zwafIZVhicrTaiEXJt2pfPccJ6WegXsjkzfLZ0P")
                .setOAuthAccessToken("989077780007661571-PsYu563dRxS1gF9xUC2xOWGuPepMje9")
                .setOAuthAccessTokenSecret("9ZjUdlujMfIMWJBIQH6d7sHKzEfGd1GGnA052ON2NC5ZP");
        TwitterFactory tf = new TwitterFactory(cf.build());
        twitter4j.Twitter twitter = tf.getInstance();

        try {
            List <Status> status = twitter.getHomeTimeline();

            for (Status st : status) {
                System.out.println(st.getUser().getName() + "--------------" + st.getText());
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}
