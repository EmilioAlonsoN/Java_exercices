package com.entertainment.test;

import com.entertainment.Television;

public class TelevisionTestMuting {

    public static void main(String[] args) {
        Television tv = new Television("LG", 50);
        System.out.println(tv.toString());

        tv.muting();
        System.out.println(tv.toString());

        tv.muting();
        System.out.println(tv.toString());

        tv.muting();
        System.out.println(tv.toString());

        tv.setVolume(100);
        System.out.println(tv.toString());
    }
}
