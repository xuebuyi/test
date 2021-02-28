import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author xuebuyi
 * @date 2021-02-04 16:56
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("张三",20);
        map.put("李四",30);
        map.put("王五",40);

        for (Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s);
            System.out.println(map.get(s));
        }
    }
}
