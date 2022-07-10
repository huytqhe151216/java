
/*
 Assignment 1 - Income Tax
 Class ID       : SE1607
 Student ID     : HE151216
 Student Name   : To Quang Huy
 Due Date       : 30 October 2021
 I declare that this assignment is my own work
 in accordance with FPT Policy.
 */
package incometax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class contains methods to execute mission of main method: calculate  tax,display, add, sort, delete, search...
 *
 * @author thang
 */
public class CalculateTax {

    Node head, tail;
    Validate v = new Validate();
    Scanner sc = new Scanner(System.in);

    public CalculateTax() {
        head = tail = null;
    }

    /**
     * Check list is empty or not
     *
     */
    boolean isEmpty() {
        return (head == null);
    }

    /**
     * Display link list details
     *
     */
    void display() {
        Node cur = head;
        System.out.format("%-10s|%-25s|%-15s|%-15s|%-15s", "Code", "Name", "Income", "Deduct", "Tax");
        while (cur != null) {
            System.out.println("");
            System.out.format("%-10s|%-25s|%-15.1f|%-15.1f|%-15.1f", cur.info.code, cur.info.name, cur.info.income, cur.info.deduct, cur.info.tax);
            cur = cur.next;
        }
        System.out.println("");
    }

    /**
     * Add to the end of list or file.
     *
     */
    public void addLast() {
        System.out.print("Code: ");
        String xCode = sc.nextLine().trim();
        System.out.print("Name: ");
        String xName = sc.nextLine().trim();
        System.out.print("Income: ");
        double xIncome = v.getValidDoub();
        System.out.print("Deduct: ");
        double xDeduct = 0;
        while (true) {
            xDeduct = v.getValidDoub();
            if (xDeduct < xIncome) {
                break;
            }
        }
        double xTax = 0;
        if (xIncome <= 5000) {
            xTax = (xIncome - xDeduct) * 5 / 100;
        } else if (xIncome > 5000 && xIncome <= 10000) {
            xTax = (xIncome - xDeduct) * 10 / 100;
        } else {
            xTax = (xIncome - xDeduct) * 15 / 100;
        }
        TaxPayer x = new TaxPayer(xCode, xName, xIncome, xDeduct, xTax);
        Node node = new Node(x);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    /**
     * Add to beginning of the list.
     *
     */
    public void AddFirst() {
        System.out.print("Code: ");
        String xCode = sc.nextLine().trim();
        System.out.print("Name: ");
        String xName = sc.nextLine().trim();
        System.out.print("Income: ");
        double xIncome = v.getValidDoub();
        System.out.print("Deduct: ");
        double xDeduct = 0;
        while (true) {
            xDeduct = v.getValidDoub();
            if (xDeduct < xIncome) {
                break;
            }
        }
        double xTax = 0;
        if (xIncome <= 5000) {
            xTax = (xIncome - xDeduct) * 5 / 100;
        } else if (xIncome > 5000 && xIncome <= 10000) {
            xTax = (xIncome - xDeduct) * 10 / 100;
        } else {
            xTax = (xIncome - xDeduct) * 15 / 100;
        }
        TaxPayer x = new TaxPayer(xCode, xName, xIncome, xDeduct, xTax);
        Node node = new Node(x);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    /**
     * Add data from file to list
     *
     */
    public void getInputFromFile() {
        try {
            File myFile = new File("input.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] newData = data.trim().split("\\,+");
                TaxPayer x = new TaxPayer(newData[0], newData[1], Double.parseDouble(newData[2]), 
                        Double.parseDouble(newData[3]), Double.parseDouble(newData[4]));
                Node node = new Node(x);
                if (isEmpty()) {
                    head = tail = node;
                } else {
                    tail.next = node;
                    tail = node;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error!");
        }

    }

    /**
     * Write data from list to file
     *
     */
    public void writeToFile() {
        try {
            try (FileWriter myWriterFile = new FileWriter("input.txt")) {

                Node cur = head;
                while (cur != null) {
                    myWriterFile.write(String.format("%-10s,%-25s,%-15.1f,%-15.1f,%-15.1f", cur.info.code, cur.info.name, cur.info.income, cur.info.deduct, cur.info.tax) + "\n");
                    cur = cur.next;
                }
            }
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

    /**
     * Delete the first node
     *
     */
    void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    /**
     * Delete the last node
     *
     */
    void deleteLast() {
        if (isEmpty()) {
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            Node cur = head;
            while (cur.next != tail) {
                cur = cur.next;
            }
            tail = tail.next;
            cur.next = null;
            tail = cur;
        }
    }

    /**
     * Delete  index
     * 
     * @param index is the position to delete
     *
     */
    void deleteIndex(int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            deleteFirst();
        } else {
            Node cur = head;
            int pos = 0;
            while (cur.next != null) {
                if (index - 1 == pos) {
                    break;
                }
                cur = cur.next;
                pos++;
            }
            if (cur.next == tail) {
                deleteLast();
            } else {
                cur.next = cur.next.next;
            }
        }
    }
    
    /**
     * Delete node by Taxpayer's code
     *
     */
    public void deleteByCode() {
        String xCode = sc.nextLine().trim();
        int index = 0;
        Node cur = head;
        while (cur != null) {
            if (cur.info.code.trim().equalsIgnoreCase(xCode)) {
                deleteIndex(index);
                break;
            }
            cur = cur.next;
            index++;
        }
    }
    
    /**
     * Search node by Taxpayer's code and display data
     *
     */
    public void searchByCode() {
        String xCode = sc.nextLine().trim();
        Node cur = head;
        while (cur != null) {
            if (cur.info.code.trim().equalsIgnoreCase(xCode)) {
                break;
            }
            cur = cur.next;
        }
        System.out.format("%-10s|%-25s|%-15s|%-15s|%-15s", "Code", "Name", "Income", "Deduct", "Tax");
        System.out.println("");
        System.out.format("%-10s|%-25s|%-15.1f|%-15.1f|%-15.1f", cur.info.code, cur.info.name, cur.info.income, cur.info.deduct, cur.info.tax);
        System.out.println("");
    }
    
    /**
     * Sort ascending node by Taxpayer's code
     *
     */
    public void sortByCode() {
        Node pi, pj;
        TaxPayer x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info.code.trim().compareTo(pi.info.code.trim()) < 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    /**
     * This method use to get index from user and delete node at this index 
     *
     */
    public void deletePosition() {
        System.out.print("Enter index: ");
        int k = v.getValidInt();
        deleteIndex(k);
    }
    
    /**
     * This method use to get index from user and insert new node at the next index 
     *
     */
    public void insertPositionNext() {
        System.out.print("Enter index: ");
        int position = v.getValidInt();
        if (position < 0) {
            return;
        } else {
            Node cur = head;
            int pos = 0;
            while (cur != null) {
                if (position == pos) {
                    break;
                }
                cur = cur.next;
                pos++;
            }
            if (cur == null) {
                return;
            }
            if (cur.next == null) {
                addLast();
            } else {
                System.out.print("Code: ");
                String xCode = sc.nextLine().trim();
                System.out.print("Name: ");
                String xName = sc.nextLine().trim();
                System.out.print("Income: ");
                double xIncome = v.getValidDoub();
                System.out.print("Deduct: ");
                double xDeduct = 0;
                while (true) {
                    xDeduct = v.getValidDoub();
                    if (xDeduct < xIncome) {
                        break;
                    }
                }
                double xTax = 0;
                if (xIncome <= 5000) {
                    xTax = (xIncome - xDeduct) * 5 / 100;
                } else if (xIncome > 5000 && xIncome <= 10000) {
                    xTax = (xIncome - xDeduct) * 10 / 100;
                } else {
                    xTax = (xIncome - xDeduct) * 15 / 100;
                }
                TaxPayer x = new TaxPayer(xCode, xName, xIncome, xDeduct, xTax);
                Node node = new Node(x);
                node.next = cur.next;
                cur.next = node;
            }
        }
    }
}

