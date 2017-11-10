package pongpon.springframework;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pongpon.springframework.services.FileService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceTest {

    private FileService fileService;

    @Before
    public void setUp() {
        fileService = new FileService();
    }

    @Test
    public void readFile_Path_ShouldReturnContentInFile() throws IOException {

        URL fileUrl = getClass().getClassLoader().getResource("fileServiceTestFile.txt");
        LinkedList<String> fileContent = fileService.readFile(fileUrl.getPath());

        BufferedReader br = new BufferedReader(new FileReader(fileUrl.getPath()));

        String line;
        while ((line = br.readLine()) != null) {
            assertEquals(line, fileContent.pop());
        }
    }

}
