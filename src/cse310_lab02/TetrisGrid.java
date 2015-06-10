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
public class TetrisGrid {

    // Private instance variable holding the grid structure.

    private final boolean[][] grid = new boolean[][]{
        {true, true, true, true, false, true, true, true, true},
        {true, true, true, true, true, false, true, true, true},
        {true, false, true, true, true, false, true, false, true}
    };

    public void displayGrid() {
        for (int y = grid[0].length - 1; y >= 0; --y) {
            for (boolean[] gridX : grid) {
                System.out.print(gridX[y] ? "x " : "  ");
            }
            System.out.println();
        }
    }

    public void clearRows() {
        clearRows(0);
    }
    
    private void clearRows(int row) {
        for (int y = row; y < grid[0].length; ++y) {
            boolean flag = true;
            for (boolean[] gridX : grid) {
                if (!gridX[y]) {
                    flag = false;
                }
            }
            if (flag) {
                clearRow(y);
                clearRows(y);
            }
        }
    }
    
    private void clearRow(int row) {
        for (int y = row + 1; y < grid[0].length; ++y) {
            for (boolean [] gridX : grid) {
                gridX[y - 1] = gridX[y];
            }
        }
        for (boolean [] gridX : grid) {
            gridX[grid[0].length - 1] = false;
        }
    }
}
