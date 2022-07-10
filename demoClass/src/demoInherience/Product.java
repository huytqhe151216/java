/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoInherience;

/**
 *
 * @author ADMIN
 */
public class Product {

    String code;
    String name;
    double price;
    String made;

    public Product() {
    }

    public Product(String code, String name, double price, String made) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.made = made;
    }

    @Override
    public String toString() {
        return "`code=" + code + ", name=" + name
                + ", price=" + price + ", made=" + made;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    
     

}
class Electric extends Product {
        double power;

        public Electric() {
            super();
        }

        public Electric(String code, String name, double price, String made,double power) {
            super(code, name, price, made);
            this.power = power;
        }

        @Override
        public String toString() {
            return super.toString()+", power"+power; //To change body of generated methods, choose Tools | Templates.
        }
    
        
        
    }
class UsingInheritance{
    public static void main(String[] args) {
        Product p = new Product("TV","SOny",25000,"Japan");
        System.out.println("tHONG TIN CUA PRODCT"+p);
        Electric e = new Electric ("tv","sony",2400,"japan",200);
        System.out.println("thong tin sp "+ e);
}
}



