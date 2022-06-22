package com.test.treeMap;

import java.util.*;

public class TreemapHandson {
    
    public TreeMap<Integer,String> createPlayerPositionMap(String cricketDataset)
    {
    	String[] strArr = cricketDataset.split("\\|");
		TreeMap<Integer, String> positionMap = new TreeMap<Integer, String>();
		for (String str : strArr) {
			positionMap.put(Integer.parseInt(str.split(",")[0]), str.split(",")[1]);
		}
		return positionMap;
        
    }
    public TreeMap<String,Integer> createPlayerScoreMap(String cricketDataset)
    {
    	String[] strArr = cricketDataset.split("\\|");
		TreeMap<String, Integer> scoreMap = new TreeMap<String, Integer>();
		for (String str : strArr) {
			scoreMap.put(str.split(",")[1], Integer.parseInt(str.split(",")[2]));
		}
		return scoreMap;
    }
    public TreeMap<?,?> createMatchesMap(String cricketDataset)
    {
    	TreeMap<?,?> matchMap = new TreeMap<>();   
        return matchMap;
    }
    
    
    public String getQuery(String cricketDataset,String query)
    {
    	String output = "";
    	if(query.split(" ")[0].equals("1")) {
        	TreeMap<Integer, String> positionMap = createPlayerPositionMap(cricketDataset);

    		int startPos = Integer.parseInt(query.split(" ")[1]);
    		int endPos = Integer.parseInt(query.split(" ")[02]);
    		for(int i = startPos; i<= endPos; i++) {
    			output = output + i + " " + positionMap.get(i)+"\n";
    		}
    	} else if(query.split(" ")[0].equals("2")) {
        	TreeMap<Integer, String> positionMap = createPlayerPositionMap(cricketDataset);
        	TreeMap<String, Integer> scoreMap = createPlayerScoreMap(cricketDataset);

    		TreeMap<Integer, String> positionMap1 = new TreeMap<Integer, String>();
    		int score = Integer.parseInt(query.split(" ")[1]);
    		for(Map.Entry<String, Integer> map: scoreMap.entrySet()) {
    			if(map.getValue()>score) {
    				for(Map.Entry<Integer, String> map1: positionMap.entrySet()) {
    					if(map1.getValue().equals(map.getKey())) {
    						positionMap1.put(map1.getKey(), map1.getValue());
    					}
    				}
    			}
    		}
    		for(Map.Entry<Integer, String> map: positionMap1.entrySet()) {
    			output = output + map.getKey() + " " + map.getValue()+"\n";
    		}
    	} else if(query.split(" ")[0].equals("3")) {
    		String[] strArr = cricketDataset.split("\\n");
    		System.out.println(strArr.length);
    		TreeMap<String, Integer> openerMap = new TreeMap<String, Integer>();
    		TreeMap<String, Integer> openerMapCount = new TreeMap<String, Integer>();
    		for(String str: strArr) {
    			TreeMap<Integer, String> positionMap = createPlayerPositionMap(str);
            	TreeMap<String, Integer> scoreMap = createPlayerScoreMap(str);
            	for(Map.Entry<Integer, String> map: positionMap.entrySet()) {
            		if(map.getKey() == 1) {
            			int score = scoreMap.get(map.getValue());
            			if(openerMap.containsKey(map.getValue())) {
            				int oldScore = openerMap.get(map.getValue());
            				openerMap.put(map.getValue(), oldScore+score);
            				int oldCount = openerMapCount.get(map.getValue());
            				openerMapCount.put(map.getValue(), oldCount+1);
            			} else {
            				openerMap.put(map.getValue(), score);
            				openerMapCount.put(map.getValue(), 1);
            			}
            		}
            	}
    		}
    		int avg = 0;
    		String opener = "";
    		for(Map.Entry<String, Integer> map: openerMap.entrySet()) {
    			if(map.getValue()>=avg) {
    				opener = map.getKey();
    				avg = map.getValue();
    			}
    		}
    		output = "The Efficient Opener is "+opener;
    	}
    	System.out.println(output);
        return output;
    }
    
    
    
    
    
}
            

        
        
        
        
        


