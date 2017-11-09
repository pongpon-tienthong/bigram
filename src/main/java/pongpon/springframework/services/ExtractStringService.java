package pongpon.springframework.services;

import org.springframework.stereotype.Service;

@Service
public class ExtractStringService {

//    public String[] extractTwoAdjacentWord(String sentense) {
//        return new String[]{"A"};
//    }

    public String[] splitTextBySpace(String str) {
        return str.trim().split("\\s+");
    }
}
