/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demowrapperclass;

/**
 *
 * @author ADMIN
 */
public class demowrapperclass {
    public static void main(String[] args) {
        Integer a= new Integer(123);
        Integer b= new Integer("123");
        System.out.println("max value of Int :"+a.MAX_VALUE);
        System.out.println("max value of Int :"+a.MIN_VALUE);
        System.out.println("byte of it :"+a.BYTES);
        System.out.println("size of interger:"+a.SIZE);
        System.out.println("size of interger:"+a.TYPE);
        System.out.println("a.bytevalue:"+a.byteValue());
       // ...Value() : chuyển giá trị đang xét về kiểu ... tương ứng
       // chúng ta chỉ lưu ý các kiểu nhỏ hơn mà ta đang xét , còn các kiểu lớn hơn hoặc bằng kiểu đang xét thì ta chuyển ngang giá trị(giá trị không thể thay đổi)
       //nguyên tắc thay đổi :
//       VD đối với kiểu byte và kiểu short
//               byte(s=8)
//               short (s=16)
//            cách 1 : chuyển số cần thay đổi về sô nhị phân 
//                    lấy (s-bit cuối cùng) , rồi sau đó convert cái s-bit cuối cùng này sang cơ số 10 có dấu 
//            cách 2 : lấy số cần đổi chia cho 2^s =r
//                    nếu r>2^(s-1)-1 --> r=r-s^s
//                        r<-2^(s-1)-->r=r+s^s
//                        luôn luôn trong khoảng
    }
    
}
