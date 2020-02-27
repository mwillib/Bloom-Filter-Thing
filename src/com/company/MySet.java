package com.company;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MySet {

    boolean[] bitmap = new boolean[256];
    List<String> contents = new ArrayList<>();
    private MyBloomFilter bloomFilter = new MyBloomFilter();

    public MySet() throws NoSuchAlgorithmException {
        //shut up
    }

    public void add(String val) {
        contents.add(val);
        bloomFilter.add(val, bitmap);
    }

    public boolean contains(String val) {
        return bloomFilter.contains(val, bitmap);
    }

}
