package com.pluralsight.userregistrationprogram;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class EncryptionTools {
    // This is a Crypto class use for of all the task required to deal with encryption and decryption.

    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        // Secret key generator.

        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(256); //generate 256 bit key
        SecretKey secretKey = generator.generateKey();
        secretKey.getFormat();

        return secretKey;
    }

    public static void encryptMode(SecretKey secretKey, int cipherMode, File input, File output)
                                                                            throws  InvalidKeyException,
                                                                                    NoSuchAlgorithmException,
                                                                                    InvalidKeySpecException,
                                                                                    IOException,
                                                                                    NoSuchPaddingException,
                                                                                    InvalidAlgorithmParameterException {
            // Encryption using Cipher method.

        FileInputStream fileInputStream = new FileInputStream(input);
        FileOutputStream fileOutputStream = new FileOutputStream(output);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

        byte[] ivBytes = new byte[16];
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec, SecureRandom.getInstance("SHA1PRNG"));
        CipherInputStream cipherInputStream = new CipherInputStream(fileInputStream, cipher);
        writeTheFileEncryption(cipherInputStream, fileOutputStream);
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        FileWriter myWriter = new FileWriter("key.pub");
        BufferedWriter bw = new BufferedWriter(myWriter);
        bw.write(encodedKey);
        bw.close();
        myWriter.close();
    }

    public static void decryptMode (SecretKey secretKey, int cipherMode, File input, File output)
                                                                                    throws  InvalidKeyException,
                                                                                    NoSuchAlgorithmException,
                                                                                    InvalidKeySpecException,
                                                                                    IOException,
                                                                                    NoSuchPaddingException,
                                                                                    InvalidAlgorithmParameterException {

        // Decryption using Cipher method.

        FileInputStream fileInputStream = new FileInputStream(input);
        FileOutputStream fileOutputStream = new FileOutputStream(output);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

        byte[] ivBytes = new byte[16];
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
        FileReader keyFile = new FileReader("key.pub");
        BufferedReader bufferedReader = new BufferedReader(keyFile);
        byte[] decodedKey = Base64.getDecoder().decode(String.valueOf(bufferedReader.readLine()));
        SecretKey Key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        cipher.init(Cipher.DECRYPT_MODE, Key, ivParameterSpec, SecureRandom.getInstance("SHA1PRNG"));
        CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);
        writeTheFileEncryption(fileInputStream, cipherOutputStream);
        bufferedReader.close();

    }

    private static void writeTheFileEncryption(InputStream input, OutputStream output) throws IOException {
        // Write the file with the chosen encryption algorithm.

        byte[] buffer = new byte[64];
        int numOfBytesRead;
        while ((numOfBytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, numOfBytesRead);
        }
        output.close();
        input.close();
    }
}

