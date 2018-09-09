/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Model.Quries;
import java.util.Vector;

/**
 *
 * @author Shanker Nath
 */
public interface IView {
    void setNameTextField(String s);
    String getNameTextField(); 
    
    void setCaterogy(String s);
    String getCategoryTextField(); 
    
    void setPerparStartTime(String s);
    String getPerparStartTime(); 
   
    void setCookStartTime(String s);
    String getCookStartTime();
    
    void setCombiStartTime(String s);
    String getCombineStartTime();
    
    void setPerparEndTime(String s);
    String getPerparEndTime(); 
   
    void setCookEndTime(String s);
    String getCookEndTime();
    
    void setCombiEndTime(String s);
    String getCombineEndTime();
    
   void setMainIngredientTime(String s);
    String getMainIngredientTime();

    void enableNext();
    void enablePrevious();
    
    void showMessageDialog( String s1, String s2 );
    
   
}
