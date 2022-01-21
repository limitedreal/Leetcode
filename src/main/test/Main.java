package main.test;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String,Object> map =new HashMap<>();
    public static void main(String[] args) {
        map.put("int",new Integer(1));
        map.put("Long",2L);
        //int i = map.get("int");

    }
    public <T> T getWithT(String key){
        return (T)map.get(key);
    }
    public <T> T getWithoutT(String key){
        return (T) map.get(key);
    }
}
