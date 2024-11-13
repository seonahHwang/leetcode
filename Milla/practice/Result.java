package Milla.practice;


import java.io.*;
import java.util.concurrent.*;

import static java.util.stream.Collectors.joining;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import com.google.gson.*;



class Result {

    /*
     * Complete the 'getWinnerTotalGoals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING competition
     *  2. INTEGER year
     */

    private static String MATCH_URL = "https://jsonmock.hackerrank.com/api/football_matches?";
    private static String COMPETITION_URL = "https://jsonmock.hackerrank.com/api/football_competitions?";

    public static int getWinnerTotalGoals(String competition, int year) throws Exception{
        String competUrl = String.format(COMPETITION_URL+"name=%s&year=%d",URLEncoder.encode(competition, "UTF-8"),year);
        String response = getResponse(competUrl, 1, true);
        JsonObject jsonResponse = new Gson().fromJson(response, JsonObject.class);
        JsonElement e = jsonResponse.getAsJsonArray("data").get(0);
        String winnerTeam = e.getAsJsonObject().get("winner").getAsString();
        return totalGoals(competition, year, winnerTeam);
    }

    private static int totalGoals(String competition, int year, String team) throws Exception {
        String team1Url = String.format(MATCH_URL + "competition=%s&year=%d&team1=%s", URLEncoder.encode(competition, "UTF-8"), year, URLEncoder.encode(team, "UTF-8"));
        String team2Url = String.format(MATCH_URL + "competition=%s&year=%d&team2=%s", URLEncoder.encode(competition, "UTF-8"), year, URLEncoder.encode(team, "UTF-8"));

        // Using CompletableFuture for parallel calls
        CompletableFuture<Integer> team1GoalsFuture = new CompletableFuture<>();
        CompletableFuture<Integer> team2GoalsFuture = new CompletableFuture<>();

        // Fetch team 1 goals
        new Thread(() -> {
            try {
                int team1Goals = getTeamGoals(team1Url, "team1", 1, 0);
                team1GoalsFuture.complete(team1Goals);
            } catch (Exception e) {
                team1GoalsFuture.completeExceptionally(e);
            }
        }).start();

        // Fetch team 2 goals
        new Thread(() -> {
            try {
                int team2Goals = getTeamGoals(team2Url, "team2", 1, 0);
                team2GoalsFuture.complete(team2Goals);
            } catch (Exception e) {
                team2GoalsFuture.completeExceptionally(e);
            }
        }).start();

        // Wait for both futures to complete and sum the results
        int team1Goals = team1GoalsFuture.get();
        int team2Goals = team2GoalsFuture.get();
        return team1Goals + team2Goals;
    }

    private static int getTeamGoals(String url, String teamtype, int page, int totalgoals) throws Exception {
        String response = getResponse(url, page, false);

        JsonObject jsonResponse = new Gson().fromJson(response, JsonObject.class);
        int totalPage = jsonResponse.get("total_pages").getAsInt();
        JsonArray data = jsonResponse.getAsJsonArray("data");

        int totalGoals = 0;
        for (JsonElement e : data) {
            totalGoals += e.getAsJsonObject().get(teamtype + "goals").getAsInt();
        }

        if (page < totalPage) {
            totalGoals += getTeamGoals(url, teamtype, page + 1, totalGoals);  // Fetch next page 재귀
        }

        return totalGoals;
    }


    private static String getResponse(String endpoint, int page, boolean competition) throws Exception{
        URL url = null;
        if(competition){
            url = new URL(endpoint);
        }
        else{
            url = new URL(endpoint + "&page="+page);
        }
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response;
        StringBuilder sb = new StringBuilder();

        while((response = br.readLine()) != null){
            sb.append(response);
        }

        con.disconnect();
        br.close();

        return sb.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String competition = bufferedReader.readLine();

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.getWinnerTotalGoals(competition, year);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
