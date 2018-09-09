/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RecipeHandler {
    public static Connection con;
    Vector v;
    private PreparedStatement insertNewRecipe = null;
    private ResultSet res=null;
    public RecipeHandler() {
       

    }
      
    static {
        try {
            init();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Please Open DataBase","ERROR",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
           
        }
    }
    public static void init()throws Exception{

    Class.forName("org.apache.derby.jdbc.ClientDriver");
    con=DriverManager.getConnection("jdbc:derby://localhost:1527/dbs","shanker","123");
    System.out.print("connect");
  }
   public int addData(String name,String category,String ingranted,int preptime,int cookingTime)throws Exception{
        int result=0;
        PreparedStatement insertNewRecipe=null;
        insertNewRecipe = con.prepareStatement("INSERT INTO  RECIPES (RECIPENAME,CATEGORY,MAININGREDIENT,PREPARATIONTIME,COOKINGTIME)VALUES(?,?,?,?,?)");
     try{
      insertNewRecipe.setString(1,name);
      insertNewRecipe.setString(2,category);
      
      insertNewRecipe.setString(3,ingranted);
      insertNewRecipe.setInt(4,preptime);  
      insertNewRecipe.setInt(5,cookingTime);
      result=insertNewRecipe.executeUpdate();
      return result;
      }finally{if(insertNewRecipe!=null)insertNewRecipe.close();}
   }
    
public String getDataByCatorgy(String catorgy)throws Exception{
       PreparedStatement ps=null;
       String allData="";
      try{
        ps = con.prepareStatement("select * from  RECIPES where CATEGORY like '"+catorgy+"' ");
        res=ps.executeQuery();
        while (res.next()) {
         Quries   ob=new Quries(
               res.getString( "RECIPENAME" ),
               res.getString( "CATEGORY" ),
               res.getString( "MAININGREDIENT" ),
               res.getInt( "PREPARATIONTIME" ),
               res.getInt( "COOKINGTIME" ));
                String data=res.getString("RECIPENAME")+","+res.getString( "CATEGORY" )+","+res.getString( "MAININGREDIENT" )+","+res.getInt( "PREPARATIONTIME" )+","+res.getInt( "COOKINGTIME" )+"";
                data+="\n";
                allData+=data;
          }    
       }finally{
           if(ps!=null)ps.close();
           if(res!=null)res.close();
       }
       
   return allData;
   }
public String getDataByCPFromDb(String catorgy,int start,int end)throws Exception{
       PreparedStatement ps=null;
       String allData="";
      try{
        ps = con.prepareStatement("select * from  RECIPES where CATEGORY like '"+catorgy+"' And  PREPARATIONTIME BETWEEN "+start+" AND "+end+"");
        res=ps.executeQuery();
        while (res.next()) {
         Quries   ob=new Quries(
               res.getString( "RECIPENAME" ),
               res.getString( "CATEGORY" ),
               res.getString( "MAININGREDIENT" ),
               res.getInt( "PREPARATIONTIME" ),
               res.getInt( "COOKINGTIME" ));
                //System.out.println(res.getString( "RECIPENAME")+","+res.getString( "CATEGORY" )+", "+res.getString( "MAININGREDIENT" )+", "+res.getString( "PREPARATIONTIME" )+", "+res.getString( "COOKINGTIME" ));
                String data=res.getString("RECIPENAME")+","+res.getString( "CATEGORY" )+","+res.getString( "MAININGREDIENT" )+","+res.getInt( "PREPARATIONTIME" )+","+res.getInt( "COOKINGTIME" )+"";
                data+="\n";
                allData+=data;
                //System.out.println(data);
          }    
       }finally{
           if(ps!=null)ps.close();
           if(res!=null)res.close();
       }
       
   return allData;
   }
public int getMainIngrdientdb(String catorgy)throws Exception{
       PreparedStatement ps=null;
       String allData="";
       int i=0;
      try{
        ps = con.prepareStatement("select * from  RECIPES where MAININGREDIENT like '"+catorgy+"'");
        res=ps.executeQuery();
        while (res.next()) {
               System.out.println(""+res.getString( "MAININGREDIENT" ));
               i++;
          }    
       }finally{
           if(ps!=null)ps.close();
           if(res!=null)res.close();
       }
       
   return i;
   }

public String getDataByCombineFromDb(String catorgy,int start,int end)throws Exception{
       PreparedStatement ps=null;
       String allData="";
      try{
        ps = con.prepareStatement("select RECIPENAME,CATEGORY,MAININGREDIENT,PREPARATIONTIME,COOKINGTIME from  RECIPES where CATEGORY like '"+catorgy+"' and PREPARATIONTIME+COOKINGTIME between "+start+" And "+end+"");
        System.out.println(start+""+end);
        res=ps.executeQuery();
        while (res.next()) {
         Quries   ob=new Quries(
               res.getString( "RECIPENAME" ),
               res.getString( "CATEGORY" ),
               res.getString( "MAININGREDIENT" ),
               res.getInt( "PREPARATIONTIME" ),
               res.getInt( "COOKINGTIME" ));
                System.out.println(res.getString( "RECIPENAME")+","+res.getString( "CATEGORY" )+", "+res.getString( "MAININGREDIENT" )+", "+res.getString( "PREPARATIONTIME" )+", "+res.getString( "COOKINGTIME" ));
                String data=res.getString("RECIPENAME")+","+res.getString( "CATEGORY" )+","+res.getString( "MAININGREDIENT" )+","+res.getInt( "PREPARATIONTIME" )+","+res.getInt( "COOKINGTIME" )+"";
                data+="\n";
                allData+=data;
                //System.out.println(data);
          }    
       }finally{
           if(ps!=null)ps.close();
           if(res!=null)res.close();
       }
       
   return allData;
   }

}