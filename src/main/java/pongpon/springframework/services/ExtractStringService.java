package pongpon.springframework.services;

import org.springframework.stereotype.Service;

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
        return str.trim().split("\\s+");
    }
}
