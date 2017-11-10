package pongpon.springframework.services;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class ExtractStringService {

    public String[] extractBigram(String str) {

        String[] strArr = splitTextBySpace(str);
        String[] bigram = (strArr.length == 1) ? strArr : new String[strArr.length - 1];


        for(int i = 0; i < bigram.length; i++) {
            StringBuilder temp = new StringBuilder();
            temp.append(strArr[i]);
            temp.append(" ");
            temp.append(strArr[i + 1]);
            bigram[i] = temp.toString();
        }

        return bigram;
    }

    public String[] splitTextBySpace(String str) {

        str = str.toLowerCase().trim();
        if (str.endsWith(".")) {
            str = str.substring(0, str.length() - 1);
        }

        return str.split("\\s+");
    }

    public LinkedHashMap<String, Integer> countBigram(String str) {

        LinkedHashMap<String, Integer> countHashMap = new LinkedHashMap<>();
        String[] bigrams = extractBigram(str);

        for (String bigram: bigrams) {

            if(countHashMap.containsKey(bigram)) {
                countHashMap.put(bigram, countHashMap.get(bigram) + 1);
            } else {
                countHashMap.put(bigram, 1);
            }
        }

        return countHashMap;
    }
}
