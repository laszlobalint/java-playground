package endpointtwitter;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public final class TwitterRealTimeFilter {

    public static void main(String[] args) throws TwitterException {

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
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
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
        FilterQuery filtre = new FilterQuery();
        String[] keywordsArray = { "terrorism" };
        filtre.track(keywordsArray);
        twitterStream.filter(filtre);
    }
}
