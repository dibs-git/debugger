package com.test.hashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Hashset
{
    public static String getOut(int numberOfMatches, String squads, int squad1, int squad2)
    {
      List<String> ListArr = new ArrayList<>();
      HashSet<String> setArr= new HashSet<String>();
      HashSet<String> setArr1= new HashSet<String>();
      String[] squadArr = squads.split("#");
      for(int i =0; i<squadArr.length;i++){
        List<String> tempListArr = new ArrayList<>(Arrays.asList(squadArr[i].split(" ")));
        if(i == 0){
          ListArr.addAll(tempListArr);
        } else{
          ListArr.retainAll(tempListArr);
        }
//        System.out.println(ListArr);
      }
      setArr.addAll(ListArr);
      String output1 = "";
      for(String st: setArr){
        output1 = output1 + st+ " ";
      }
      output1 = output1.trim();
      List<String> tempListArr1 = new ArrayList<>(Arrays.asList(squadArr[squad2-1].split(" ")));
      List<String> tempListArr2 = new ArrayList<>(Arrays.asList(squadArr[squad1-1].split(" ")));
      tempListArr1.removeAll(tempListArr2);
      setArr1.addAll(tempListArr1);
      String output2 = "";
      for(String st: setArr1){
        output2 = output2 + st+ " ";
      }
      output2 = output2.trim();
      String output = output1+", "+output2;
      System.out.println(output);
        return output;
    }
}

