package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ShiftCryptMethod implements CryptionMethod {
    int[] values;
    char[] resultText;

    @Override
    public String EncryptText(String text, int key) {
        setValues(text);

        cryptAlgo(key, true);

        return new String(resultText);
    }

    @Override
    public void EncryptText(String text, int key, String outputTextFile) throws IOException {
        File file = new File(outputTextFile);
        FileWriter writer = new FileWriter(file);

        setValues(text);

        cryptAlgo(key, true);

        writer.write(new String(resultText));
        writer.close();
    }

    @Override
    public String DecryptText(String text, int key) {
        setValues(text);

        cryptAlgo(key, false);

        return new String(resultText);
    }

    @Override
    public void DecryptText(String text, int key, String outputTextFile) throws IOException {
        File file = new File(outputTextFile);
        FileWriter writer = new FileWriter(file);

        setValues(text);

        cryptAlgo(key, false);

        writer.write(new String(resultText));
        writer.close();
    }

    private void cryptAlgo(int key, boolean encrypt) {
        resultText = new char[values.length];
        int i = 0;

        for (int value : values
        ) {
            if (encrypt) {
                if ((value >= 97 && value <= 122 - key) || (value >= 65 && value <= 90 - key)) {
                    resultText[i++] = (char) (value + key);
                } else if ((value > 122 - key && value <= 122) || (value > 90 - key && value <= 90)) {
                    resultText[i++] = (char) (value - 26 + key);
                } else {
                    resultText[i++] = (char) value;
                }
            } else {
                if ((value >= 97 + key && value <= 122) || (value >= 65 + key && value <= 90)) {
                    resultText[i++] = (char) (value - key);
                } else if((value < 97 + key &&  value >= 97) || (value < 65 + key && value >= 65)){
                    resultText[i++] = (char) (value + 26 - key);
                }
                else {
                    resultText[i++] = (char) value;
                }
            }
        }

    }

    private void setValues(String text) {
        values = new int[text.length()];

        int i = 0;

        for (char c : text.toCharArray()
        ) {
            values[i++] = c;
        }
    }
}
