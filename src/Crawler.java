import twitter4j.conf.ConfigurationBuilder;
import twitter4j.*;

/**
 * This is a crawler baby
 */
public class Crawler {

    private TwitterStream twitterStream;

    public Crawler(String consumerKey,String consumerSecret,String accessToken, String accessTokenSecret){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);

        this.twitterStream = new TwitterStreamFactory(cb.build()).getInstance();


        twitterStream.addListener(new StatusListener() {
            @Override
            public void onStatus(Status status) {
                System.out.println("--------------------------------------------");
                System.out.println(status.getText());
                System.out.println("--------------------------------------------");
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {

            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {

            }

            @Override
            public void onStallWarning(StallWarning warning) {

            }

            @Override
            public void onException(Exception ex) {
                System.out.println("Ex");
            }
        });

        FilterQuery tweetFilterQuery = new FilterQuery();
        tweetFilterQuery.language(new String[]{"en"});

        // Set location to USA bounding box
        tweetFilterQuery.locations(new double[][]{new double[]{-171.791110603,18.91619},
                new double[]{-66.96466,71.3577635769
                }});

        twitterStream.filter(tweetFilterQuery);
        //twitterStream.sample();
    }

}
