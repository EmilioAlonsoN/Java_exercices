package com.pluralsight.userregistrationprogram;
/*
import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class FileEncryption {
    public void encryptDecrypt(String key, int cipherMode, File input, File output) throws InvalidKeyException,
            NoSuchAlgorithmException,
            InvalidKeySpecException, IOException, NoSuchPaddingException {
        FileInputStream fileInputStream = new FileInputStream(input);
        FileOutputStream fileOutputStream = new FileOutputStream(output);

        DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(key.getBytes());

        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = secretKeyFactory.generateSecret(deSedeKeySpec);

        Cipher cipher = Cipher.getInstance("DES/GCM/PKCS5Pagging");

        if (cipherMode == cipher.ENCRYPT_MODE) {
            cipher.init(cipher.ENCRYPT_MODE, secretKey, SecureRandom.getInstance("SHA1PRNG"));
            CipherInputStream cipherInputStream = new CipherInputStream(fileInputStream, cipher);
            writeToTheFile(cipherInputStream, fileOutputStream);
        }
        else if (cipherMode == cipher.DECRYPT_MODE){
            cipher.init(Cipher.DECRYPT_MODE, secretKey, SecureRandom.getInstance("SHA1PRNG"));
            CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);
            writeToTheFile(fileInputStream, cipherOutputStream);
        }
    }
    private static void writeToTheFile(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[256];
        int numOfBytesRead;
        while ((numOfBytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, numOfBytesRead);
        }
        output.close();
        input.close();
    }
}

 */
