public class Tweeagle {

    public static void main(String args[]){
        System.out.println("Welcome to Tweegle");
        // APP:
        Crawler crawler = new Crawler("FRHoEIlNIAdGjNKKGzVyzcpER",
                "AKOZgkU3XmfQqEaUsHLCFyJzVlM8wPqsdFdY4NiqDkS3BMTYc3",
                "529412295-980juv52ABQEbi72Okc4edAvvYYEHUnC8nNP07an",
                "Xd61PK5e3WJYw0jaStYPe5zGjPlbvgiP1Noc9HxLnwXI8");
        crawler.setTweetBucketCapacity(1000); // Tweets per bucket-file
        crawler.crawl();
    }
}
