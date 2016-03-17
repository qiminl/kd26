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
    
    public static class priceNameObject{
        String name;
        double price;
        public priceNameObject(String name,  double price){
            this.price = price;
            this.name = name;
        }
        public double getPrice(){
            return price;
        }
        public String getName(){
            return name;
        }
        
    }

    private static class cam{
        String name;
        double price;
        double[] attr;
        
        public cam (String name, double[] attr, double price){
            this.price = price;
            this.name = name;
            this.attr = attr;
        }
        public double[] getAttr(){
            return attr;
        }
        public String getName(){
            return name;
        }
        public double getPrice(){
            return price;
        }
        public Object getObject(){
            Object a;
            a = new priceNameObject(name, price);
            return a;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<cam> list = new ArrayList<>();
        Random rand =  new Random();;
        for (int i =0; i<10000; i++){
            double[] temp_array =  new double[26];
            for (int j = 0;  j<26; j++){
                temp_array[j] = rand.nextInt((100 - 0) + 1) + 0;
            }
            double price = (rand.nextInt((100 - 0) + 1) + 0)/10;
            String name = "campaign_" + Integer.toString(i);
            cam temp= temp = new cam(name,temp_array,price);
            list.add(temp);
        }
        
        KDTreeTest tree = new KDTreeTest(26);
        for (int i =0; i<list.size(); i++){
            tree.insertToTree(list.get(i).getObject(), list.get(i).getAttr());
        }
        
        
        double [] upper = new double[26];
        Arrays.fill(upper, 100);
        double [] lower = new double[26];
        Arrays.fill(lower, 0);
        
        Object[] a = tree.range(lower, upper);
        double priceMax = 0;
        String maxPriceObj = null;
        for (int i =0; i<a.length; i++){
            double tampPrice = ((priceNameObject)a[i]).getPrice();
            if( tampPrice>priceMax){
                priceMax = tampPrice;
                maxPriceObj = ((priceNameObject)a[i]).getName();
            }
          //System.out.println("object price= " + ((priceNameObject)a[i]).getPrice());
        }
        
        System.out.println("maxPriceObj= " + maxPriceObj);
        //System.out.println("object length = " + a.length);
        //System.out.println("object string = " + a.toString());
        
    }
    
}
