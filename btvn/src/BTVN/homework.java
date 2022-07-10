/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTVN;

import java.util.HashMap;
import java.util.Scanner;
import java.util.LinkedList;

/**
 *
 * @author ADMIN
 */
class YourHW {

    int f1(String s) {
        String s1[] = s.split("\\s+");
        int count = 0;
        for (int i = 0; i < s1.length; i++) {
            if (check(s1[i])) {
                count++;
            }
        }
        return count;
    }

    int f2(String s) {
        String s2[] = s.split("\\s+");
        int count = 0;
        for (int i = 0; i < s2.length; i++) {
            if (check2(s2[i].charAt(0))) {
                count++;
            }
        }
        return count;
    }

    boolean check(String s) {
        // đếm và trả về sô từ trong chuỗi s có độ dài lớn hơn 3
        return s.length() >= 3;
    }

    boolean check1(String s) {
        // đếm và trả về sô từ trong chuỗi s có độ dài nhỏ hơn 5
        return s.length() <= 5;
    }

    boolean check2(char x) {
        //đếm và trả về số từ bắt đầu bằng nguyên âm

        if (x == 'a' || x == 'i' || x == 'o' || x == 'u' || x == 'e') {
            return 2 > 1;
        } else {
            return 1 > 3;
        }

    }

    void check3(String s) {
        // đếm số từ xuất hiện trong chuỗi không phân biệt chữ hoa chữ thường
        String[] s1 = s.split("\\s+");
        int n = s1.length;
        int[] tempS1 = new int[n];
        for (int i = 0; i < n; i++) {
            tempS1[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (s1[i].compareToIgnoreCase(s1[j]) == 0) {
                    tempS1[j] = 0;
                    count++;
                }
            }
            if (tempS1[i] != 0) {
                tempS1[i] = count;
            }
        }
        System.out.println("đếm số từ xuất hiện:");
        for (int i = 0; i < n; i++) {
            if (tempS1[i] != 0) {
                System.out.println(s1[i].toLowerCase() + " " + tempS1[i]);
            }
        }
    }

    void check4(String s) {
        // đếm xem có bao nhiêu chữ bắt đầu bằng ký tự in hoa.
        String[] s1 = s.split("\\s+");
        int count = 0;
        for (String x : s1) {
            if (x.charAt(0) >= 'A' && x.charAt(0) <= 'Z') {
                count++;
            }
        }
        System.out.println(count);
    }

    void check5(String s) {
        // đếm tất cả các words hoa trong string.
        String[] s1 = s.split("\\s+");
        int count = 0;
        for (String x : s1) {
            if (x.compareTo(x.toUpperCase()) == 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    void check6(String s) {
        // đếm tất cả các words viết thường trong string.
        String[] s1 = s.split("\\s+");
        int count = 0;
        for (String x : s1) {
            if (x.compareTo(x.toUpperCase()) == 0) {
                count++;
            }
        }
        System.out.println(count);

    }

    void check7(String s) {
        // đếm xem có bn từ chứa nguyên âm và in ra.
        String[] s1 = s.trim().split("\\s+");
        LinkedList<String> list = new LinkedList<>();
        int count = 0;
        for (String x : s1) {
            if (x.toLowerCase().contains("a") || x.toLowerCase().contains("e")
                    || x.toLowerCase().contains("o")
                    || x.toLowerCase().contains("u") || x.toLowerCase().contains("i")) {
                count++;
                list.add(x);
            }
        }
        System.out.println("There are: " + count + " words that contain vowels and they are: ");
        System.out.println(list);

    }

    int countVowel(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char temp = s.toLowerCase().charAt(i);
            if (temp == 'a' || temp == 'e' || temp == 'o' || temp == 'u' || temp == 'i') {
                count++;
            }
        }
        return count;
    }

    void check8(String s) {
        //kiểm tra xem bao nhiêu nguyên âm là nhiều nhất
        String[] s1 = s.trim().split("\\s+");
        int max = countVowel(s1[0]);
        for (String x : s1) {
            if (countVowel(x) > max) {
                max = countVowel(x);
            }
        }
        System.out.println("The word that contains the most vowels (cointain: " + max + " vowels)");
    }

    void check9(String s) {
        // xem từ nào có đúng 2 nguyên âm
        String[] s1 = s.split("\\s+");
        for (String x : s1) {
            if (countVowel(x) == 2) {
                System.out.println(x);
            }
        }
    }

    void check10(String s) {
        // kiểm tra xem dãy có đảo ngược
        StringBuilder s1 = new StringBuilder(s);
        System.out.println(s1.reverse().toString().equals(s));
    }

    StringBuilder checkDuplicateString(String s) {
        StringBuilder tempStr = new StringBuilder(s);
        for (int i = 0; i < tempStr.length() - 1; i++) {
            if (tempStr.charAt(i) == tempStr.charAt(i + 1)) {
                tempStr.replace(i, i + 2, "");
            }
        }
        return tempStr;
    }

    boolean check11(String s) {
        //kiểm tra xem 1 từ có phải kí tự thường
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) < 'a' || s.charAt(i) > 'z') && (s.charAt(i) < 'A' || s.charAt(i) > 'Z')) {
                return false;
            }
        }
        return true;
    }

    void check12(String s) {
        //kiểm tra xem 1 câu có từ nào là kí tự thường  , nếu có thì in ra
        String[] s1 = s.trim().split("\\s+");
        int count = 0;
        LinkedList<String> list = new LinkedList<>();
        for (String x : s1) {
            if (check11(x) == true) {
                count++;
                list.add(x);
            }
        }
        System.out.println("There are: " + count + " valid words and they are: ");
        System.out.println(list);
    }

    int check13(String s) {
        // tính điểm của  1 từ 
        // mỗi kí tự của mỗi từ sẽ có một diem như sau a=1, b=2... z=21
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.toLowerCase().codePointAt(i) - 96;
        }
        System.out.println(sum);
        return sum;
    }

    void check14(String s) {
        //kiểm tra xem trong câu từ nào có điểm lớn nhất, điểm tính theo check13
        String[] s1 = s.trim().split("\\s+");
        int max = 0;
        int tempIndex = 0;
        for (int i = 0; i < s1.length; i++) {
            if (check13(s1[i]) > max) {
                max = check13(s1[i]);
                tempIndex = i;
            }
        }
        System.out.println(s1[tempIndex]);
    }

    void check15(String name) {
        // chuẩn hóa tên
        String arrString[] = name.trim().toLowerCase().split("\\s+");
        String answer = "";
        for (String item : arrString) {
            if (item.length() > 0) {
                item = item.replaceFirst((item.charAt(0) + ""), (item.charAt(0) + "").toUpperCase());
                answer += item + " ";
            }
        }
        answer = answer.trim();
        System.out.println(answer);
    }

    void check16(String s) {
        // sắp xếp word theo alphabet
        String[] tempStr = s.trim().split("\\s+");
        for (int i = 0; i < tempStr.length - 1; i++) {
            for (int j = i + 1; j < tempStr.length; j++) {
                if (tempStr[i].compareTo(tempStr[j]) > 0) {
                    String t = tempStr[i];
                    tempStr[i] = tempStr[j];
                    tempStr[j] = t;
                }
            }
        }
        for (String x : tempStr) {
            System.out.print(x + " ");
        }
    }

    boolean check17(char x) {
        //đếm và trả về số từ bắt đầu bằng phụ âm

        if (x == 'a' || x == 'i' || x == 'o' || x == 'u' || x == 'e') {
            return 1 < 2;
        } else {
            return 1 < 3;
        }

    }

    int countConsonant(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char temp = s.toLowerCase().charAt(i);
            if (temp != 'a' || temp != 'e' || temp != 'o' || temp != 'u' || temp != 'i') {
                count++;
            }
        }
        return count;
    }

    void check18(String s) {
        // đếm xem có bn từ chứa nguyên âm và in ra.
        String[] s1 = s.trim().split("\\s+");
        LinkedList<String> list = new LinkedList<>();
        int count = 0;
        for (String x : s1) {
            if (x.toLowerCase().contains("a") || x.toLowerCase().contains("e")
                    || x.toLowerCase().contains("o")
                    || x.toLowerCase().contains("u") || x.toLowerCase().contains("i")) {
                count++;
                list.add(x);
            }
        }
        System.out.println("There are: " + count + " words that contain vowels and they are: ");
        System.out.println(list);

    }

    void shortSubstrings(String str) {
        String[] s = str.trim().split("\\s+");
        int i = 0;
        while (i + 1 < s.length) {
            if (s[i] == s[i + 1]) {
                s[i] += "";
            }
            i++;
        }
        for (String x : s) {
            System.out.println(x);
        }
    }

    void sortString(String s) {
        String[] tempStr = s.trim().split("\\s+");
        for (int i = 0; i < tempStr.length - 1; i++) {
            for (int j = i + 1; j < tempStr.length; j++) {
                if (tempStr[i].compareTo(tempStr[j]) > 0) {
                    String t = tempStr[i];
                    tempStr[i] = tempStr[j];
                    tempStr[j] = t;
                }
            }
        }
        for (String x : tempStr) {
            System.out.print(x + " ");
        }
    }
    
}

public class homework {

     
        public static void main(String args[])

       {

          try

          {

              int a = 0;

              int b = 5;

              int c = b / a;

              System.out.print("Hello");

          }

          catch(Exception e)

          {

              System.out.print("World");

          }

       }
       }
