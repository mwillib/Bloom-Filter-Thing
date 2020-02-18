package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyBloomFilter {

    MessageDigest md = MessageDigest.getInstance("MD5");
    boolean[] bitmap = new boolean[256];
    byte[] hashResult;

    public MyBloomFilter() throws NoSuchAlgorithmException {
    }

    void add(String val) {
        hashResult = md.digest(val.getBytes());
        bitmap[hashResult[0] + 128] = true;
        bitmap[hashResult[3] + 128] = true;
        bitmap[hashResult[5] + 128] = true;
    }

    boolean contains(String val) {
        hashResult = md.digest(val.getBytes());

        if (bitmap[hashResult[0] + 128] && bitmap[hashResult[3] + 128] && bitmap[hashResult[5] + 128]) {
            return true;
        }
        return false;
    }
}
