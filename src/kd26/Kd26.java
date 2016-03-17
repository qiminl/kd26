/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kd26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author liuqi
 */
public class Kd26 {

    private static class cam{
        String name;
        double[] attr;
        
        public cam (String name, double[] attr){
            this.name = name;
            this.attr = attr;
        }
        public double[] getAttr(){
            return attr;
        }
        public String getName(){
            return name;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<cam> list = new ArrayList<>();
        Random rand =  new Random();;
        for (int i =0; i<15; i++){
            double[] temp_array =  new double[26];
            for (int j = 0;  j<26; j++){
                temp_array[j] = rand.nextInt((100 - 0) + 1) + 0;
            }
            
            String name = "campaign_" + Integer.toString(i);
            cam temp= temp = new cam(name,temp_array);
            list.add(temp);
        }
        
        KDTreeTest tree = new KDTreeTest(26);
        for (int i =0; i<list.size(); i++){
            tree.insertToTree(list.get(i).getName(), list.get(i).getAttr());
        }
        
        
        double [] upper = new double[26];
        Arrays.fill(upper, 100);
        double [] lower = new double[26];
        Arrays.fill(lower, 0);
        
        Object[] a = tree.range(lower, upper);
        System.out.println("object length = " + a.length);
        System.out.println("object string = " + a.toString());
        for(int i = 0; i<a.length; i++){
            System.out.println("i = " + i);
            System.out.println( ((cam)a[i]).getName());
        }
        
    }
    
}
