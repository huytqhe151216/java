/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoInterfacee;

/**
 *
 * @author ADMIN
 */
public interface NewInterfaceA {

    public static final int x = 10;
    // chỉ chứa hằng số
    // no khong co instance variable, 
    // khi khai báo một field thì bawsrt buộc phải khai báo là public , static,, final  trước field đó
    //nếu không khai báo hoặc khai báo thiếu thì hệ thống sẽ tự động bổ sung . Không được khai báo các từ khóa tương tự khác
    int y = 20;
    // interface chỉ chứa các abstract method ( mrthod không có body)
    // đối với abstract method thì bắt buộc phải khai báo 2 từ khóa là public và abstract. nếu không khai báo hoặc khai báo thiếu thì hệ thống tự động bổ sung .
    // đối với java8 trở lên thì interface cung cấp 2 loại methodd mà có body đó là static method và default ( bắt buộc phải có từ khóa default)
    // điều này không hỗ trợ với java thấp hơn java8 (jdk 1.8)

    void m1();

    public abstract void m2();// khong co body
    static void m3(){};// body = trống
    default void m4(){};// body = trống
}
interface demob extends NewInterfaceA{
    
}
class C{}
class D extends C implements 
// java là ngôn ngữ đơn kế thừ , một class có thể extends từ 1 class khác nhưng có thể được impliment tiwf nhiều interface, các interfaxe thì dudwojdc phân cách nhau bởi dấu phẩy.
// một class nếu có sẽ extends từ một class khác trước sau đó impliment một  howjc nhiều interface sau.
// khi một class implement một hoặc nhiều interface thì bắt buộc nó phải override tất cả cấc abstract mehtod. con các method như static hay default thì có thể tùy chọn
