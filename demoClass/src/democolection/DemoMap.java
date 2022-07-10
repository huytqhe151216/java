/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democolection;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.*;
/**
 *
 * @author ADMIN
 */
class MySort01 implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        
        return 1;
    }
    
}
class DemoMap{
    public static void main(String[] args) {
//        MySort01 my = new MySort01();
//        TreeMap tm = new TreeMap(my);
      TreeMap tm = new TreeMap (new MySort01());
      //  nếu một method mà đc truyền bằng 1 đối tượng mà khởi tạo từ một class mà class này được impliment từ 1 interface or absstract class mà bắt buộc overide 1 methoed duy nhất thì ta cũng không cần biết tên nó là gì (anonymous method)/ lamda ẽpresion
//      TreeMap tm = new TreeMap(()->{});
        tm.put(1,"mot");
        tm.put(2,"hai");
        tm.put(3,"ba");
        System.out.println(tm);
    }
}
/*
Hasmap = hasset +lisst
tremap= treset+list
tremap= hasmap +treset
public class DemoMap {
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        hm.put("one","mot");
        hm.put("two","hai");
        hm.put("three","ba");
        hm.put(4,"bon");
        System.out.println(hm);//neesu key chưa tồn tại nó sẽ add(k,v) vào trong map còn nếu đã tồn tại thì nó sẽ update
        hm.put("three",3);
        System.out.println(hm);
        hm.putIfAbsent(4, "bon bon");//nếu key tồn tại rồi thì do notjhing còn chưa thì thêm
        //hm.remove(key) nếu key không tồn tại trong map thì do nọthing nhưng return null. còn nếu tồn tại trong map thì sẽ xóa bỏ cặp(kv) đồng thowiff method này sẽ trả về value
//        System.out.println(hm.remove(44));
//        System.out.println(hm);
           // hm.remove(4,"bon");
            //nếu cặp (kv) này  tồn tại trong map thì method sẽ xóa cặp giá trj đồng thời trả về true còn ko thì do nothing rồi trả về false
//            System.out.println(hm.remove(4,"bon"));
//            System.out.println(hm);
            //để kiểm tra xem map có tồn tại key hay value nào đó không
//            hm.containsKey(obj) hm.containsValue(obj)
            hm.putAll(hm);//add all trông lits
            
//        Set keys= hm.keySet();
//        System.out.println("c2");
//        for (Object key : keys) {
//            System.out.println("key= "+key+":value "+hm.get(key));
//        }
//        for (Iterator it= keys.iterator())
    }
}
*/