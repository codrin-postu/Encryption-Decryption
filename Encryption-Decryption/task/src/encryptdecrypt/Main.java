package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String mode = "enc";
        String inputText = "";
        int key = 0;
        String readFilePath = "";
        String outputFilePath = "";
        String cryptAlg = "shift";

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-in":
                    readFilePath = args[i + 1];
                    break;
                case "-out":
                    outputFilePath = args[i + 1];
                    break;
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    inputText = args[i + 1];
                    break;
                case "-alg":
                    cryptAlg = args[i + 1];
            }
        }

        if (inputText.equals("") && !readFilePath.equals("")) {
            inputText = readFromFile(readFilePath);
        }

        CryptionPicker picker = new CryptionPicker();

        if (!picker.setMethod(cryptAlg)){
            return;
        }

       switch (mode) {
           case "enc":
               picker.encrypt(inputText, key, outputFilePath);
               break;
           case "dec":
               picker.decrypt(inputText, key, outputFilePath);
               break;
       }


    }

    private static String readFromFile(String readFilePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(readFilePath));
        StringBuilder text = new StringBuilder();

        while (scanner.hasNextLine()) {
            text.append(scanner.nextLine());
            if (scanner.hasNextLine()) {
                text.append("\n");
            }
        }

        scanner.close();
        return text.toString();
    }
}
