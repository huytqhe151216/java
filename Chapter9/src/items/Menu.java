package items;

import java.util.Scanner;
import java.util.Vector;

public class Menu extends Vector<String>{

    public Menu() {
        super();
    }
    
    public void addMenu(String s) {
        this.add(s);
    }
    
    public int getUserChoice() {
        for(int i = 0; i < this.size(); i++) {
            System.out.println(i+1 + ". " + this.get(i));
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Select: ");
        int c = sc.nextInt();
        return c;
    }
}
