package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UnicodeCryptMethod implements CryptionMethod {
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
            if (encrypt)
                resultText[i++] = (char) (value + key);
            else
                resultText[i++] = (char) (value - key);
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
