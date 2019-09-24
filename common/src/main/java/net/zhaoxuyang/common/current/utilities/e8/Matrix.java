
package net.zhaoxuyang.common.current.utilities.e8;

/**
 *
 * @author zhaoxuyang
 */
public class Matrix {

    private final int[][] martix;
    
    public Matrix(int rows, int cols){
        martix = new int[rows][cols];
    }
    
    public int getCols(){
        return martix[0].length;
    }
    
    public int getRows(){
        return martix.length;
    }
    
    public int getValue(int rows,int cols){
        return martix[rows][cols];
    }
    
    public void setValue(int rows,int cols, int value){
        martix[rows][cols] = value;
    }
}
