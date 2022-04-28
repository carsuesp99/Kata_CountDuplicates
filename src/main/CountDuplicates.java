package main;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountDuplicates {

    public int count(String word){
        int cont = 0;
        String lowerCaseWord = word.toLowerCase();
        String withoutDuplicates = removeDuplicates(lowerCaseWord);

        for(int i=0; i < withoutDuplicates.length(); i++){
            int frequency = getFrequency(lowerCaseWord, withoutDuplicates, i);
            if(frequency > 1){
                cont++;
            }
        }
        return cont;
    }

    private int getFrequency(String word, String withoutDuplicates, int i) {
        List<String> splitWord = Arrays.asList(word.split(""));
        String duplicateChars = String.valueOf(withoutDuplicates.charAt(i));
        return Collections.frequency(splitWord, duplicateChars);
    }

    private String removeDuplicates(String word){
        return Arrays.stream(word.split(""))
                .distinct()
                .collect(Collectors.joining());
    }
}
