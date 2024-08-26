package Milla.Heap;

import java.util.*;

public class Twitter2 {

    Map<Integer,List<int[]>> tweetmap;
    Map<Integer,Set<Integer>> followMap; //중복방지 때문에 set 사용
    int count;

    public Twitter2() {
        count = 0;
        tweetmap = new HashMap<>();
        followMap = new HashMap<>();
    }

    public static void main(String[] args) {
        Twitter2 twitter = new Twitter2();
        twitter.postTweet(1, 10); // User 1 posts a new tweet with id = 10.
        twitter.postTweet(2, 20); // User 2 posts a new tweet with id = 20.
        twitter.getNewsFeed(1);   // User 1's news feed should only contain their own tweets -> [10].
        twitter.getNewsFeed(2);   // User 2's news feed should only contain their own tweets -> [20].
        twitter.follow(1, 2);     // User 1 follows user 2.
        twitter.getNewsFeed(1);   // User 1's news feed should contain both tweets from user 1 and user 2 -> [20, 10].
        twitter.getNewsFeed(2);   // User 2's news feed should still only contain their own tweets -> [20].
        twitter.unfollow(1, 2);   // User 1 follows user 2.
        twitter.getNewsFeed(1);   // User 1's news feed should only contain their own tweets -> [10].
    }
    public void postTweet(int userId, int tweetId) {
        tweetmap.computeIfAbsent(userId,k->new ArrayList<>()).add(new int[]{count--,tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        followMap.computeIfAbsent(userId,k->new HashSet<>()).add(userId);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        for (int followId : followMap.get(userId)){
            if(tweetmap.containsKey(followId)){
                List<int[]> tweets = tweetmap.get(followId);
                int[] tweet = tweets.get(tweets.size()-1);
                pq.offer(new int[]{tweet[0],tweet[1],tweets.size()-1,followId});
            }
        }

        while (!pq.isEmpty() && ans.size() < 10){
            int[] curr = pq.poll();
            ans.add(curr[1]);

            if(curr[2] > 0){
                List<int[]> tweets = tweetmap.get(curr[3]);
                int[] tweet = tweets.get(curr[2]-1);
                pq.offer(new int[]{tweet[0],tweet[1],curr[2]-1,curr[3]});
            }
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfPresent(followerId,(k,v)->{
            v.remove(followerId);
            return v; //이건 왜?
        });
    }
}
