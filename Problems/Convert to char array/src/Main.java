import java.io.IOException;
import java.util.ArrayList;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        ArrayList<Character> letters = new ArrayList<Character>();
        for (String word : words
        ) {
            for (int i = 0; i < word.length(); i++) {
                letters.add(word.charAt(i));
            }
        }

        char[] finalLetters = new char[letters.size()];
        int j = 0;
        for (Character c : letters
        ) {
                finalLetters[j++] = c.charValue();
        }
        return finalLetters;
    }
}