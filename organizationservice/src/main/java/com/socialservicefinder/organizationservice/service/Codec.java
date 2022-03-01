package com.socialservicefinder.organizationservice.service;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.util.Base64;

// Referred from: https://stackoverflow.com/a/10316509
public class Codec {
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private Cipher cipher;
    byte[] arrayBytes;
    SecretKey key;

    public Codec() throws Exception {
        String myEncryptionKey = "SocialServiceFinderUCICS";
        String myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        KeySpec keySpec = new DESedeKeySpec(arrayBytes);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = secretKeyFactory.generateSecret(keySpec);
    }

    public String encrypt(String plaintext) {
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = plaintext.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.getEncoder().encode(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }

    public String decrypt(String ciphertext) {
        String decryptedText=null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.getDecoder().decode(ciphertext);
            decryptedText = new String(cipher.doFinal(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }
}
