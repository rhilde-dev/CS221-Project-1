import java.util.Scanner;
import java.io.*;

public class GridMonitor implements GridMonitorInterface {
    public static void main(String[] args) {
        GridMonitor grid = new GridMonitor("sample.txt");
        
    }

    public GridMonitor(String filename) throws FileNotFoundException{
        
        File file = new File(filename);
        Scanner fileScan = new Scanner(file);
        System.out.println(fileScan.nextLine());

        fileScan.close();

    }

    @Override
    public double[][] getBaseGrid() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double[][] getSurroundingSumGrid() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double[][] getSurroundingAvgGrid() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double[][] getDeltaGrid() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean[][] getDangerGrid() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}
