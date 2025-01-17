import java.util.Scanner;
import java.io.*;

public class GridMonitor implements GridMonitorInterface {

    //instance variables
    private double[][] baseGrid;
    private double[][] sumGrid;
    private double[][] avgGrid;
    private double[][] deltaGrid;
    private boolean[][] dangerGrid;
    private int row = 0;
    private int col = 0;

    public static void main(String[] args) throws FileNotFoundException {
        GridMonitor grid = new GridMonitor("sample.txt");

        for(int i = 0; i < grid.getBaseGrid().length; i++){
            for(int j = 0; j < grid.getBaseGrid()[i].length; j++){
                System.out.print(grid.getBaseGrid()[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < grid.getSurroundingSumGrid().length; i++){
            for(int j = 0; j < grid.getSurroundingSumGrid()[i].length; j++){
                System.out.print(grid.getSurroundingSumGrid()[i][j] + " ");
            }
            System.out.println();
        }
        
        for(int i = 0; i < grid.getSurroundingAvgGrid().length; i++){
            for(int j = 0; j < grid.getSurroundingAvgGrid()[i].length; j++){
                System.out.print(grid.getSurroundingAvgGrid()[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < grid.getDeltaGrid().length; i++){
            for(int j = 0; j < grid.getDeltaGrid()[i].length; j++){
                System.out.print(grid.getDeltaGrid()[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < grid.getDangerGrid().length; i++){
            for(int j = 0; j < grid.getDangerGrid()[i].length; j++){
                System.out.print(grid.getDangerGrid()[i][j] + " ");
            }
            System.out.println();
        }

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

        
        fileScan.close();

    }

    /**
     * 
     *  
     */
    @Override
    public double[][] getBaseGrid() {
        //make a copy of this
        double[][] baseGridCopy = new double[row][col];
        for(int i = 0; i < baseGrid.length; i++){
            for(int j = 0; j < baseGrid[i].length; j++){
                baseGridCopy[i][j] = baseGrid[i][j];
            }
        }
        return baseGridCopy;
    }

    /**
     * 
     * 
     */
    @Override
    public double[][] getSurroundingSumGrid() {
        //create new grid with same dimensions as baseGrid
        sumGrid = new double[row][col];
        //loop through baseGrid and make conditions for outOfBounds
        for(int i = 0; i < this.baseGrid.length; i++){
            for(int j = 0; j < this.baseGrid[i].length; j++){
                //bounds: row < 0, col < 0, row > array length, col > array[row] length
                double sum = 0;

                //value up
                if((i-1) < 0 ){
                    sum += baseGrid[i][j];
                } else {
                    sum += baseGrid[i-1][j];
                }

                //value left
                if((j-1) < 0){
                    sum += baseGrid[i][j];
                } else {
                    sum += baseGrid[i][j-1];
                }

                //value down
                if((i+1) > baseGrid.length - 1){
                    sum += baseGrid[i][j];
                } else {
                    sum += baseGrid[i+1][j];
                }

                //value right
                if((j+1) > baseGrid[i].length - 1){
                    sum += baseGrid[i][j];
                } else {
                    sum += baseGrid[i][j+1];
                }

                //add surrounding to sum to specified gridpoint in sumGrid
                sumGrid[i][j] = sum;
            }
        }

        //copy for encapsulation
        double[][] sumGridCopy = new double[row][col];
        for(int i = 0; i < sumGrid.length; i++){
            for(int j = 0; j < sumGrid[i].length; j++){
                sumGridCopy[i][j] = sumGrid[i][j];
            }
        }
        return sumGridCopy;
    }

    /**
     * 
     * 
     */
    @Override
    public double[][] getSurroundingAvgGrid() {
        avgGrid = new double[row][col];
        for(int i = 0; i < avgGrid.length; i++){
            for(int j = 0; j < avgGrid[i].length; j++){
                avgGrid[i][j] = this.sumGrid[i][j] / 4;
            }
        }

        //copy for encapsulation
        double[][] avgGridCopy = new double[row][col];
        for(int i = 0; i < avgGrid.length; i++){
            for(int j = 0; j < avgGrid[i].length; j++){
                avgGridCopy[i][j] = avgGrid[i][j];
            }
        }
        return avgGridCopy;
    }

    /**
     * 
     * 
     */
    @Override
    public double[][] getDeltaGrid() {
        deltaGrid = new double[row][col];
        for(int i = 0; i < deltaGrid.length; i++){
            for(int j = 0; j < deltaGrid[i].length; j++){
                deltaGrid[i][j] = this.avgGrid[i][j] / 2;
            }
        }

        //copy for encapsulation
        double[][] deltaGridCopy = new double[row][col];
        for(int i = 0; i < deltaGrid.length; i++){
            for(int j = 0; j < deltaGrid[i].length; j++){
                deltaGridCopy[i][j] = deltaGrid[i][j];
            }
        }
        return deltaGridCopy;
    }

    /**
     * 
     * 
     */
    @Override
    public boolean[][] getDangerGrid() {
        
        dangerGrid = new boolean[row][col];

        for(int i = 0; i < this.avgGrid.length; i++){
            for(int j = 0; j < this.avgGrid[i].length; j++){
                if (this.baseGrid[i][j] > this.avgGrid[i][j] + this.deltaGrid[i][j] || this.baseGrid[i][j] < this.avgGrid[i][j] - this.deltaGrid[i][j]){
                    dangerGrid[i][j] = true;
                } else {
                    dangerGrid[i][j] = false;
                }
            }
        }

        //copy for encapsulation
        boolean[][] dangerGridCopy = new boolean[row][col];
        for(int i = 0; i < dangerGrid.length; i++){
            for(int j = 0; j < dangerGrid[i].length; j++){
                dangerGridCopy[i][j] = dangerGrid[i][j];
            }
        }
        return dangerGridCopy;
    }

    /**
     * 
     * 
     */
    @Override
    public String toString() {

        // for(int i = 0; i < getBaseGrid().length; i++){
        //     String gridLine = new String();
        //     for(int j = 0; j < getBaseGrid()[i].length; j++){
        //         gridLine = getBaseGrid()[i][j] + " ";
        //     }
        //      gridLine + "\n";
        // }

        // for(int i = 0; i < grid.getSurroundingAvgGrid().length; i++){
        //     for(int j = 0; j < grid.getSurroundingAvgGrid()[i].length; j++){
        //         System.out.print(grid.getSurroundingAvgGrid()[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // for(int i = 0; i < grid.getDeltaGrid().length; i++){
        //     for(int j = 0; j < grid.getDeltaGrid()[i].length; j++){
        //         System.out.print(grid.getDeltaGrid()[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return super.toString();
    }

}
