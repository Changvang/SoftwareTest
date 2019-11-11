import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExecuteFunction {
    static ConnectionDB kn = new ConnectionDB();
    // get JSONObject from SQL server
    public static JSONObject getJsonObject(){

        Connection cn = kn.getConnectionDB();
        Statement stm = null;
        ResultSet rs = null;

        JSONObject finalteam = new JSONObject();
        try{
            // get all team data from database
            Collection<JSONObject> items = new ArrayList<JSONObject>();
            String sql = "SELECT * FROM ALLTEAM";
            stm = cn.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next()){
                JSONObject item = new JSONObject();
                item.put("ROT",rs.getString("ROT"));
                item.put("NAME",rs.getString("NAME"));
                item.put("AREA",rs.getString("AREA"));
                items.add(item);
            }
            finalteam.put("Final", items);
        }catch(Exception e){
            System.out.println("Some error at GetDB " +e);
        }
        return finalteam;
    };

    public static String Draw_Team(String team1, String team2){
        if(Math.random() < 0.5) {
            return team1;
        }
        else{
            return team2;
        }
    }

    public static JSONObject JSONRemoveBykey(JSONObject oj,String key,String value) throws JSONException {
        JSONArray teams = oj.getJSONArray("Final");
        for(int i =0; i < teams.length(); i++){
            if(teams.getJSONObject(i).get(key).toString().equals(value)){
                teams.remove(i);
                break;
            }
        }
        oj.remove("Final");
        oj.put("Final", teams);
        return oj;
    }


    // Random number from max to min(Integer)
    private static int getRandomIntBetweenRange(int min, int max){
        return (int) ((Math.random()*((max-min)+1))+min);
    }

    //get ramdom Name from ListINt for 32 team
    public static List<Integer> CreateRandomteams(int MaxValue){
        List<Integer> Ramdom_List = new ArrayList<Integer>();
        for(int i = 0 ; i < 32; i++){
            boolean checking = true;
            while(checking){
                int new_value = getRandomIntBetweenRange(0,MaxValue-1);
                if(!Ramdom_List.contains(new_value)){
                    Ramdom_List.add(new_value);
                    checking = false;
                }
            }
        }
        return Ramdom_List;
    }
    // Seperate 32 teams for 8 table match

    public static JSONObject SeperateTeam(JSONObject oj) throws JSONException {
        JSONArray teams = oj.getJSONArray("Final");
        // All Table Match
        Collection<JSONObject> TableA = new ArrayList<JSONObject>();
        Collection<JSONObject> TableB = new ArrayList<JSONObject>();
        Collection<JSONObject> TableC = new ArrayList<JSONObject>();
        Collection<JSONObject> TableD = new ArrayList<JSONObject>();
        Collection<JSONObject> TableE = new ArrayList<JSONObject>();
        Collection<JSONObject> TableF = new ArrayList<JSONObject>();
        Collection<JSONObject> TableG = new ArrayList<JSONObject>();
        Collection<JSONObject> TableH = new ArrayList<JSONObject>();

        // get random number to seperate
        List<Integer> SeperateList = CreateRandomteams(teams.length());

        for(int i = 0; i < teams.length(); i++){
            if(i < 4){
                TableA.add(teams.getJSONObject(SeperateList.get(i)).put("STT", i%4+1));
            }else if(i < 12){
                TableB.add(teams.getJSONObject(SeperateList.get(i)).put("STT", i%4+1));
            }else if(i < 16){
                TableC.add(teams.getJSONObject(SeperateList.get(i)).put("STT", i%4+1));
            }else if(i < 20){
                TableD.add(teams.getJSONObject(SeperateList.get(i)).put("STT", i%4+1));
            }else if(i < 24){
                TableE.add(teams.getJSONObject(SeperateList.get(i)).put("STT", i%4+1));
            }else if(i < 28){
                TableF.add(teams.getJSONObject(SeperateList.get(i)).put("STT", i%4+1));
            }else{
                TableG.add(teams.getJSONObject(SeperateList.get(i)).put("STT", i%4+1));
            }
        }
        // add to oj
        oj.put("A", TableA);
        oj.put("B", TableB);
        oj.put("C", TableC);
        oj.put("D", TableD);
        oj.put("E", TableE);
        oj.put("F", TableF);
        oj.put("G", TableG);
        oj.put("H", TableH);

        return oj;
    }

    // Create a ListString of all team(Not use)
    public static List<String> CreateListFromJSOnObject(JSONObject oj, String KeyJsonArray){
        List<String> New_List = new ArrayList<String>();
        try {
            JSONArray teams = oj.getJSONArray(KeyJsonArray);
            for(int i = 0; i < teams.length(); i++){
                New_List.add(teams.getJSONObject(i).get("NAME").toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return New_List;
    }
}
