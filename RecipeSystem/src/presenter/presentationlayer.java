/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presenter;

import Model.Quries;
import Model.RecipeHandler;
import View.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Shanker Nath
 */
public class presentationlayer {
    View view;
    RecipeHandler queres;
    public presentationlayer(View ipv,RecipeHandler ip) {
        super();
        view=ipv;
        queres=ip;
    }
    public void clearData(){
    view.setNameTextField(null);
    view.setPerparStartTime(null);
    view.setPerparEndTime(null);
    view.setCookStartTime(null);
    view.setCookEndTime(null);
    view.setCombiStartTime(null);
    view.setCombiEndTime(null);
    view.setCaterogy(null);
    view.setMainIngredientTime(null);
    }
    public void insertDataInDataBase(){
        try{
            int pre=Integer.parseInt(view.getPerparStartTime());
            int cook=Integer.parseInt(view.getCookStartTime());
        int result=queres.addData(view.getNameTextField(),view.getCategoryTextField(),view.getMainIngredientTime(),pre,cook);
        if (result==1)
         view.showMessageDialog("Recored Save","Recored Save");
      else
              view.showMessageDialog("","Error");
     
       }catch(Exception ex){ex.printStackTrace();}
    }
    
   
   public String getDataByCatogry(String s)throws Exception{
    String data= queres.getDataByCatorgy(s);
     return data;
   }
   public String getDataByCatogryAndPreparTime(String catorgy,int start,int end)throws Exception{
    String data= queres.getDataByCPFromDb(catorgy,start,end);
     return data;
   }
   
   public String getDataByCombineTime(String catorgy,int start,int end)throws Exception{
    String data= queres.getDataByCombineFromDb(catorgy,start,end);
     return data;
   }
   
   public int getMainIngrdient(String s)throws Exception{
    int numof= queres.getMainIngrdientdb(s);
     return numof;
   }
   
   
}
