package encryptdecrypt;

import java.io.IOException;

public interface CryptionMethod {
    void EncryptText(String text, int key, String outputTextFile) throws IOException;
    String EncryptText(String text, int key);

    void DecryptText(String text, int key, String outputTextFile) throws IOException;
    String DecryptText(String text, int key);
}
