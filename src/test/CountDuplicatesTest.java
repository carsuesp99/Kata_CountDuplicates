package test;

import main.CountDuplicates;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountDuplicatesTest {

    /*
    Casos:
      -abcde -> 0 // Sin caracteres repetidos
      -aabcde -> 1 // Se repite la a
      -aabbcde -> 2 // Se repiten a y b
      -aabBcde -> 2 // Se repiten a y b
      -abacadae -> 1 // Se repite la a 4 veces
      -abacadaeb -> 2 // Se repiten la a y la b
      -aA11 -> 2 // Se repiten a y 1
     */
    CountDuplicates countDuplicates;
    @Before
    public void initialize(){
        countDuplicates = new CountDuplicates();
    }

    @Test
    public void does_not_find_duplicated_chars(){
        Assert.assertEquals(0, countDuplicates.count("abcde"));
    }

    @Test
    public void does_find_one_duplicated_char(){
        Assert.assertEquals(1, countDuplicates.count("aabcde"));
        Assert.assertEquals(1, countDuplicates.count("abbbbcde"));
    }

    @Test
    public void does_find_two_duplicated_char(){
        Assert.assertEquals(2, countDuplicates.count("aabbcde"));
        Assert.assertEquals(2, countDuplicates.count("abacadbe"));
    }

    @Test
    public void should_find_duplicate_for_lower_case_and_upper_case_chars(){
        Assert.assertEquals(2, countDuplicates.count("AaBbcde"));
    }

    @Test
    public void should_find_duplicate_if_char_is_number(){
        Assert.assertEquals(3, countDuplicates.count("Aa11cdee"));
    }

}
