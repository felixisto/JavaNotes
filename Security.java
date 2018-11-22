
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Security
{
    public static void main(String[] args)
    {
    	System.out.println("* * * *\nJAVA Security samples\n* * * *");
        
        final String data = "my secret cookie recipe";
        final String key = "MZygpewJsCpRrfOr";
        
        // Encryption
        System.out.println("\nAES 128bit encryption example with key '" + key + "' by using Cipher:");
        
        try {
            System.out.println("Original data: " + new String(data));
            AESEncryption advancedEncryptionStandard = new AESEncryption(key);
            byte[] cipherText = advancedEncryptionStandard.encrypt(data);
            System.out.println("Encrypted data: " + cipherText);
            byte[] decryptedCipherText = advancedEncryptionStandard.decrypt(cipherText);
            System.out.println("Decrypted data: " + new String(decryptedCipherText));
        }
        catch (Exception e)
        {
            System.out.println("Failed to encrypt or decrypt: " + e.toString());
        }
        
        String salt = "my salt";
        
        System.out.println("\nSha256 one-way compression example with key '" + key + "' and salt '" + salt + "' by using MessageDigest:");
        
        try {
            System.out.println("Original data: " + new String(data));
            System.out.println("Compressed data: " + new SHA256Hashing(data, "my salt").value);
        }
        catch (Exception e)
        {
            System.out.println("Failed to compress with sha256: " + e.toString());
        }
    }
}

class AESEncryption
{
    private byte[] _key;
    
    private static final String ALGORITHM = "AES";
    
    public AESEncryption(String key)
    {
        _key = key.getBytes(StandardCharsets.UTF_8);
    }
    
    /**
     * Encrypts the given plain text
     *
     * @param plainText The plain text to encrypt
     */
    public byte[] encrypt(String text) throws Exception
    {
        byte[] data = text.getBytes(StandardCharsets.UTF_8);
        
        SecretKeySpec secretKey = new SecretKeySpec(_key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        return cipher.doFinal(data);
    }
    
    /**
     * Decrypts the given byte array
     *
     * @param cipherText The data to decrypt
     */
    public byte[] decrypt(byte[] cipherText) throws Exception
    {
        byte[] cipherData = cipherText;
        
        SecretKeySpec secretKey = new SecretKeySpec(_key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        
        return cipher.doFinal(cipherData);
    }
}

class SHA256Hashing
{
    public final byte[] value;
    
    public SHA256Hashing(String data, String salt) throws Exception
    {
        value = MessageDigest.getInstance("SHA-256").digest((data + salt).getBytes("UTF-8"));
    }
    
    public String toString()
    {
        return new String(value);
    }
}
