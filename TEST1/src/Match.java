/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author lequa
 */

public class Match {
    private static int getRandomIntBetweenRange(int min, int max){
        return (int) ((Math.random()*((max-min)+1))+min);
    }
    private int team1Total = 0;
    private int team2Total = 0;
    public static String getMatch(String team1, String team2){
        int team1Score, team2Score;

        // Outward trip
        team1Score = getRandomIntBetweenRange(0,5);
        team2Score = getRandomIntBetweenRange(0,5);
        System.out.println("Match : " + team1 + " " + team1Score + " : " + team2Score + " " + team2);
        return team1Score+ ":" + team2Score;
    }

    // Call function play off to find the lose team
    public static String Playoff(String team1,String team2){
        int team1Total = 0;
        int team2Total = 0;
        String scores = getMatch(team1, team2);
        team1Total += Integer.parseInt(scores.split(":")[0]);
        team2Total += Integer.parseInt(scores.split(":")[1]);
        scores = getMatch(team1, team2);
        team1Total += Integer.parseInt(scores.split(":")[0]);
        team2Total += Integer.parseInt(scores.split(":")[1]);

        if(team1Total == team2Total){
            return ExecuteFunction.Draw_Team(team1,team2);
        }
        else if(team1Total > team2Total){
            return team2;
        }
        else{
            return team1;
        }
    }
}