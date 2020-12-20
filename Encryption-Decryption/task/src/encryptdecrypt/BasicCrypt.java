package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BasicCrypt {
    static int[] values;
    static char[] resultText;

    public static String EncryptText(String text, int key) {
        values = new int[text.length()];
        resultText = new char[values.length];
        int i = 0;

        for (char c : text.toCharArray()
        ) {
            values[i++] = c;
        }

        i = 0;
        for (int value : values
        ) {
            resultText[i++] = (char) (value + key);

        }
        return new String(resultText);
    }

    public static void EncryptText(String text, int key, String outputTextFile) throws IOException {
        File file = new File(outputTextFile);
        FileWriter writer = new FileWriter(file);

        values = new int[text.length()];
        resultText = new char[values.length];
        int i = 0;

        for (char c : text.toCharArray()
        ) {
            values[i++] = c;
        }

        i = 0;
        for (int value : values
        ) {
            resultText[i++] = (char) (value + key);

        }

        writer.write(new String(resultText));
        writer.close();
    }

    public static String DecryptText(String text, int key) {
        values = new int[text.length()];
        resultText = new char[values.length];
        int i = 0;

        for (char c : text.toCharArray()
        ) {
            values[i++] = c;
        }

        i = 0;
        for (int value : values
        ) {
            resultText[i++] = (char) (value - key);
        }
        return new String(resultText);
    }

    public static void DecryptText(String text, int key, String outputTextFile) throws IOException {
        File file = new File(outputTextFile);
        FileWriter writer = new FileWriter(file);

        values = new int[text.length()];
        resultText = new char[values.length];
        int i = 0;

        for (char c : text.toCharArray()
        ) {
            values[i++] = c;
        }

        i = 0;
        for (int value : values
        ) {
            resultText[i++] = (char) (value - key);
        }

        writer.write(new String(resultText));
        writer.close();
    }
}
