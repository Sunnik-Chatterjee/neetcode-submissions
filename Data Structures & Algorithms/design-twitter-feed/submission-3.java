class Tweet implements Comparable<Tweet>{
    int tweetId;
    int time;
    Tweet(int tweetId,int time){
        this.tweetId =  tweetId;
        this.time = time;
    }
    public int compareTo(Tweet that){
        return that.time - this.time;
    }
}
class User{
    int userId;
    HashSet<Integer> followers;
    List<Tweet> tweets;
    User(int userId){
        this.userId = userId;
        followers = new HashSet<>();
        followers.add(userId);
        tweets = new LinkedList<>();
    }
    void addTweet(Tweet tweet){
        tweets.add(0,tweet);
    }
    void addFollowers(int followeeId){
        followers.add(followeeId);
    }
    void removeFollowers(int followeeId){
        followers.remove(followeeId);
    }
    
}
class Twitter {
    HashMap<Integer,User> userMap;
    int time;
    public Twitter() {
        userMap = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        if(!userMap.containsKey(userId)) userMap.put(userId,new User(userId));
        User user = userMap.get(userId);
        user.addTweet(new Tweet(tweetId,time));    
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId))return new ArrayList<>();
        User user = userMap.get(userId);
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();
        for(int follower : user.followers){
            int count = 0;
            for(Tweet tweet : userMap.get(follower).tweets){
                count++;
                pq.offer(tweet);
                if(count==10) break;
            }
        }
        int index = 0;
        while(!pq.isEmpty() && index<10){
            res.add(pq.poll().tweetId);
            index++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) userMap.put(followerId,new User(followerId));
        if(!userMap.containsKey(followeeId)) userMap.put(followeeId,new User(followeeId));
        User user = userMap.get(followerId);
        user.addFollowers(followeeId);        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) return;
        User user = userMap.get(followerId);
        user.removeFollowers(followeeId);
    }
}
