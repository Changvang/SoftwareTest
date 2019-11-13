import com.sun.jdi.event.ClassPrepareEvent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

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

            //member
            Collection<JSONObject> items_member = new ArrayList<JSONObject>();
            sql = "SELECT * FROM MemberofTeam";
            rs=stm.executeQuery(sql);
            while(rs.next()){
                JSONObject item = new JSONObject();
                item.put("ID",rs.getString("ID"));
                item.put("NAME",rs.getString("NAME"));
                item.put("ROLE",rs.getString("ROLE"));
                item.put("NATIONS",rs.getString("NATIONS"));
                items_member.add(item);
            }
            finalteam.put("Member", items_member);

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
            }else if(i < 8){
                TableB.add(teams.getJSONObject(SeperateList.get(i)).put("STT", i%4+1));
            }else if(i < 12){
                TableC.add(teams.getJSONObject(SeperateList.get(i)).put("STT", i%4+1));
            }else if(i < 16){
                TableD.add(teams.getJSONObject(SeperateList.get(i)).put("STT", i%4+1));
            }else if(i < 20){
                TableE.add(teams.getJSONObject(SeperateList.get(i)).put("STT", i%4+1));
            }else if(i < 24){
                TableF.add(teams.getJSONObject(SeperateList.get(i)).put("STT", i%4+1));
            }else if(i < 28){
                TableG.add(teams.getJSONObject(SeperateList.get(i)).put("STT", i%4+1));
            }else{
                TableH.add(teams.getJSONObject(SeperateList.get(i)).put("STT", i%4+1));
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

    public static JSONObject From32teamsto16teams(JSONObject oj) throws JSONException {
        int i = 0;
        oj = Matchingwith4teams(oj,"A");
        oj = Matchingwith4teams(oj,"B");
        oj = Matchingwith4teams(oj,"C");
        oj = Matchingwith4teams(oj,"D");
        oj = Matchingwith4teams(oj,"E");
        oj = Matchingwith4teams(oj,"F");
        oj = Matchingwith4teams(oj,"G");
        oj = Matchingwith4teams(oj,"H");
        //function using to creating and counting match
        return oj;
    }

    public static JSONObject Matchingwith4teams(JSONObject oj, String Table) throws JSONException {
        JSONArray table4teams = oj.getJSONArray(Table);
        //Lay tat ca du lieu va cac cau thu
        JSONArray Member = oj.getJSONArray("Member");

        for(int i = 0 ; i < table4teams.length(); i++){
            int count = 0;
            for(int j= 0 ; j < Member.length(); j++){
                if(Member.getJSONObject(j).getString("NATIONS").equals(table4teams.getJSONObject(i).getString("NAME"))){
                    count++;
                }
            }
            System.out.println(table4teams.getJSONObject(i).getString("NAME") + count);
        }

        // Luu lai ket qua cua 8 tran
        List<String> Match_result = new ArrayList<String>();
        // Tao mot cot SCORE
        for(int i = 0; i < table4teams.length(); i++){
            table4teams.getJSONObject(i).put("SCORE", 0);
            table4teams.getJSONObject(i).put("GOALS", 0);
            table4teams.getJSONObject(i).put("CONCEDED", 0);
            table4teams.getJSONObject(i).put("REDCARDS", 0);
        }
        for(int i = 0; i < Member.length(); i++){
            Member.getJSONObject(i).put("SCORES", 0);

        }
        // match 1-2,1-3,1-4,2-3,2-4,3-4
        for(int i = 0; i < 3; i++){
            for(int j = i+1 ; j < 4; j++){
                Boolean matchresult = false ;
                // dua ket qua vao trong Match_result
                //Match_result.add(table4teams.getJSONObject(i).get("NAME").toString()+ ":" + matchresult + ":" + table4teams.getJSONObject(j).get("NAME").toString());


                //Lay ten cua 2 doi
                String team1 = table4teams.getJSONObject(i).getString("NAME");
                String team2 = table4teams.getJSONObject(j).getString("NAME");

                // Random so the do. Sau do xu li truong hop 5 the do va bi out.(Khong tinh ket qua ghi ban).
                int[] redArray={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,3,4,5};
                int team1RedCards = redArray[getRandomIntBetweenRange(0,redArray.length-1)];
                int team2RedCards = redArray[getRandomIntBetweenRange(0,redArray.length-1)];
                //Team1 Red Card
                for(int x = 0; x<table4teams.length(); x++){
                    String y = table4teams.getJSONObject(x).getString("NAME");
                    if(y.equals(team1)){
                        int redcards = table4teams.getJSONObject(x).getInt("REDCARDS");
                        redcards  += team1RedCards;
                        table4teams.getJSONObject(x).remove("REDCARDS");
                        table4teams.getJSONObject(x).put("REDCARDS", redcards);
                    }
                }

                // Team2 Red Card
                for(int x = 0; x<table4teams.length(); x++){
                    String y = table4teams.getJSONObject(x).getString("NAME");
                    if(y.equals(team2)){
                        int redcards = table4teams.getJSONObject(x).getInt("REDCARDS");
                        redcards  += team1RedCards;
                        table4teams.getJSONObject(x).remove("REDCARDS");
                        table4teams.getJSONObject(x).put("REDCARDS", redcards);
                    }
                }

                int team1Score;
                int team2Score;

                //In red card

                System.out.println("Redcards : "+ team1 + " " + team1RedCards);
                System.out.println("Redcards : "+ team2 + " " + team2RedCards);

                // XU li truong hop 5 the do
                if(team1RedCards==5){
                    team1Score = 0;
                    team2Score = 3;
                    matchresult = true;

                }else if (team2RedCards==5){
                    team1Score = 3;
                    team2Score = 0;
                    matchresult = true;

                }else{
                    team1Score = getRandomIntBetweenRange(0,5);
                    team2Score = getRandomIntBetweenRange(0,5);
                }
                // In ti so
                System.out.println(team1 + " " + team1Score + " : " + team2Score + " " + team2);
                if(!matchresult){
                    //team1 Score
                    System.out.println(team1+ "  :");
                    List <JSONObject> Team1Member = new ArrayList<JSONObject>();
                    for(int x = 0; x<Member.length(); x++){
                        String y = Member.getJSONObject(x).getString("NATIONS");
                        if(y.equals((team1))){
                            Team1Member.add(Member.getJSONObject(x));
                        }
                    }

                    for(int l = 0; l < team1Score; l++){
                        int scorepos = getRandomIntBetweenRange(5, 26);
                        String Name = Team1Member.get(scorepos).getString("NAME");
                        System.out.println(Name);
                        int pos = 0;
                        for(int x = 0; x<Member.length(); x++){
                            String y = Member.getJSONObject(x).getString("NAME");
                            if(y.equals((Name))){
                                pos = x;
                                break;
                            }
                        }
                        int x = Member.getJSONObject(pos).getInt("SCORES");
                        x = x + 1;

                        Member.getJSONObject(pos).put("SCORES", x);
                        System.out.println(Member.get(pos));
                    }

                    //team2 Score
                    System.out.println(team2+ "  :");
                    List <JSONObject> Team2Member = new ArrayList<JSONObject>();
                    for(int x = 0; x<Member.length(); x++){
                        String y = Member.getJSONObject(x).getString("NATIONS");
                        if(y.equals((team1))){
                            Team2Member.add(Member.getJSONObject(x));
                        }
                    }

                    for(int l = 0; l < team2Score; l++){
                        int scorepos = getRandomIntBetweenRange(5, 26);
                        String Name = Team2Member.get(scorepos).getString("NAME");
                        System.out.println(Name);
                        int pos = 0;
                        for(int x = 0; x<Member.length(); x++){
                            String y = Member.getJSONObject(x).getString("NAME");
                            if(y.equals((Name))){
                                pos = x;
                                break;
                            }
                        }
                        int x = Member.getJSONObject(pos).getInt("SCORES");
                        x = x + 1;

                        Member.getJSONObject(pos).put("SCORES", x);
                        System.out.println(Member.get(pos));
                    }

                }

                // tinh tong so ban thang
                table4teams.getJSONObject(i).put("GOALS",table4teams.getJSONObject(i).getInt("GOALS") + team1Score);
                table4teams.getJSONObject(j).put("GOALS",table4teams.getJSONObject(j).getInt("GOALS") + team2Score);
                // tinh tong so ban thua
                table4teams.getJSONObject(i).put("CONCEDED",table4teams.getJSONObject(i).getInt("CONCEDED") + team2Score);
                table4teams.getJSONObject(j).put("CONCEDED",table4teams.getJSONObject(j).getInt("CONCEDED") + team1Score);
                // tinh diem
                int firstteam = team1Score;
                int lastteam = team2Score;
                if(firstteam > lastteam){
                    firstteam = 3; lastteam = 0;
                }else if(firstteam < lastteam){
                    firstteam = 0; lastteam = 3;
                }else{
                    firstteam = 1; lastteam =1;
                }
                table4teams.getJSONObject(i).put("SCORE",table4teams.getJSONObject(i).getInt("SCORE") + firstteam);
                table4teams.getJSONObject(j).put("SCORE",table4teams.getJSONObject(j).getInt("SCORE") + lastteam);

                //
            }
        }
        // Thay doi thu tu xep hang cua cac doi sau 6 tran dau.
        table4teams = ChangeStt(table4teams);
        oj.put("Member", Member);
        oj.put(Table, table4teams);
        return oj;
    }

    public static JSONArray ChangeStt(JSONArray teams) throws JSONException {
        // SAp xep thu tu cac doi bong tren tieu chi : Score -> Ti so ban thang thua -> So the do  -> boc tham
        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < teams.length(); i++) {
            jsonValues.add(teams.getJSONObject(i));
        }
        Collections.sort(jsonValues, new Comparator<JSONObject>() {
            @Override
            public int compare(JSONObject a, JSONObject b) {
                String valA = new String();
                String valB = new String() ;
                try{
                    valA =  a.get("SCORE").toString();
                    valB =  b.get("SCORE").toString();
                    if(valB.compareTo(valA) != 0){
                        return valB.compareTo(valA);
                    }

                    valA = Integer.toString(a.getInt("GOALS") - a.getInt("CONCEDED"));
                    valB = Integer.toString(b.getInt("GOALS") - b.getInt("CONCEDED"));

                    if(valB.compareTo(valA) != 0){
                        return valB.compareTo(valA);
                    }

                    valA =  a.get("REDCARDS").toString();
                    valB =  b.get("REDCARDS").toString();

                    if(valB.compareTo(valA) != 0){
                        return valB.compareTo(valA);
                    }

                    int still_draw =  Match.getRandomIntBetweenRange(0,1);
                    if(still_draw == 1){
                        valA = "1"; valB = "0";
                    }else{
                        valB= "1"; valA = "0";
                    }

                    return valB.compareTo(valA);


                }catch(JSONException e){
                    //todo
                }
                return valB.compareTo(valA);
            }
        });

        return (JSONArray) jsonValues;
    }

}
