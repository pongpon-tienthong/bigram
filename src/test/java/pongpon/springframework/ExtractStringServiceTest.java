package pongpon.springframework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pongpon.springframework.services.ExtractStringService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtractStringServiceTest {

    private ExtractStringService extractStringService;

    @Before
    public void setUp() {
        extractStringService = new ExtractStringService();
    }

    @Test
    public void splitTextBySpace_TwoWords_ShouldReturnArrayOfTwoWords() {
        String expectedInput = "ABC DEF";
        Assert.assertArrayEquals(new String[]{"ABC", "DEF"}, extractStringService.splitTextBySpace(expectedInput));
    }

    @Test
    public void splitTextBySpace_TwoWordsWithMoreThenOneSpace_ShouldReturnArrayOfTwoWords() {
        String expectedInput = "ABC   DEF";
        Assert.assertArrayEquals(new String[]{"ABC", "DEF"}, extractStringService.splitTextBySpace(expectedInput));
    }

    @Test
    public void splitTextBySpace_TwoWordsWithInFrontSpace_ShouldReturnArrayOfTwoWords() {
        String expectedInput = " ABC DEF";
        Assert.assertArrayEquals(new String[]{"ABC", "DEF"}, extractStringService.splitTextBySpace(expectedInput));
    }

    @Test
    public void splitTextBySpace_TwoWordsWithBackSpace_ShouldReturnArrayOfTwoWords() {
        String expectedInput = "ABC DEF ";
        Assert.assertArrayEquals(new String[]{"ABC", "DEF"}, extractStringService.splitTextBySpace(expectedInput));
    }

    @Test
    public void splitTextBySpace_ThreeWords_ShouldReturnArrayOfThreeWords() {
        String expectedInput = "ABC DE F";
        Assert.assertArrayEquals(new String[]{"ABC", "DE", "F"}, extractStringService.splitTextBySpace(expectedInput));
    }

    @Test
    public void extractBigram_ThreeAdjacentWords_ShouldReturnTwoBigram() {
        String expectedInput = "ABC DEF GHI";
        Assert.assertArrayEquals(new String[]{"ABC DEF", "DEF GHI"}, extractStringService.extractBigram(expectedInput));
    }

    @Test
    public void extractBigram_FourAdjacentWords_ShouldReturnThreeBigram() {
        String expectedInput = "ABC DEF GHI JKL";
        Assert.assertArrayEquals(new String[]{"ABC DEF", "DEF GHI", "GHI JKL"}, extractStringService.extractBigram(expectedInput));
    }

    @Test
    public void extractBigram_FourAdjacentWordsWithMoreThanOneSpaceInBetween_ShouldReturnThreeBigram() {
        String expectedInput = "ABC  DEF   GHI    JKL";
        Assert.assertArrayEquals(new String[]{"ABC DEF", "DEF GHI", "GHI JKL"}, extractStringService.extractBigram(expectedInput));
    }

    @Test
    public void extractBigram_FourAdjacentWordsWithMoreThanOneSpaceInFront_ShouldReturnThreeBigram() {
        String expectedInput = "  ABC  DEF   GHI    JKL  ";
        Assert.assertArrayEquals(new String[]{"ABC DEF", "DEF GHI", "GHI JKL"}, extractStringService.extractBigram(expectedInput));
    }
}
