package com.committee.politics.committee_check.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5{

    public static String encode(String str) throws NoSuchAlgorithmException{
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update((str).getBytes(StandardCharsets.UTF_8));
        byte[] b = md5.digest();

        int i;
        StringBuffer buf = new StringBuffer("");

        for (byte value : b) {
            i = value;
            if (i < 0) {
                i += 256;
            }
            if (i < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));
        }
        return buf.toString();
    }

}
