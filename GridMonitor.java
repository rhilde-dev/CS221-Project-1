import java.util.Scanner;
import java.io.*;

public class GridMonitor implements GridMonitorInterface {
    public static void main(String[] args) throws FileNotFoundException {
        GridMonitor grid = new GridMonitor("sample.txt");

    }

    /**
     * 
     * 
     * @param filename
     * @throws FileNotFoundException
     */
    public GridMonitor(String filename) throws FileNotFoundException{

        int row = 0;

        //scan file
        File file = new File(filename);
        Scanner fileScan = new Scanner(file);
        
        //scan first line for array dimensions
        Scanner lineScan = new Scanner(fileScan.nextLine());
        lineScan.useDelimiter(" ");

        //intialize new array with dimensions
        int[][] array = new int[Integer.parseInt(lineScan.next())][Integer.parseInt(lineScan.next())]; 
        lineScan.close();
        
        //initialize spaces with next lines
        while (fileScan.hasNextLine()){
            Scanner arrayScan = new Scanner(fileScan.nextLine());
            arrayScan.useDelimiter(" ");

            for (int i = 0; i < array[row].length; i++){
                //add each number to the row


            }

            row++;

        }
        
        fileScan.close();

    }

    /**
     * 
     *  
     */
    @Override
    public double[][] getBaseGrid() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 
     * 
     */
    @Override
    public double[][] getSurroundingSumGrid() {
        // TODO Auto-generated method stub
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
