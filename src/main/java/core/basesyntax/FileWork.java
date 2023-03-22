package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIAL_SYMBOL = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder text = new StringBuilder();
        File file = new File(fileName);

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] words = line.toLowerCase().split(" ");

                for (String word : words) {
                    if (word.charAt(0) == SPECIAL_SYMBOL) {
                        text.append(word).append(" ");
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Test failed! You should returned empty array.", e);
        }

        if (text.toString().isEmpty()) {
            return new String[] {};
        }
        String withoutPunctuation = text.toString().replaceAll("\\p{P}", "");
        String[] words = withoutPunctuation.split(" ");

        Arrays.sort(words);
        return words;
    }
}
