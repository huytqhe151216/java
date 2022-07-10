/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Box extends Retangle {
    private int  height =0;

    public Box() {
        super();
        
    }
    public Box(int l, int w , int h){
        super(l,w);
        height =h>0? h:0;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String toString() {
        return "["+ getLength() +","+getWidth()","+getHeight()+"]"; //To change body of generated methods, choose Tools | Templates.
    }
    public int area (){
        int l =this.getLength();
        int w =this.getWidth();
        int h =this.getHeight();
        return 2*(l*w+w*h+h*l);
    }
    public int Voloum(){
        return this.getLength()*height  *this.getWidth();
    }
    
    
    
    
}
