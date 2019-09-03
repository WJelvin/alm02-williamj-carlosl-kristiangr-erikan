package Test;

import com.example.alm02.RandomFactor;
import org.junit.Test;
import static org.junit.Assert.*;


public class RandomFactorTest {
    
    RandomFactor rf = new RandomFactor();
    
    @Test
    public void testRandomNumberBetween1And10() {
        int randomNumber = rf.numberBetween1And10();
        
        for (int i = 0; i < 200; i++) {
            assertTrue(randomNumber <= 10);
            assertTrue(randomNumber > 0);
        }
        
    }
}
