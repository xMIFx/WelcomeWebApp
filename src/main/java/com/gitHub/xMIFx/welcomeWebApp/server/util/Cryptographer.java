package com.gitHub.xMIFx.welcomeWebApp.server.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 * Created by bukatinvv on 16.09.2015.
 */
public class Cryptographer {
    private static final String NAME_CRYPT = "PBKDF2WithHmacSHA512";

    public static String getCryptString(String string) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeySpecException {
        String saltString = new StringBuffer(string).reverse().toString();
        byte[] salt = saltString.getBytes("UTF-8");
        KeySpec spec = new PBEKeySpec(string.toCharArray(), salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance(NAME_CRYPT);
        byte[] hash = f.generateSecret(spec).getEncoded();
        Base64.Encoder enc = Base64.getEncoder();
        return  enc.encodeToString(hash);
    }
}
