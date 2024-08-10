import org.example.Main;
import org.example.Main.WorkintechList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(ResultAnalyzer.class)
public class MainTest {

    @Test
    @DisplayName("Stack ile palindrom saayılar doğru bulunabiliyor mu ?")
    public void testPalindrome(){
        assertEquals(Main.checkForPalindrome("I did, did I?"), true);
        assertEquals(Main.checkForPalindrome("Racecar"), true);
        assertEquals(Main.checkForPalindrome("hello"), false);
        assertEquals(Main.checkForPalindrome("Was it a car or a cat I saw ?"), true);
        assertEquals(Main.checkForPalindrome("Test"), false);
        assertEquals(Main.checkForPalindrome("Welcome"), false);
    }

    @Test
    @DisplayName("convertToDecimal methodu 10 luk tabandaki sayıları 2 lik taban cevirebiliyor mu ?")
    public void testConvertToDecimal(){
        assertEquals(Main.convertDecimalToBinary(5), "101");
        assertEquals(Main.convertDecimalToBinary(6), "110");
        assertEquals(Main.convertDecimalToBinary(13), "1101");
    }

    @Test
    @DisplayName("WorkintechList doğru tipe sahip mi ?")
    public void testWorkintechListType(){
        WorkintechList list = new WorkintechList();
        assertEquals(list instanceof ArrayList, true);
        assertEquals(list instanceof List, true);
    }

    @Test
    @DisplayName("WorkintechList'e aynı eleman birden fazla kez eklenebiliyor mu ?")
    public void testWorkintechListAddMethod(){
        WorkintechList list = new WorkintechList();
        list.add("Mehmet");
        list.add("Mehmet");
        list.add("Ali");
        list.add("Ali");
        list.add("Zeynep");
        list.add("Zeynep");
        assertEquals(list.size(), 3);
    }

    @Test
    @DisplayName("WorkintechList sort metodu doğru çalışıyor mu?")
    public void testWorkintechListSortMethod(){
        WorkintechList list = new WorkintechList();
        list.add("Mehmet");
        list.add("Mehmet");
        list.add("Ali");
        list.add("Ali");
        list.add("Zeynep");
        list.add("Zeynep");
        list.sort();
        assertEquals(list.get(0), "Ali");
        assertEquals(list.get(list.size()-1), "Zeynep");
    }

    @Test
    @DisplayName("WorkintechList remove metodu doğru çalışıyor mu?")
    public void testWorkintechListRemoveMethod(){
        WorkintechList list = new WorkintechList();
        list.add("Mehmet");
        list.add("Mehmet");
        list.add("Ali");
        list.add("Ali");
        list.add("Zeynep");
        list.add("Zeynep");
        list.remove("Ali");
        assertNotEquals(list.get(0), "Ali");
        assertEquals(list.get(0), "Mehmet");
    }

}
