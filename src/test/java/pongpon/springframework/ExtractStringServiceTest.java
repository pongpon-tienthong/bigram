package pongpon.springframework;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pongpon.springframework.services.ExtractStringService;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


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
        Assert.assertArrayEquals(new String[]{"abc", "def"}, extractStringService.splitTextBySpace(expectedInput));
    }

    @Test
    public void splitTextBySpace_TwoWordsWithMoreThenOneSpace_ShouldReturnArrayOfTwoWords() {
        String expectedInput = "ABC   DEF";
        Assert.assertArrayEquals(new String[]{"abc", "def"}, extractStringService.splitTextBySpace(expectedInput));
    }

    @Test
    public void splitTextBySpace_TwoWordsWithInFrontSpace_ShouldReturnArrayOfTwoWords() {
        String expectedInput = " ABC DEF";
        Assert.assertArrayEquals(new String[]{"abc", "def"}, extractStringService.splitTextBySpace(expectedInput));
    }

    @Test
    public void splitTextBySpace_TwoWordsWithBackSpace_ShouldReturnArrayOfTwoWords() {
        String expectedInput = "ABC DEF ";
        Assert.assertArrayEquals(new String[]{"abc", "def"}, extractStringService.splitTextBySpace(expectedInput));
    }

    @Test
    public void splitTextBySpace_ThreeWords_ShouldReturnArrayOfThreeWords() {
        String expectedInput = "ABC DE F";
        Assert.assertArrayEquals(new String[]{"abc", "de", "f"}, extractStringService.splitTextBySpace(expectedInput));
    }

    @Test
    public void splitTextBySpace_ThreeWordsWithFullStop_ShouldReturnArrayOfThreeWordsWithOutFullStop() {
        String expectedInput = "ABC DE F.";
        Assert.assertArrayEquals(new String[]{"abc", "de", "f"}, extractStringService.splitTextBySpace(expectedInput));
    }

    @Test
    public void extractBigram_ThreeAdjacentWords_ShouldReturnTwoBigram() {
        String expectedInput = "ABC DEF GHI";
        Assert.assertArrayEquals(new String[]{"abc def", "def ghi"}, extractStringService.extractBigram(expectedInput));
    }

    @Test
    public void extractBigram_FourAdjacentWords_ShouldReturnThreeBigram() {
        String expectedInput = "ABC DEF GHI JKL";
        Assert.assertArrayEquals(new String[]{"abc def", "def ghi", "ghi jkl"}, extractStringService.extractBigram(expectedInput));
    }

    @Test
    public void extractBigram_FourAdjacentWordsWithMoreThanOneSpaceInBetween_ShouldReturnThreeBigram() {
        String expectedInput = "ABC  DEF   GHI    JKL";
        Assert.assertArrayEquals(new String[]{"abc def", "def ghi", "ghi jkl"}, extractStringService.extractBigram(expectedInput));
    }

    @Test
    public void extractBigram_FourAdjacentWordsWithMoreThanOneSpaceInFront_ShouldReturnThreeBigram() {
        String expectedInput = "  ABC  DEF   GHI    JKL  ";
        Assert.assertArrayEquals(new String[]{"abc def", "def ghi", "ghi jkl"}, extractStringService.extractBigram(expectedInput));
    }

    @Test
    public void extractBigram_FourAdjacentWordsWithFullStop_ShouldReturnThreeBigramWithNoFullStop() {
        String expectedInput = "ABC DEF GHI JKL.";
        Assert.assertArrayEquals(new String[]{"abc def", "def ghi", "ghi jkl"}, extractStringService.extractBigram(expectedInput));
    }

    @Test
    public void countBigram_NonDuplicatedBigram_ShouldReturnHashMapWithValueBeingOne() {
        String expectedInput = "A B C D F";
        LinkedHashMap<String, Integer> actual = extractStringService.countBigram(expectedInput);

        assertEquals(4, actual.size());
        assertThat(actual, IsMapContaining.hasEntry("a b", 1));
        assertThat(actual, IsMapContaining.hasEntry("b c", 1));
        assertThat(actual, IsMapContaining.hasEntry("c d", 1));
        assertThat(actual, IsMapContaining.hasEntry("d f", 1));
    }

    @Test
    public void countBigram_DuplicatedBigram_ShouldReturnHashMapWithCorrectValues() {
        String expectedInput = "A B C A B D F";
        LinkedHashMap<String, Integer> actual = extractStringService.countBigram(expectedInput);

        assertEquals(5, actual.size());
        assertThat(actual, IsMapContaining.hasEntry("a b", 2));
        assertThat(actual, IsMapContaining.hasEntry("b c", 1));
        assertThat(actual, IsMapContaining.hasEntry("c a", 1));
        assertThat(actual, IsMapContaining.hasEntry("b d", 1));
        assertThat(actual, IsMapContaining.hasEntry("d f", 1));
    }

    @Test
    public void countBigram_StringInTheExercise_ShouldReturnHashMapWithCorrectValue() {
        String expectedInput = "The quick brown fox and the quick blue hare.";
        LinkedHashMap<String, Integer> actual = extractStringService.countBigram(expectedInput);

        assertEquals(7, actual.size());
        assertThat(actual, IsMapContaining.hasEntry("the quick", 2));
        assertThat(actual, IsMapContaining.hasEntry("quick brown", 1));
        assertThat(actual, IsMapContaining.hasEntry("brown fox", 1));
        assertThat(actual, IsMapContaining.hasEntry("fox and", 1));
        assertThat(actual, IsMapContaining.hasEntry("and the", 1));
        assertThat(actual, IsMapContaining.hasEntry("quick blue", 1));
        assertThat(actual, IsMapContaining.hasEntry("blue hare", 1));
    }
}
