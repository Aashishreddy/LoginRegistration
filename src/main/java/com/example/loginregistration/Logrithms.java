package com.example.loginregistration;

import java.util.*;

public class Logrithms {
    public static void main(String[] args){
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        hm.put(1,1);
        hm.put(2,2);
        if (hm.containsKey(1)){
            System.out.println(hm.get(1));
        }else{
             System.out.println("-1");
        }
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
        }

        //HASHSET
        List<Integer> keys = Arrays.asList(1,2,3,4,1,2,4,5);
        Set<Integer> hs = new HashSet<>();
        for(Integer key: keys){
            hs.add(key);
        }
        System.out.println(hs);

        //CONTAINS DUPLICATE
        int[] nums = {1,2,3,1};
        boolean output = containsDuplicate(nums);
        System.out.println(output);
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int num: nums){
            if(hs.contains(num)){
                return true;
            }
            hs.add(num);
        }
        return false;
    }





}
