/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.List;

public interface IQueries {
     List< Quries > getAllData();
        int addData(String name,String category,String prepTimeStart,String prepTimeEnd,String cookingstartTime,String cookingEndTime,String combineStartTime,String combineEndTime,String ingranted);
   
      void close();
}
