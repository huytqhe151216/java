package employees;

import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class EmpList extends Vector<Employee> {

    Scanner sc = new Scanner(System.in);

    public EmpList() {
        super();
    }

    public void AddFromFile(String fName) {

        try {
            File f = new File(fName);
            if(!f.exists()) {
                return;
            }

            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;

            while((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String code = stk.nextToken().toUpperCase();
                String name = stk.nextToken().toUpperCase();
                int salary = Integer.parseInt(stk.nextToken());

                Employee emp = new Employee(code, name, salary);
                this.add(emp);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void addNewEmp() {
        String newCode;
        String newName;
        int salary;
        int pos;
        boolean valid = true;
        System.out.println("Enter New Employee Details:");
        do {
            System.out.print("   code E000:");
            newCode = sc.nextLine().toUpperCase();
            pos = find(newCode);
            valid = newCode.matches("^E\\d{3}$");
            if(pos >= 0) {
                System.out.println("The code is duplicate");
            }
            if(!valid) {
                System.out.println("The code: E and 3 digits");
            }
        } while(pos >= 0 || (!valid));

        System.out.print("   name:");
        newName = sc.nextLine().toUpperCase();
        System.out.print("  salary:");
        salary = Integer.parseInt(sc.nextLine());
        new Employee(newCode, newName, salary).print();
        this.add(new Employee(newCode, newName, salary));
        for(Employee e : this) {
            e.print();
        }
        System.out.println("New Employee has been added.");
    }

    private int find(String aCode) {
        for(int i = 0; i < this.size(); i++) {
            if(aCode.equals(this.get(i).getCode())) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        if(this.isEmpty()) {
            System.out.println("Empty list.");
            return;
        }
        Collections.sort(this);
        System.out.println("\nEMPLOYEE LIST");
        System.out.println("-------------------");
        for(Employee e : this) {
            e.print();
        }
        System.out.println("-------------------");
    }

    public void promote() {
        String code;
        System.out.print("Enter the code of promoted employee:");
        code = sc.nextLine().toUpperCase();
        int pos = find(code);
        if(pos < 0) {
            System.out.println("This code does not exits");
        } else {
            int oldSalary = this.get(pos).getSalary();
            int newSalary;
            do {
                System.out.print("Old salary: " + oldSalary + ", new salary: ");
                newSalary = Integer.parseInt(sc.nextLine());
            } while(newSalary < oldSalary);
            this.get(pos).setSalary(newSalary);
            System.out.println("The employeee " + code + " has been updated");
        }
    }

    public void removeEmp() {
        String code;
        System.out.print("Enter the code of removed employee: ");
        code = sc.nextLine().toUpperCase();
        int pos = find(code);
        if(pos < 0) {
            System.out.println("This code does not exit.");
        } else {
            this.remove(pos);
            System.out.println("The employee " + code + " has been removed.");
        }
    }

    public void saveToFile(String fName) {
        if(this.isEmpty()) {
            System.out.println("Empty list");
            return;
        }

        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(Employee x : this) {
                pw.println(x.getCode() + "," + x.getName() + "," + x.getSalary());
            }
            pw.close();
            fw.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
}
