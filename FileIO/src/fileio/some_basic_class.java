/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class some_basic_class {
    public static void main(String[] args) throws IOException {
        File f= new File("f1.txt");
        System.out.println("Ten file la:"+f.getName());
        System.out.println("Ten file tuyet doi la:"+f.getAbsoluteFile());
        System.out.println("Duong dan tuyet doi la:"+f.getAbsolutePath());
        System.out.println("path chuan la:"+f.getCanonicalPath());
        System.out.println("thuoc tinh can-read"+f.canRead());
        System.out.println("thuoc tinh can-write"+f.canWrite());
        System.out.println("kich thuoc"+f.length());
    }
}
