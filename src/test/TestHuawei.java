package test;

import java.util.*;

public class TestHuawei {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = new ArrayList<>();
        while(scanner.hasNext()){
            items.add(scanner.next());
            Optional<String> first = items.stream().findFirst();
            Integer integer = Integer.valueOf(first.get());
            if(items.size() -1 ==integer){//当list中size -1 等于磁盘数时开始处理
                Map<Integer, String> map = unitTransfer(items);
                TreeSet<Integer> set = new TreeSet<>();
                set.addAll(map.keySet());
                for (Integer it:set) {
                    System.out.println(map.get(it));
                }
            }
        }
    }
    public static Map<Integer,String> unitTransfer(List<String> items){
        //map的key存入单位转换为M的数值，value存入带单位的
        Map<Integer, String> map = new HashMap<>();
        for (String item:items) {
            //list中包含了第一项（处理器个数），这里不予处理
            String substring = null;
            if (item.indexOf("T")>0){
                substring = item.substring(0, item.length() - 1);
                map.put(Integer.valueOf(substring)*1000000,item);
            }else if (item.indexOf("G")>0){
                substring = item.substring(0, item.length() - 1);
                map.put(Integer.valueOf(substring)*1000,item);
            }else if (item.indexOf("M")>0){
                substring = item.substring(0, item.length() - 1);
                map.put(Integer.valueOf(substring),item);
            }
        }
        return map;
    }
}