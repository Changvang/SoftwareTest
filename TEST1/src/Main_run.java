import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author lequa
 */
public class Main_run {

    /**
     * @param args the command line arguments
     */
    static ConnectionDB kn = new ConnectionDB();
    static Match match = new Match();


    public static void main(String[] args) throws JSONException {
        GetDB GetDB01 = new GetDB();
        // Create a JSONOBJECT to manage all data

        JSONObject all_team = ExecuteFunction.getJsonObject();

        // Display all team
        System.out.println(all_team.toString());

        // read JsonObject to find 4 team will have play-off games

        List<String> Play_off_teams = new ArrayList<String>();
        JSONArray teams = all_team.getJSONArray("Final");
        for(int i =0; i < teams.length(); i++){
            if(teams.getJSONObject(i).get("AREA").toString().equals("AFC") && teams.getJSONObject(i).get("ROT").toString().equals("6")){
                Play_off_teams.add(teams.getJSONObject(i).get("NAME").toString());
            }else if(teams.getJSONObject(i).get("AREA").toString().equals("CONCACAF") && teams.getJSONObject(i).get("ROT").toString().equals("4")){
                Play_off_teams.add(teams.getJSONObject(i).get("NAME").toString());
            }else if(teams.getJSONObject(i).get("AREA").toString().equals("CONMEBOL") && teams.getJSONObject(i).get("ROT").toString().equals("4")){
                Play_off_teams.add(teams.getJSONObject(i).get("NAME").toString());
            }else if(teams.getJSONObject(i).get("AREA").toString().equals("OFC") && teams.getJSONObject(i).get("ROT").toString().equals("1")){
                Play_off_teams.add(teams.getJSONObject(i).get("NAME").toString());
            }
        }

        String lose_team;

        //Play off : Rank 6 of AFC with rank 4 of CONCACAF

        lose_team = Match.Playoff(Play_off_teams.get(0), Play_off_teams.get(1));
        all_team = ExecuteFunction.JSONRemoveBykey(all_team,"NAME",lose_team);

        System.out.println(all_team.toString());

        // Play off : Rank 4 CONMEBOL of with rank 1 of OFC

        lose_team = Match.Playoff(Play_off_teams.get(2), Play_off_teams.get(3));
        all_team = ExecuteFunction.JSONRemoveBykey(all_team,"NAME",lose_team);

        System.out.println(all_team.toString());

        // Chia thanh 8 bang dau mot cach ngau nhien(Hien tai chi lam theo cach chia co thu tu cac bang)
        all_team = ExecuteFunction.SeperateTeam(all_team);
        System.out.println(all_team.toString());

        // Dau voi cac team trong mot bang va tra ket qua lan luot

    }
}