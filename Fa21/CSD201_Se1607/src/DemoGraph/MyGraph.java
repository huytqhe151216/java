
/*
 * Copyright(C) 2005, FPT university
 * ...
 * ...
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 HuyTQ           First Implement
 */
package DemoGraph;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 *
 * @author ADMIN
 */
public class MyGraph {
    int [][]a;
    int size;

    public MyGraph() {
        try {
            RandomAccessFile raf = new RandomAccessFile("inputShortest.txt", "r");
            size = Integer.parseInt(raf.readLine());
            a = new int[size][size];
            String s = "";
            int i=0;
            while ((s=raf.readLine())!=null) {
                String []s1=s.split("\\s+");
                for (int j = 0; j < size; j++) {
                 a[i][j]=Integer.parseInt(s1[j]);
                }
                i++;
            }
            for (int j = 0; j < size; j++) {
                for ( i=j ; i<size ; i++) {
                    a[i][j]=a[j][i];
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("loi");
        }
        
    }
    int Floyd(int x, int y){
        int [][]d = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                d[i][j]=a[i][j];
            }
        }
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (d[i][j]>d[i][k]+d[k][j]) {
                        d[i][j]=d[i][k]+d[k][j];
                    }
                }
            }
        }
        return d[x][y];
    }
    void display(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }
    int deg(char c){
        int x= toInt(c);
        int count=0;
        for (int i = 0; i < size; i++) {
            count += a[i][x]!=0?1:0;
        }
        return count;
    }
    char toChar(int x){
        return (char)(x+65);
    }
    int toInt(char c){
        return (int)(c-65);
    }
    void visit(int p){
        System.out.print(toChar(p)+" ->");
    }
    void Depth_first(char c){
        boolean []visited= new boolean[size];
        Arrays.fill(visited, false);
        int p=toInt(c);
        visited[p]=true;
        Depth_first(p, visited);
    }
    void Depth_first(int u, boolean []visited){
        visited[u]=true;
        visit(u);
        for (int v = 0; v < size; v++) {
            if (!visited[v]&&a[u][v]!=0) {
                visited[v]=true;
                Depth_first(v, visited);
            }
        }
    }
    void visit1(int p){
        System.out.print(toChar(p)+"("+deg(toChar(p))+")"+" ->");
    }
    void breadth_first(char c){
       int p=toInt(c);
       boolean []visited = new boolean[size];
       Arrays.fill(visited, false);
       MyQueue my= new MyQueue();
        visited[p]=true;
        my.EnQueue(p);
        while (!my.isEmpty()) {
            int q=my.DeQueue();
            for (int i = 0; i < size; i++) {
                if (!visited[i]&&a[i][q]==1) {
                    my.EnQueue(i);
                    visited[i]=true;
                }
            }
            visit(q);
        }
        
    }
    void breadth_first1(char c){//in ra tất cả các đỉnh có bậc >=3
       int p=toInt(c);
       boolean []visited = new boolean[size];
       Arrays.fill(visited, false);
       MyQueue my= new MyQueue();
        visited[p]=true;
        my.EnQueue(p);
        while (!my.isEmpty()) {
            int q=my.DeQueue();
            for (int i = 0; i < size; i++) {
                if (!visited[i]&&a[i][q]==1) {
                    my.EnQueue(i);
                    visited[i]=true;
                }
            }
            
            if (deg(toChar(q))>=4) {
                visit1(q);
            }
        }
        
    }
}
class Using{
 public static void main(String[] args) {
        MyGraph my= new MyGraph();
        my.display();
//        my.breadth_first1('A');
//        my.Depth_first('A');
        System.out.println(my.Floyd(1, 4));
}
}
