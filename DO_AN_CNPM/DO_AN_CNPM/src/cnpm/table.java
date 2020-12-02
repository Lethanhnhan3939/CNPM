/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnpm;

import static com.sun.org.apache.xalan.internal.lib.ExsltDynamic.map;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 *
 * @author tiennguyen
 */
public class table {
    static int status = 0;
    static Map<String,Integer> dsmon = new HashMap<>();
    
    public void goimon(String tenmon,int soluong)
    {
        dsmon.put(tenmon,soluong);
    }
    public Map<String,Integer> getdsmon()
    {
        return dsmon;
    }
    public int getstatus()
    {
        return status;
    }
    public void setstatus(int i)
    {
        status=i;
    }
    
    public static void main(String [] argv)
    {
        
        dsmon.put("A",1);
        dsmon.put("B",2);
        dsmon.put("C",3);
        // show map
       
        Set<String> set = dsmon.keySet();
        set.stream().forEach((key) -> {
            System.out.println(key + " " + dsmon.get(key));
        });
    }
    
   

    

}
