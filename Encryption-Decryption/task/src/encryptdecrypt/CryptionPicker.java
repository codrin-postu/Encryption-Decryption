package encryptdecrypt;

import java.io.IOException;

public class CryptionPicker {
    private CryptionMethod method;

    public boolean setMethod(String cryptAlg) {
        switch (cryptAlg) {
            case "shift":
                this.method = new ShiftCryptMethod();
                return true;
            case "unicode":
                this.method = new UnicodeCryptMethod();
                return true;
            default:
                System.out.println("Error: Incorrect method - " + cryptAlg);
                return false;
        }
    }

    public void encrypt(String text, int key, String outputTextFile) throws IOException {
        if (outputTextFile.equals(""))
            this.method.EncryptText(text, key);
        else
            this.method.EncryptText(text, key, outputTextFile);
    }

    public void decrypt(String text, int key, String outputTextFile) throws IOException {
        if (outputTextFile.equals(""))
            this.method.DecryptText(text, key);
        else
            this.method.DecryptText(text, key, outputTextFile);
    }
}
