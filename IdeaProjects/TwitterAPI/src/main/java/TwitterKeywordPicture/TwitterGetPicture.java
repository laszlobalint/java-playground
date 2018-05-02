package TwitterKeywordPicture;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public final class TwitterGetPicture {

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
                if (status.getLang().equals("en") && status.getText().contains("game")) {
                    System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
                    MediaEntity[] media = status.getMediaEntities();
                    int counter = 0;
                    for (MediaEntity m : media) {
                        System.out.println(m.getMediaURL());
                        counter++;
                        InputStream inputStream = null;
                        OutputStream outputStream = null;
                        try {
                            URL url = new URL(m.getMediaURL());
                            inputStream = url.openStream();
                            outputStream = new FileOutputStream(counter + "image.jpg");

                            byte[] buffer = new byte[2048];
                            int length;

                            while ((length = inputStream.read(buffer)) != -1) {
                                outputStream.write(buffer, 0, length);
                            }
                        } catch (MalformedURLException e) {
                            System.out.println("MalformedURLException :- " + e.getMessage());

                        } catch (FileNotFoundException e) {
                            System.out.println("FileNotFoundException :- " + e.getMessage());

                        } catch (IOException e) {
                            System.out.println("IOException :- " + e.getMessage());

                        } finally {
                            try {
                                inputStream.close();
                                outputStream.close();
                            } catch (IOException e) {
                                System.out.println("Finally IOException :- " + e.getMessage());
                            }
                        }
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
