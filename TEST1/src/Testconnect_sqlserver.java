import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 *
 * @author giasutinhoc.vn
 */
public class Testconnect_sqlserver {
    public static void main(String[] args) {

        try {
            List<Integer> Ramdom_List = new ArrayList<Integer>();
            Ramdom_List.add(1);
            Ramdom_List.add(2);
            Ramdom_List.add(5);
            String jsontest = "{\"A\":[{\"STT\":1,\"AREA\":\"CAF\",\"SCORE\":6,\"ROT\":\"3\",\"GOALS\":5,\"NAME\":\"NIGERIA\"},{\"STT\":2,\"AREA\":\"CONMEBOL\",\"SCORE\":6,\"ROT\":\"2\",\"GOALS\":7,\"NAME\":\"BRAZIL\"},{\"STT\":3,\"AREA\":\"AFC\",\"SCORE\":6,\"ROT\":\"5\",\"GOALS\":6,\"NAME\":\"SOUTH KOREA\"},{\"STT\":4,\"AREA\":\"UEFA\",\"SCORE\":0,\"ROT\":\"7\",\"GOALS\":10,\"NAME\":\"ICELAND\"}],\"B\":[{\"STT\":1,\"AREA\":\"UEFA\",\"SCORE\":6,\"ROT\":\"8\",\"GOALS\":10,\"NAME\":\"POLAND\"},{\"STT\":2,\"AREA\":\"UEFA\",\"SCORE\":9,\"ROT\":\"2\",\"GOALS\":12,\"NAME\":\"CROATIA\"},{\"STT\":3,\"AREA\":\"CONCACAF\",\"SCORE\":0,\"ROT\":\"4\",\"GOALS\":4,\"NAME\":\"URUGUAY\"},{\"STT\":4,\"AREA\":\"AFC\",\"SCORE\":3,\"ROT\":\"3\",\"GOALS\":7,\"NAME\":\"JAPAN\"}],\"C\":[{\"STT\":1,\"AREA\":\"UEFA\",\"SCORE\":6,\"ROT\":\"4\",\"GOALS\":12,\"NAME\":\"ENGLAND\"},{\"STT\":2,\"AREA\":\"UEFA\",\"SCORE\":3,\"ROT\":\"1\",\"GOALS\":7,\"NAME\":\"BELGIUM\"},{\"STT\":3,\"AREA\":\"UEFA\",\"SCORE\":3,\"ROT\":\"10\",\"GOALS\":7,\"NAME\":\"RUSSIA\"},{\"STT\":4,\"AREA\":\"UEFA\",\"SCORE\":6,\"ROT\":\"5\",\"GOALS\":9,\"NAME\":\"FRANCE\"}],\"D\":[{\"STT\":1,\"AREA\":\"AFC\",\"SCORE\":3,\"ROT\":\"1\",\"GOALS\":8,\"NAME\":\"AUTRALIA\"},{\"STT\":2,\"AREA\":\"UEFA\",\"SCORE\":6,\"ROT\":\"6\",\"GOALS\":9,\"NAME\":\"GERMANY\"},{\"STT\":3,\"AREA\":\"UEFA\",\"SCORE\":3,\"ROT\":\"14\",\"GOALS\":7,\"NAME\":\"SWITZERLAND\"},{\"STT\":4,\"AREA\":\"AFC\",\"SCORE\":6,\"ROT\":\"4\",\"GOALS\":10,\"NAME\":\"SAUDI ARABIA\"}],\"E\":[{\"STT\":1,\"AREA\":\"CONMEBOL\",\"SCORE\":0,\"ROT\":\"1\",\"GOALS\":5,\"NAME\":\"ARGENTINA\"},{\"STT\":2,\"AREA\":\"UEFA\",\"SCORE\":6,\"ROT\":\"13\",\"GOALS\":10,\"NAME\":\"SWEDEN\"},{\"STT\":3,\"AREA\":\"UEFA\",\"SCORE\":3,\"ROT\":\"3\",\"GOALS\":4,\"NAME\":\"DENMARK\"},{\"STT\":4,\"AREA\":\"CONCACAF\",\"SCORE\":9,\"ROT\":\"3\",\"GOALS\":13,\"NAME\":\"NIGERIA\"}],\"F\":[{\"STT\":1,\"AREA\":\"UEFA\",\"SCORE\":3,\"ROT\":\"12\",\"GOALS\":6,\"NAME\":\"SPAIN\"},{\"STT\":2,\"AREA\":\"OFC\",\"SCORE\":3,\"ROT\":\"1\",\"GOALS\":6,\"NAME\":\"GHANA\"},{\"STT\":3,\"AREA\":\"CONMEBOL\",\"SCORE\":9,\"ROT\":\"3\",\"GOALS\":12,\"NAME\":\"COLOMBIA\"},{\"STT\":4,\"AREA\":\"AFC\",\"SCORE\":3,\"ROT\":\"2\",\"GOALS\":8,\"NAME\":\"IRAN\"}],\"G\":[{\"STT\":1,\"AREA\":\"UEFA\",\"SCORE\":7,\"ROT\":\"9\",\"GOALS\":4,\"NAME\":\"PORTUGAL\"},{\"STT\":2,\"AREA\":\"CAF\",\"SCORE\":1,\"ROT\":\"5\",\"GOALS\":3,\"NAME\":\"TUNISIA\"},{\"STT\":3,\"AREA\":\"CONCACAF\",\"SCORE\":3,\"ROT\":\"2\",\"GOALS\":9,\"NAME\":\"MEXICO\"},{\"STT\":4,\"AREA\":\"CAF\",\"SCORE\":6,\"ROT\":\"4\",\"GOALS\":8,\"NAME\":\"SENEGAL\"}],\"H\":[{\"STT\":1,\"AREA\":\"CAF\",\"SCORE\":7,\"ROT\":\"2\",\"GOALS\":7,\"NAME\":\"MOROCCO\"},{\"STT\":2,\"AREA\":\"CAF\",\"SCORE\":1,\"ROT\":\"1\",\"GOALS\":6,\"NAME\":\"EGYPT\"},{\"STT\":3,\"AREA\":\"CONCACAF\",\"SCORE\":4,\"ROT\":\"1\",\"GOALS\":8,\"NAME\":\"COSTA RICA\"},{\"STT\":4,\"AREA\":\"UEFA\",\"SCORE\":4,\"ROT\":\"11\",\"GOALS\":3,\"NAME\":\"SERBIA\"}],\"Final\":[{\"STT\":1,\"AREA\":\"AFC\",\"SCORE\":3,\"ROT\":\"1\",\"GOALS\":8,\"NAME\":\"AUTRALIA\"},{\"STT\":4,\"AREA\":\"AFC\",\"SCORE\":3,\"ROT\":\"2\",\"GOALS\":8,\"NAME\":\"IRAN\"},{\"STT\":4,\"AREA\":\"AFC\",\"SCORE\":3,\"ROT\":\"3\",\"GOALS\":7,\"NAME\":\"JAPAN\"},{\"STT\":4,\"AREA\":\"AFC\",\"SCORE\":6,\"ROT\":\"4\",\"GOALS\":10,\"NAME\":\"SAUDI ARABIA\"},{\"STT\":3,\"AREA\":\"AFC\",\"SCORE\":4,\"ROT\":\"5\",\"GOALS\":7,\"NAME\":\"SOUTH KOREA\"},{\"STT\":2,\"AREA\":\"CAF\",\"SCORE\":1,\"ROT\":\"1\",\"GOALS\":6,\"NAME\":\"EGYPT\"},{\"STT\":1,\"AREA\":\"CAF\",\"SCORE\":7,\"ROT\":\"2\",\"GOALS\":7,\"NAME\":\"MOROCCO\"},{\"STT\":1,\"AREA\":\"CAF\",\"SCORE\":1,\"ROT\":\"3\",\"GOALS\":7,\"NAME\":\"NIGERIA\"},{\"STT\":4,\"AREA\":\"CAF\",\"SCORE\":6,\"ROT\":\"4\",\"GOALS\":8,\"NAME\":\"SENEGAL\"},{\"STT\":2,\"AREA\":\"CAF\",\"SCORE\":1,\"ROT\":\"5\",\"GOALS\":3,\"NAME\":\"TUNISIA\"},{\"STT\":3,\"AREA\":\"CONCACAF\",\"SCORE\":4,\"ROT\":\"1\",\"GOALS\":8,\"NAME\":\"COSTA RICA\"},{\"STT\":3,\"AREA\":\"CONCACAF\",\"SCORE\":3,\"ROT\":\"2\",\"GOALS\":9,\"NAME\":\"MEXICO\"},{\"STT\":4,\"AREA\":\"CONCACAF\",\"SCORE\":9,\"ROT\":\"3\",\"GOALS\":13,\"NAME\":\"NIGERIA\"},{\"STT\":3,\"AREA\":\"CONCACAF\",\"SCORE\":0,\"ROT\":\"4\",\"GOALS\":4,\"NAME\":\"URUGUAY\"},{\"STT\":1,\"AREA\":\"CONMEBOL\",\"SCORE\":0,\"ROT\":\"1\",\"GOALS\":5,\"NAME\":\"ARGENTINA\"},{\"STT\":2,\"AREA\":\"CONMEBOL\",\"SCORE\":6,\"ROT\":\"2\",\"GOALS\":13,\"NAME\":\"BRAZIL\"},{\"STT\":3,\"AREA\":\"CONMEBOL\",\"SCORE\":9,\"ROT\":\"3\",\"GOALS\":12,\"NAME\":\"COLOMBIA\"},{\"STT\":2,\"AREA\":\"OFC\",\"SCORE\":3,\"ROT\":\"1\",\"GOALS\":6,\"NAME\":\"GHANA\"},{\"STT\":2,\"AREA\":\"UEFA\",\"SCORE\":3,\"ROT\":\"1\",\"GOALS\":7,\"NAME\":\"BELGIUM\"},{\"STT\":2,\"AREA\":\"UEFA\",\"SCORE\":9,\"ROT\":\"2\",\"GOALS\":12,\"NAME\":\"CROATIA\"},{\"STT\":3,\"AREA\":\"UEFA\",\"SCORE\":3,\"ROT\":\"3\",\"GOALS\":4,\"NAME\":\"DENMARK\"},{\"STT\":1,\"AREA\":\"UEFA\",\"SCORE\":6,\"ROT\":\"4\",\"GOALS\":12,\"NAME\":\"ENGLAND\"},{\"STT\":4,\"AREA\":\"UEFA\",\"SCORE\":6,\"ROT\":\"5\",\"GOALS\":9,\"NAME\":\"FRANCE\"},{\"STT\":2,\"AREA\":\"UEFA\",\"SCORE\":6,\"ROT\":\"6\",\"GOALS\":9,\"NAME\":\"GERMANY\"},{\"STT\":4,\"AREA\":\"UEFA\",\"SCORE\":6,\"ROT\":\"7\",\"GOALS\":10,\"NAME\":\"ICELAND\"},{\"STT\":1,\"AREA\":\"UEFA\",\"SCORE\":6,\"ROT\":\"8\",\"GOALS\":10,\"NAME\":\"POLAND\"},{\"STT\":1,\"AREA\":\"UEFA\",\"SCORE\":7,\"ROT\":\"9\",\"GOALS\":4,\"NAME\":\"PORTUGAL\"},{\"STT\":3,\"AREA\":\"UEFA\",\"SCORE\":3,\"ROT\":\"10\",\"GOALS\":7,\"NAME\":\"RUSSIA\"},{\"STT\":4,\"AREA\":\"UEFA\",\"SCORE\":4,\"ROT\":\"11\",\"GOALS\":3,\"NAME\":\"SERBIA\"},{\"STT\":1,\"AREA\":\"UEFA\",\"SCORE\":3,\"ROT\":\"12\",\"GOALS\":6,\"NAME\":\"SPAIN\"},{\"STT\":2,\"AREA\":\"UEFA\",\"SCORE\":6,\"ROT\":\"13\",\"GOALS\":10,\"NAME\":\"SWEDEN\"},{\"STT\":3,\"AREA\":\"UEFA\",\"SCORE\":3,\"ROT\":\"14\",\"GOALS\":7,\"NAME\":\"SWITZERLAND\"}]}\n";

            JSONObject Test1 = new JSONObject(jsontest);
            //System.out.println(Test1);

            String valA = new String();
            String valB = new String();

            valA = Integer.toString(-33);
            valB = Integer.toString(34 -1);

            System.out.println(valA + " " +  valB + " " +  Integer.toString(valB.compareTo(valA)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private JSONArray Test1(JSONArray ojarr) throws JSONException {

        List<Integer> PositionandScore = new ArrayList<Integer>();

        List<Integer> Position = new ArrayList<Integer>();

        //tim max
        int max = 0;
        for(int i =0; i < 4; i++){
            if(getIntFromString(ojarr.getJSONObject(i).get("SCORE").toString()) > max) max = getIntFromString(ojarr.getJSONObject(i).get("SCORE").toString());
        }
        // tim so luong max
        int max_count = 0;
        for(int i =0; i < 4; i++){
            if(getIntFromString(ojarr.getJSONObject(i).get("SCORE").toString()) == max) max_count++;
        }
        // tim min
        int min = 9;
        for(int i =0; i < 4; i++){
            if(getIntFromString(ojarr.getJSONObject(i).get("SCORE").toString()) < min) min = getIntFromString(ojarr.getJSONObject(i).get("SCORE").toString());
        }
        // tim so luong min
        int min_count = 0;
        for(int i =0; i < 4; i++){
            if(getIntFromString(ojarr.getJSONObject(i).get("SCORE").toString()) == min) min_count++;
        }
        // if min = max(Chua lam)

        // if min != max
        if(max_count == 1) {// Chi co 1 max
            if(min_count == 1){ // chi co 1 min
                for(int i =0; i < 4; i++){
                    if(PositionandScore.get(i) == max) {
                        Position.add(i);
                        // xu li 2 thang o giua
                        Collection<JSONObject> new_Arr = new ArrayList<JSONObject>();
                        for(int j =0; j < 4; j++){
                            if(getIntFromString(ojarr.getJSONObject(i).get("SCORE").toString()) != min && getIntFromString(ojarr.getJSONObject(i).get("SCORE").toString()) !=max){
                                new_Arr.add(ojarr.getJSONObject(i));
                            }
                        }

                        // xu li gia tri min
                        for(int j = 0; j < 4; j++){
                            if(PositionandScore.get(j) == min) Position.add(j);
                        }
                        break;
                    }
                }
            }else{// co toi 2 min
                // xu li khi bang nhau cua 2 doi
                for(int i =0; i < 4; i++){
                    if(PositionandScore.get(i) == max) {
                        Position.add(i);
                        // xu li 1 thang o giua
                        for(int j = 0; j < 4; j++){
                            if(PositionandScore.get(j) != min && PositionandScore.get(j) != max) Position.add(j);
                        }
                        // xu li 2 thang cuoi cung

                        break;
                    }
                }
            }
        }
        else if(max_count == 2){ // Co toi 2 max

        }
        else{ // Co 3 max

        }
        return ojarr;
    }

    private int getIntFromString(String a){
        return Integer.parseInt(a);
    }

    private static void Test2(JSONArray new_Arr) throws JSONException {
        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < new_Arr.length(); i++) {
            jsonValues.add(new_Arr.getJSONObject(i));
        }
        Collections.sort(jsonValues, new Comparator<JSONObject>() {
            @Override
            public int compare(JSONObject a, JSONObject b) {
                String valA = new String();
                String valB = new String();
                try{
                    valA = (String) a.get("SCORE").toString();
                    valB = (String) b.get("SCORE").toString();
                    if(valB.compareTo(valA) != 0){
                        return valB.compareTo(valA);
                    }

                    valA = (String) a.get("GOALS").toString();
                    valB = (String) b.get("GOALS").toString();
                    return valB.compareTo(valA);
                }catch(JSONException e){
                    //todo
                }
                return valB.compareTo(valA);
            }
        });


        System.out.println(jsonValues.toString());
    }
}