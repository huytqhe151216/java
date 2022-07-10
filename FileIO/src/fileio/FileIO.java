/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author ADMIN
 */
public class FileIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String txt ="nguyen van a";
        try {
            FileWriter fw = new FileWriter("data.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(txt);
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
        try {
            FileReader fr= new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line ="";
            while(true){
                line = br.readLine();
                if (line== null)
                    break;
                System.out.println(line);
            }
        } catch (Exception e) {
        }
    }
    
}
