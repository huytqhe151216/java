/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democolection;
//import java.util.ArrayList;
//import java.util.Vector;
import java.util.*;
/**
 *
 * @author ADMIN
 */
public class demiList {
    public static void main(String[] args) {
        ArrayList ar =new ArrayList();
        //Vetor vec = new Vector();
        ar.add(20);
        ar.add("Hello");
        ar.add(true);
        ar.add(20);
        ar.add(2,"khong co");
        System.out.println(ar);//in ra doi tuong ar
        
        // để đưa dữ liệu vào dùng add: thêm vào cuối danh sách
        //  để lấy ra get(i);
        Vector br = new Vector();
        br.add(20);
        br.add(false);
        br.add("Khong Co");
        //ar.add(br);// coi br là 1 đối tượng và nó add đối tượng
        ar.addAll(br);// copy từng phần tử br rồi add vào ar;
        //ar.remove(pa);nếu pa là số nguyên thì JVM hiểu số bỏ phần tư có chỉ số para
        //0 <pa<size()
        // nếu pa không nguyên thì JVM hiểu là xóa bỏ đối tượng pa đầu tiên nó gặp trong ar
        System.out.println(ar);
        ar.remove(20.0);
      //  ar.retainAll(br)  xóa bỏ tất cả phần tử trong ar mà chỉ giữ lại các phần tử có trong br
      // ar.contains(obj) kiểm tra xem có chưa phàn từ obj ko?
      // ar.containsAll kiểm tra xem ar có chứ tất cả objkhoong true false
        System.out.println("ar="+ar);
        System.out.println("br="+br);
//        // de truy  xuất vào từng phần tử của list
//        System.out.println("c2: truy xuất thông qua chỉ số ");
//        for (int i = 0; i < ar.size(); i++) {//size tr ve  kích thước của collection
//            System.out.println(ar.get(i)+". ");
//            
//        }
//         System.out.println("c3: truy xuất thông qua iterator ");
//         for (Iterator it= ar.iterator();it.hasNext();){
//             Object next = it.next();
//             System.out.println(next+"; ");
//         }
//         System.out.println("c4: truy xuất thông qua iterator- while ");
//         Iterator it= ar.iterator();
//         while (it.hasNext()){
//             Object obj = it.next();
//             System.out.println(obj+"' ");
//         }
//         System.out.println("\nc5: truy xuất thông qua foreach ");
//         for (Object object : ar){
//             System.out.println(object+"' ");
//         }
    }
}
