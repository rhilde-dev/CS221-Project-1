import java.util.Scanner;
import java.io.*;

public class GridMonitor implements GridMonitorInterface {

    //instance variables
    double[][] baseGrid;
    int row = 0;
    int col = 0;

    public static void main(String[] args) throws FileNotFoundException {
        GridMonitor grid = new GridMonitor("oneByOne.txt");

    }

    /**
     * 
     * 
     * @param filename
     * @throws FileNotFoundException
     */
    public GridMonitor(String filename) throws FileNotFoundException{

        int count = 0;

        //scan file
        File file = new File(filename);
        Scanner fileScan = new Scanner(file);
        
        //scan first line for array dimensions
        Scanner lineScan = new Scanner(fileScan.nextLine());
        lineScan.useDelimiter(" ");

        //intialize new array with dimensions
        row = Integer.parseInt(lineScan.next());
        col = Integer.parseInt(lineScan.next());
        baseGrid = new double[row][col]; 
        lineScan.close();
        
        //initialize spaces with next lines
        while (fileScan.hasNextLine()){
            Scanner arrayScan = new Scanner(fileScan.nextLine());
            arrayScan.useDelimiter(" ");

            for (int i = 0; i < baseGrid[count].length; i++){
                //add each number to the row
                baseGrid[count][i] = Double.parseDouble(arrayScan.next());

            }
            
            count++;
            arrayScan.close();
        }
        
        // -- test for making sure array was made correctly --
        

        
        fileScan.close();

    }

    /**
     * 
     *  
     */
    @Override
    public double[][] getBaseGrid() {
        //make a copy of this
        return baseGrid;
    }

    /**
     * 
     * 
     */
    @Override
    public double[][] getSurroundingSumGrid() {
        //create new grid with same dimensions as baseGrid
        double[][] sumGrid = new double[row][col];
        //loop through baseGrid and make conditions for outOfBounds
        for(int i = 0; i < baseGrid.length; i++){
            for(int j = 0; j < baseGrid[i].length; j++){
                if(){

                }
            }
        }

        return null;
    }

    /**
     * 
     * 
     */
    @Override
    public double[][] getSurroundingAvgGrid() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 
     * 
     */
    @Override
    public double[][] getDeltaGrid() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 
     * 
     */
    @Override
    public boolean[][] getDangerGrid() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 
     * 
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}
