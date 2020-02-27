package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyBloomFilter {

    MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] hashResult;

    public MyBloomFilter() throws NoSuchAlgorithmException {
        //shut up
    }

    void add(String val, boolean[] bitmap) {
        hashResult = md.digest(val.getBytes());
        bitmap[hashResult[0] + 128] = true;
        bitmap[hashResult[3] + 128] = true;
        bitmap[hashResult[5] + 128] = true;
    }

    boolean contains(String val, boolean[] bitmap) {
        hashResult = md.digest(val.getBytes());

        return bitmap[hashResult[0] + 128] && bitmap[hashResult[3] + 128] && bitmap[hashResult[5] + 128];
    }
}
