package flik;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestFlik {
    @Test
    public void test127(){
        int i = 0;
        for (int j = 0; i < 127; ++i, ++j) {
            System.out.println("i is " + i);
            assertTrue(Flik.isSameNumber(i, j));
        }
    }
    @Test
    public void test128(){
        int i = 129;
        for (int j = 129; i < 200; ++i, ++j) {
            System.out.println("i is " + i);
            boolean isSame=Flik.isSameNumber(i, j);
            assertTrue(isSame);
        }
    }
}
