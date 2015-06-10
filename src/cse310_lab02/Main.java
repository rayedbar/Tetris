/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse310_lab02;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.Scanner;
/**
 *
 * @author Rayed
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
//        System.out.println("Enter String to Blow Up:" );
//        blowUp(sc.nextLine());
//        System.out.println("Enter String to Find Run:" );
//        maxRun(sc.nextLine());
        
//        CharGrid charGrid = new CharGrid();
//        int area = charGrid.charArea('a');
//        System.out.println("Area is: " + area);
        
//        TetrisGridSample tetrisGrid = new TetrisGridSample();
//        tetrisGrid.display();
//        tetrisGrid.clearRows();
//        tetrisGrid.display();
        
        TetrisGrid tetrisGrid = new TetrisGrid();
        tetrisGrid.displayGrid();
        tetrisGrid.clearRows();
        tetrisGrid.displayGrid();
    }

    private static void blowUp (String s){
        String s1 = ""; 
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                stack.push(Character.getNumericValue(c));
            } else {
                if (!stack.isEmpty()){
                    int j = stack.pop();
                    for (int k = 0; k < j; k++){
                        s1 += c;
                    }
                } else {
                    s1 += c;
                }
            }
        }
        
        System.out.println(s1);
    }

    private static void maxRun (String s) {
        int run;
        char [] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        
        for (Character c : array){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        run = Collections.max(map.values());
        
        for (Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() == run){
                System.out.println(entry.getKey());
            }
        }
    }
}
