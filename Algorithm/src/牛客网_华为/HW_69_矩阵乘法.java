package 牛客网_华为;

import java.util.*;
public class HW_69_矩阵乘法{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int[][] m1 = new int[x][y];
            int[][] m2 = new int[y][z];
            int[][] r = new int[x][z];
            for(int i=0; i<x; i++) {
                for(int j=0; j<y; j++) {
                    m1[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<y; i++) {
                for(int j=0; j<z; j++) {
                    m2[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<x; i++) {
                for(int j=0; j<z; j++) {
                    for(int k=0; k<y; k++) {
                        r[i][j] = r[i][j]+m1[i][k]*m2[k][j];
                    }
                }
            }
            for(int i=0; i<x; i++) {
                for(int j=0; j<z; j++) {
                    System.out.print(r[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}