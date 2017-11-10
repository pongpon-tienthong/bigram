package pongpon.springframework.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

@Service
public class FileService {

    public LinkedList<String> readFile(String path) throws IOException {

        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{});

        String filePath = "file:" + path;
        Resource resource = appContext.getResource(filePath);

        InputStream is = resource.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line;
        LinkedList<String> lines = new LinkedList<>();
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        br.close();

        return lines;
    }
}
