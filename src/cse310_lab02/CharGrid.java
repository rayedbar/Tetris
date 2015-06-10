/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse310_lab02;

/**
 *
 * @author Rayed
 */
public class CharGrid {
    // char grid to look for given char
    private final char [][] grid = new char [][] {
        {'a', 'b', 'c', 'd'},
        {'a', ' ', 'c', 'b'},
        {'x', 'b', 'c', 'a'},
        {'x', 'b', ' ', 'x'}
    };
    
    /**
     *
     * @param ch
     * @return area for given char if found else 0
     */
    public int charArea (char ch){
        int area = 0; 
        int xMax = -1, xMin = grid[0].length + 1;
        int yMax = -1, yMin = grid.length + 1;
        boolean flag = false;
        
        for (int y = 0; y < grid.length; ++y){
            for (int x = 0; x < grid[y].length; ++x){
                if (grid[y][x] == ch){
                    // update min and max values
                    xMin = xMin < x ? xMin : x;  
                    xMax = xMax > x ? xMax : x;
                    yMin = yMin < y ? yMin : y;
                    yMax = yMax > y ? yMax : y; 
                    
                    flag = true;
                }
            }
        }
        
        if (flag) {
            area = (xMax - xMin + 1) * (yMax - yMin + 1);
        }
        
        return area;
    }   
}
