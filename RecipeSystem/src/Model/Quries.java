/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

public final class Quries {
        private String receptName;
        private String category;
        
       private String mainIngredent;
        private int cookTime;
       private  int preTime;

    public Quries(String receptName, String category, String mainIngredent, int preTime,int cookTime ) {
       setReceptName(receptName);
       setCategory(category);
       setMainIngredent(mainIngredent);
       setCookTime(cookTime);
       setPreTime(preTime);
     //  System.out.println(this.receptName+"-----------");
    }

    public String getReceptName() {
        return receptName;
    }

    public void setReceptName(String receptName) {
        this.receptName = receptName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getPreTime() {
        return preTime;
    }

    public void setPreTime(int preTime) {
        this.preTime = preTime;
    }

    public String getMainIngredent() {
        return mainIngredent;
    }

    public void setMainIngredent(String mainIngredent) {
        this.mainIngredent = mainIngredent;
    }
    public String toString(){
    return this.receptName; 
    }
   
}
