package com.pluralsight.userregistrationprogram;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class FileEncryption {

    public static SecretKey generateKey() throws NoSuchAlgorithmException, IOException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(256); //generate 256 bit key
        SecretKey secretKey = generator.generateKey();
        secretKey.getFormat();
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        FileWriter myWriter = new FileWriter("key.pub", true);
        BufferedWriter bw = new BufferedWriter(myWriter);
        System.out.println(encodedKey);
        bw.write(encodedKey);
        bw.append("\n");
        bw.close();

        return secretKey;
    }

    public static void encryptDecryptFile(SecretKey secretKey, int cipherMode, File input, File output)
                                                                        throws  InvalidKeyException,
                                                                                NoSuchAlgorithmException,
                                                                                InvalidKeySpecException,
                                                                                IOException,
                                                                                NoSuchPaddingException,
                                                                                InvalidAlgorithmParameterException {

        FileInputStream fileInputStream = new FileInputStream(input);
        FileOutputStream fileOutputStream = new FileOutputStream(output);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

        byte[] ivBytes = new byte[16];
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

        if (cipherMode == Cipher.ENCRYPT_MODE) {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec, SecureRandom.getInstance("SHA1PRNG"));
            CipherInputStream cipherInputStream = new CipherInputStream(fileInputStream, cipher);
            writeToTheFile(cipherInputStream, fileOutputStream);
            System.out.println(secretKey);

        }
        else if (cipherMode == Cipher.DECRYPT_MODE){
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec, SecureRandom.getInstance("SHA1PRNG"));
            CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);
            writeToTheFile(fileInputStream, cipherOutputStream);
        }
    }

    private static void writeToTheFile(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[64];
        int numOfBytesRead;
        while ((numOfBytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, numOfBytesRead);
        }
        output.close();
        input.close();
    }

    /*
    public void makeKey() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(256); //generate 128 bit key
        SecretKey secretKey = generator.generateKey();
        byte[] key = secretKey.getEncoded();
    }

    public void saveKey(File encryptFile, File publicKeyData) {
    }

    public void loadKey(File encryptFile, File privateKeyFile) {
    }

    public void encrypt(File originalFile, File secureFile) {
    }

    public void decrypt(File secureFile, File unencryptedFile) {
    }

     */

}

