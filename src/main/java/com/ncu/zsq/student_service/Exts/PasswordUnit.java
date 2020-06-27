package com.ncu.zsq.student_service.Exts;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class PasswordUnit {
    public String hash(String password){
        StringBuilder result= new StringBuilder();
        if(password==null){
            return null;
        }
        MessageDigest hash=null;
        try{
            hash=MessageDigest.getInstance("SHA1");
            byte[] bytes=hash.digest(password.getBytes());
            for(byte b:bytes){
                    String temp=Integer.toString(b&0xff);
                    if (temp.length()==1)
                        temp="0"+temp;
                    result.append(temp);
            }


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
