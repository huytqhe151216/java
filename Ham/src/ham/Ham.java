/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ham;

/**
 *
 * @author ADMIN
 */
public class Ham {

    /**
     * @param args the command line arguments
     */
    public static int sum(int a, int b) {
        return a + b;//ham tinh tong 2 so
    }

    public static int check1(int a) {
        if (a <= 1)// check snt
        {
            return 0;
        }
        if (a == 2 || a == 3) {
            return 1;
        }
        int i = 2;
        for (i = 2; i < Math.sqrt(a); i++) {
            if (a % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int check2(int a) {
        // check so khong am
        if (a >= 0) {
            return 1;
        } else {
            return 0;
        }
    

    

}
    public static int check3(int a) {
        // check so chinh phuong
        if ((Math.sqrt(a)*Math.sqrt(a)) == a) {
            return 1;
        } else {
            return 0;
        }

    }
    public static int check4(int a){
        // check so chan
        if (a%2==0)
            return 1;
        else
            return 0;
    }
    public static int check5(int a){
        //check  so le
        if (a%2==1)
            return 0;
        else
            return 1;
    }
    int check6(int a, int b){// check nguyen to cung nhau
        for(int i=2;i<=a;i++){
            if(a%i==0 && b%i==0)
                return 0;

        }
    return 1;
    }
    public static int check7(int a, int b ){
        int ucln=1;
        for(int i=1;i<=a;i++){
            if (a%i==0 && b%i==0)
              ucln=i;
        
    }
    return ucln;
}
    public static int check8 (int a){
//check xem so a co bn cs;
int d=0;
        while(a>10){
            a=a/10;
               d=d+1;
}
        return d+1;
    }
    public static   int check9 (int a){
        // check xem a co chia het ccho 3 khong
        if (a%3==0) 
                return 1;
else return 0;
}
    public static int checck10( int a){
    // check xem so a co  chi la boi cua 5 khong
    while(a%5==0){
        a=a/5;
}
if (a==1)
    return 1;
else 
    return 0;
}
public static int check11 (int a, int b){
    //tinh tich cua 2 so a va b
    return a*b;
}
public static int checck12 (int a, int b){
    // kiem tra xem so a co chia het cho so b khong
    if(a%b==0)
        return 1;
    else
        return 0;
}
public static int check13 (int d , int d1, int d2){
    if (d1+d2==d) // check vi tri tuong doi 2 duong tron;
        return 0;
    if (d1+d2>d)
        return 1;
    return 2;
    
}
public static int check15(int a){
    int i=1;        // tinh a giai thua;
    int s=1;
    for(i=1;i<=a;i++)
        s=s*i;
    return s;
}
public static int  check16(int a){
    return a*a;// tinh a binh phuong;
}
public static double check17(int a){
    return a*a*3.14;// tinh dien ticch hinh tron
}
public static double checck18(int a){
    return 2*a*3.14;//tinh chu vi hinh tron
}
public static int check19 ( int a , int b){
    if( a>=b)//kiem tra xem so nao lon hon
        return a;
    else
        return b;
}
public static int check20(int a){
    return a*a*a;//tinh a mu 3
}
}
