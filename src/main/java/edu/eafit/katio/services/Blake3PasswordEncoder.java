package edu.eafit.katio.services;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;

public class Blake3PasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
            
        try {
            return blake3Formatter(rawPassword.toString());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("[ERROR]: No such algorithm " + e.getMessage());
        }
        return "";
        
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        try {
            if(blake3Formatter(rawPassword.toString()).equals(encodedPassword))
            {
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("[ERROR]: No such algorithm " + e.getMessage());
        }
        return false;
    }

    private String blake3Formatter(String value)  throws NoSuchAlgorithmException
    {
        final MessageDigest md = MessageDigest.getInstance("SHA3-512");
        byte[] hash = md.digest(value.getBytes(StandardCharsets.UTF_8));
        String sha3Hex = bytesToHex(hash);
        return sha3Hex;
    }

    private String bytesToHex(byte[] hash){
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while(hexString.length() < 64){
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

}
