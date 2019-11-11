/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author lequa
 */

public class GetDB {
    static ConnectionDB kn = new ConnectionDB();
    public static List GetData(String sqlstring,List arraySave){
        Connection cn = kn.getConnectionDB();
        Statement stm = null;
        ResultSet rs = null;
        String sql = sqlstring;
        try{
            stm = cn.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next()){
                arraySave.add(rs.getString(1));
            }
        }catch(Exception e){
            System.out.println("Some error at GetDB " +e);
        }
        return arraySave;
    }
    public static void CreateTable(String Tablenamesql){
        Connection cn = kn.getConnectionDB();
        Statement stm = null;
        try{
            stm = cn.createStatement();
            stm.executeUpdate(Tablenamesql);
            System.out.println("Create Success");
        }catch(Exception e){
            System.out.println("Some error at CreaTable " + e);
        }

    }
    public static void InsertTable(String insertString){
        Connection cn = kn.getConnectionDB();
        Statement stm = null;
        ResultSet rs = null;
        try{
            System.out.println("VAO");
            stm = cn.createStatement();
            rs=stm.executeQuery(insertString);
            while(rs.next()){
                stm = cn.createStatement();
                System.out.println(rs.getString(1) +rs.getString(2));
                String sql = "INSERT INTO FINALTEAM " + "VALUES (" +"'"+rs.getString(1)+"'"+","+"'"+rs.getString(2)+"'"+")";
//                System.out.println(sql);
                stm.executeUpdate(sql);
//                stm.executeUpdate("INSERT INTO FINALTEAM VALUES (" + rs.getString(1)+","+rs.getString(2)+")");
//                System.out.println("ID: " + rs.getString(1) +"\tNAME: "+rs.getString(2) +"\tAREA: "+rs.getString(3));
            }
            System.out.println("Insert Success");
        }catch(Exception e){
            System.out.println("Some error in InserTable" + e);
        }
    }

}
