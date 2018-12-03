package mq.teststart.com.test;

import java.util.ArrayList;


public class AlistUtils {

    public static  ArrayList<String> strings = new ArrayList<>();
    public static ArrayList<String> getList() {
//        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.forEach(o->{
            System.out.println("start = " + o);
        });
        return strings;
    }
}
